package com.example.zingfakebackend.model.payload.request;

public class RefreshTokenRequest {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public RefreshTokenRequest() {
    }
}
