package com.castillelabs.bullhorn.controller;

import com.castillelabs.bullhorn.model.AuthParam;
import com.castillelabs.bullhorn.service.DataStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final DataStore dataStore;

    @RequestMapping("/redirect-url")
    public ResponseEntity<?> redirectUrl(@RequestParam(name = "code", required = false, defaultValue = "") String authorizationCode,
                                         @RequestParam(name = "state", required = false, defaultValue = "") String state) {
        log.info("Authorization code {}, state {}", authorizationCode, state);
        Map<String, AuthParam> mapStore = dataStore.getMapStore();

        AuthParam authParam = AuthParam.builder()
                .authorizationCode(authorizationCode).build();
        mapStore.put(state, authParam);

        return ResponseEntity.ok().build();
    }
}
