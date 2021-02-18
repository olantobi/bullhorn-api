package com.castillelabs.bullhorn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthParam implements Serializable {
    private String authorizationCode;
    private String authToken;
    private String refreshToken;

}
