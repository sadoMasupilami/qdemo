package at.mklug;

import at.mklug.ressources.Person;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Initializr {

    @Transactional
    void onStart(@Observes StartupEvent ev) {
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Person person = new Person("Person " + i, LocalDate.of(1990 + i, 1 + i, 1 + i));
            people.add(person);
        }
        Person.persist(people);
        System.out.println(ev);
    }
}
