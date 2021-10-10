package at.mklug;

import at.mklug.ressources.Person;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/person")
public class PersonResource {

    private static final Logger LOG = Logger.getLogger(PersonResource.class);

    @GET
    public List<Person> getPeople() {
        return Person.listAll();
    }

    @GET
    @Path("/{id}")
    public Person getPerson(@PathParam Long id) {
        return Person.findById(id);
    }

    @POST
    @Transactional
    public Response add(Person person) {
        person.persist();
        return Response.created(URI.create("/person/" + person.id)).build();
    }

    @DELETE
    @Transactional
    public Response delete(Person person) {
        Boolean deleted = Person.deleteById(person.id);
        if (!deleted) {
            String message = String.format("DELETE failed, person with id: %s was not found", person.id);
            LOG.info(message);
            return Response.status(404, message).build();
        } else {
            return Response.ok().build();
        }
    }
}
