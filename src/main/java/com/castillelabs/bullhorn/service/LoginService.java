package com.castillelabs.bullhorn.service;

import com.castillelabs.bullhorn.model.Login;

public interface LoginService {
    void requestAuthorizationCode(Login login);
}
