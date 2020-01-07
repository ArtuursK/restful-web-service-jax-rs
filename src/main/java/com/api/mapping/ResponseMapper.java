package com.api.mapping;

import com.api.dto.JWTOutputDO;
import com.api.dto.UserDO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Calendar;

public class ResponseMapper {

    private static final int EXPIRES_IN_DAYS = 10;
    private static final String TOKEN_ISSUER = "001AK";

    //TODO: specify secret key and algorithm in gradle.properties EnvExtractor.getValue();
    private static final String SECRET_KEY = "TempSecret";
    private static final Algorithm ALGORITHM;

    private ResponseMapper() {
        throw new IllegalStateException("Cannot instantiate mapping class");
    }

    static {
        ALGORITHM = Algorithm.HMAC512(SECRET_KEY);
    }

    public static JWTOutputDO toRestOAuth2JwtTokenDO(UserDO user) {
        Calendar now = Calendar.getInstance();
        Calendar expiration = Calendar.getInstance();
        expiration.add(Calendar.DAY_OF_MONTH, EXPIRES_IN_DAYS);

        String token = JWT.create()
                .withIssuer(TOKEN_ISSUER)
                .withIssuedAt(now.getTime())
                .withExpiresAt(expiration.getTime())
                .withSubject(user.getUsername())
                .sign(ALGORITHM);

        JWTOutputDO tokenObject = new JWTOutputDO();
        tokenObject.setAccessToken(token);
        tokenObject.setExpiresIn((expiration.getTimeInMillis() - now.getTimeInMillis()) / 1000);
        tokenObject.setTokenType("bearer");

        return tokenObject;
    }
}
