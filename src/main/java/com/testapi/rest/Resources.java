package com.testapi.rest;

import com.testapi.dto.UserDO;
import com.testapi.exception.BusinessException;
import com.testapi.exception.EGeneralErrorCode;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response.Status;

@Stateless
@Path("/")
public class Resources {

    private static final Logger LOGGER = Logger.getLogger(Resources.class);

    @GET
    @Path("hello")
    public Response hello() {
        return Response
                .status(Status.OK)
                .entity("hello")
                .build();
    }

    @GET
    @Path("user/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsername(@PathParam("name") String name) {
        UserDO userDO = new UserDO().username(name);
        LOGGER.debug("username: " + userDO.getUsername());
        return Response
                .status(Status.OK)
                .entity(userDO)
                .build();
    }

    @GET
    @Path("exception")
    @Produces(MediaType.APPLICATION_JSON)
    public Response exception() throws BusinessException {
        UserDO userDO = new UserDO();
        userDO.setUsername("ss");
        if(true){
            throw BusinessException
                .create(EGeneralErrorCode.BAD_REQUEST,
                    "Throwed expected exception");
        }
        return Response
            .status(Status.OK)
            .entity(userDO)
            .build();
    }
}
