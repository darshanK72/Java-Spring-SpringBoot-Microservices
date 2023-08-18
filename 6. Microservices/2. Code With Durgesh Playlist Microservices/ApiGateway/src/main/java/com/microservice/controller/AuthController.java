package com.microservice.controller;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.AuthResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @GetMapping("/login")
    public ResponseEntity<AuthResponse> login( @RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient client, @AuthenticationPrincipal OidcUser user,Model model)
    {
    	System.out.println("Inside auth/login");
       System.out.println(client.getRefreshToken());
       
        AuthResponse response = AuthResponse.builder()
                                    .userId(user.getEmail())
                                    .accessToken(client.getAccessToken().getTokenValue())
                                    .refreshToken(client.getRefreshToken().getTokenValue())
                                    .expireAt(client.getAccessToken().getExpiresAt().getEpochSecond())
                                    .authories(user.getAuthorities().stream().map(authority -> {
                                        return authority.getAuthority();
                                    }).collect(Collectors.toList()))
                                    .build();

        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
    
}
