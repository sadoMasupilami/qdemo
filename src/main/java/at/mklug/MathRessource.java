package at.mklug;

import at.mklug.ressources.MathInput;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/math")
public class MathRessource {

    @Path("add")
    @POST
    public Integer add(MathInput input) {
        return input.num1 + input.num2;
    }

    @Path("multiply")
    @POST
    public Integer multiply(MathInput input) {
        return input.num1 * input.num2;
    }
}
