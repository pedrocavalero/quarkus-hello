package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/fibonacci")
public class FibonacciResource {

    private final Fibonacci fibonacci = new Fibonacci();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response calculateFibonacci(@QueryParam("n") Integer n) {
        if (n == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("{\"error\":\"Query parameter 'n' is required.\"}")
                           .type(MediaType.APPLICATION_JSON)
                           .build();
        }
        try {
            long result = fibonacci.calculate(n);
            FibonacciResponse response = new FibonacciResponse(n, result);
            return Response.ok(response).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("{\"error\":\"" + e.getMessage() + "\"}")
                           .type(MediaType.APPLICATION_JSON)
                           .build();
        }
    }
} 