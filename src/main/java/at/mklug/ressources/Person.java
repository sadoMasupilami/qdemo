package at.mklug.ressources;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person extends PanacheEntity {

    public String name;
    public LocalDate birth;

}
