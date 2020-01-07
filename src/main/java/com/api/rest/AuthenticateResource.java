package com.api.rest;

import com.api.dto.JWTInputDO;
import com.api.dto.UserDO;
import com.api.mapping.ResponseMapper;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/auth")
public class AuthenticateResource {

    private static final Logger LOGGER = Logger.getLogger(AuthenticateResource.class);

    @GET
    @Path("token")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewToken(JWTInputDO jwtInputDO) {

        //TODO: get user from DB by unique username,
        UserDO userDO = new UserDO().username(jwtInputDO.getUsername());

        //TODO: hash and validate the input passcode

        if(userDO == null){
            //throw exception
        }

        return Response
                .status(Response.Status.OK)
                .entity(ResponseMapper.toRestOAuth2JwtTokenDO(userDO))
                .build();
    }

}
