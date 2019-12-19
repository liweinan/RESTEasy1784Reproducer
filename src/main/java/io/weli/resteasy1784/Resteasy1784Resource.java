package io.weli.resteasy1784;

import javax.servlet.http.HttpServletResponse;
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
    public void errorAfterFlushWithoutBody(@Context HttpServletResponse response) throws IOException {
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
