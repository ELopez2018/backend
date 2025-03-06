package com.seek.contexts.credencials;

import com.seek.contexts.credencials.common.AuthCredentials;
import com.seek.contexts.credencials.common.AuthResponse;
import com.seek.contexts.credencials.jwt.JwtService;
import com.seek.contexts.credencials.persistence.entities.Credencial;
import com.seek.contexts.credencials.persistence.repositories.CredencialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CredencialService {

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  CredencialRepository credencialRepository;

  @Autowired
  JwtService jwtService;

  @Autowired
  PasswordEncoder passwordEncoder;

  public AuthResponse Login (AuthCredentials credentials){
    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(credentials.getUsername(), credentials.getPassword()));
    UserDetails user = credencialRepository.findByEmail(credentials.getUsername()).orElseThrow();
    String token =  jwtService.getToken(user);
    return  AuthResponse.builder( )
            .token(token)
            .build();
  }

  public AuthResponse register(AuthCredentials credentials) {
    try {
      String encodedPassword = passwordEncoder.encode(credentials.getPassword());

      // Se crea la entidad usando un constructor con @Builder
      Credencial credencial = Credencial.builder()
              .username(credentials.getUsername())
              .email(credentials.getEmail())
              .password(encodedPassword)
              .build();

      // Se guarda en la base de datos
      Credencial credencialSaved = credencialRepository.save(credencial);

      // Generación del token
      String token = jwtService.getToken(credencialSaved);

      return AuthResponse.builder()
              .token(token)
              .build();

    } catch (Exception e) {
      throw new RuntimeException("Error al registrar el usuario", e);
    }
  }

}
