package at.mklug;

import at.mklug.ressources.MathInput;
import at.mklug.ressources.Person;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import java.time.LocalDate;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class PersonResourceTest {

    Long id;

    @Test
    public void testEndpoints() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new Person("sepp", LocalDate.now()))
                .when().post("/person")
                .then()
                .statusCode(201);
    }
}