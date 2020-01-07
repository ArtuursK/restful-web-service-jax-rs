package com.api.dto;

import java.util.Objects;

public class JWTInputDO extends DtoObj {

    private String username;

    private String passcode;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public JWTInputDO username(String username){
        this.username = username;
        return this;
    }

    public String getPasscode() {
        return passcode;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public JWTInputDO passcode(String passcode){
        this.passcode = passcode;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        final JWTInputDO that = (JWTInputDO) o;
        return Objects.equals(username, that.username) &&
               Objects.equals(passcode, that.passcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, passcode);
    }

    @Override
    protected StringBuilder fieldsToString() {
        final StringBuilder sb = super.fieldsToString();
        appendField(sb, "username", username);
        appendField(sb, "password", passcode);
        return sb;
    }
}
