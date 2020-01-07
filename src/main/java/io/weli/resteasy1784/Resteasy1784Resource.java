package io.weli.resteasy1784;

import org.jboss.resteasy.plugins.server.servlet.HttpServletResponseWrapper;
import org.jboss.resteasy.spi.HttpResponse;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/1784")
public class Resteasy1784Resource {
    @Path("ErrorAfterFlushWithoutBody")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public void errorAfterFlushWithoutBody(@Context HttpResponse response) throws IOException {
        response.setAbortWithException(true);
        System.out.println("*** " + response.getClass() + " *** " + response.abortWithException());
        response.getOutputStream().flush();
        throw new IOException("a " +
                "strange io error");
    }


    @Path("NormalError")
    @GET
    public String normalError() throws IOException {
        throw new IOException();
    }
}
