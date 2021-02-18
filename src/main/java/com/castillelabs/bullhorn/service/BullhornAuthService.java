package com.castillelabs.bullhorn.service;

import com.castillelabs.bullhorn.config.FeignConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(url = "${bullhorn.url}", name = "${bullhorn.name:bullhorn}", configuration = FeignConfiguration.class)
public interface BullhornAuthService {

    @GetMapping(value = "/oauth/authorize", produces = MediaType.TEXT_HTML_VALUE)
    @ResponseBody
    String requestAuthCode(@RequestParam("client_id") String clientId, @RequestParam("response_type") String responseType,
          @RequestParam("action") String action, @RequestParam("username") String username, @RequestParam("password") String password,
              @RequestParam("redirect_url") String redirectUrl, @RequestParam("state") String state);
}
