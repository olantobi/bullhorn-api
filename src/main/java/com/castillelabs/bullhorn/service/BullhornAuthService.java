package com.castillelabs.bullhorn.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "${bullhorn.url}")
public interface BullhornAuthService {

    @PostMapping("/oauth/authorize")
    ResponseEntity<?> requestAuthCode(@RequestParam("client_id") String clientId, @RequestParam("response_type") String responseType,
          @RequestParam("action") String action, @RequestParam("username") String username, @RequestParam("password") String password,
              @RequestParam("redirect_url") String redirectUrl, @RequestParam("state") String state);
}
