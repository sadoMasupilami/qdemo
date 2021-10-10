package at.mklug;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello RESTEasy";
    }

    @GET
    @Path("oida")
    @Produces(MediaType.TEXT_PLAIN)
    public String oida() {
        return "hello oida";
    }

    @GET
    @Path("add")
    public String add(@QueryParam("num1") Integer num1, @QueryParam("num2") Integer num2) {
        Integer added = num1 + num2;
        return added.toString();
    }
}