package com.castillelabs.bullhorn.service;

import com.castillelabs.bullhorn.enumeration.Action;
import com.castillelabs.bullhorn.enumeration.ResponseType;
import com.castillelabs.bullhorn.model.Login;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class DefaultLoginService implements LoginService {

    private final BullhornAuthService bullhornAuthService;

    @Value("${bullhorn.client-id}")
    private String clientId;

    @Value("${bullhorn.client-secret}")
    private String clientSecret;

    @Override
    public void requestAuthorizationCode(Login login) {
        String redirectUrl = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/redirect-url").build().toUriString();

        bullhornAuthService.requestAuthCode(clientId, ResponseType.code.name(),
                Action.Login.name(), login.getUsername(), login.getPassword(), redirectUrl, login.getUsername());
    }
}
