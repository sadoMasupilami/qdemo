package at.mklug;

import at.mklug.ressources.Person;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;

@Path("/person")
public class PersonResource {

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
    public Person add(Person person) {
        person.persist();
        return person;
    }

    @DELETE
    @Transactional
    public void delete(Person person) {
        Person.deleteById(person.id);
    }
}
