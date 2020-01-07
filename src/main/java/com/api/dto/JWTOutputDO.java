package com.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class JWTOutputDO extends DtoObj {

    @JsonProperty("accessToken")
    private String accessToken;

    @JsonProperty("expiresIn")
    private Long expiresIn;

    @JsonProperty("tokenType")
    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    @JsonProperty("accessToken")
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    @JsonProperty("expiresIn")
    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    @JsonProperty("tokenType")
    public void setTokenType(String tokenType ) {
        this.tokenType = tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        final JWTOutputDO that = (JWTOutputDO) o;
        return Objects.equals(accessToken, that.accessToken) &&
               Objects.equals(expiresIn, that.expiresIn) &&
               Objects.equals(tokenType, that.tokenType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, expiresIn, tokenType);
    }

    @Override
    protected StringBuilder fieldsToString() {
        final StringBuilder sb = super.fieldsToString();
        appendField(sb, "accessToken", accessToken);
        appendField(sb, "expiresIn", expiresIn);
        appendField(sb, "tokenType", tokenType);
        return sb;
    }
}
