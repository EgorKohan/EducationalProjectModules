package com.oauth.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ClientCredentialsModel {

    private String clientId;

    private String clientSecret;

    private String accessTokenUri;

    @JsonIgnore
    public static final String GRANT_TYPE = "client_credentials";

}
