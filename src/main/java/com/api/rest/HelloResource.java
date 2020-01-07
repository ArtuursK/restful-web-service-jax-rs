package com.api.rest;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Stateless
@Path("/secured")
public class HelloResource {

    private static final Logger LOGGER = Logger.getLogger(HelloResource.class);

    @GET
    @Path("hello")
    public Response hello() {

        return Response
                .status(Response.Status.OK)
                .entity("hello")
                .build();
    }

}
