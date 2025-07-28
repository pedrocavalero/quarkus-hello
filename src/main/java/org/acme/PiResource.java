package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/pi")
public class PiResource {

    @Inject
    PiService piService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PiResponse calculatePi(@QueryParam("decimals") int decimals) {
        String piValue = piService.calculatePi(decimals);
        return new PiResponse(piValue);
    }
}
