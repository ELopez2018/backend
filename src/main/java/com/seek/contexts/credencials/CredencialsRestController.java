package com.seek.contexts.credencials;


import com.seek.contexts.credencials.common.AuthCredentials;
import com.seek.contexts.credencials.common.AuthResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class CredencialsRestController {

    @Autowired
    CredencialService credencialService;

    @Autowired
    PasswordEncoder passwordEncoder;



    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthCredentials credentials) {
       log.info("passwordEncoder: " + passwordEncoder.encode(credentials.getPassword()));
        return ResponseEntity.ok(credencialService.Login(credentials));
    }

    @PostMapping("/register")
    public  ResponseEntity<AuthResponse>  register( @RequestBody AuthCredentials credentials ) {
        return  ResponseEntity.ok(credencialService.register(credentials)) ;
    }

}
