package at.mklug;

import at.mklug.ressources.MathInput;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class MathResourceTest {

    @Test
    public void testAddEndpoint() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MathInput(3,7))
                .when().post("/math/add")
                .then()
                .statusCode(200)
                .body(is("10"));
    }

    @Test
    public void testMultiplyEndpoint() {
        given()
                .contentType(MediaType.APPLICATION_JSON)
                .body(new MathInput(3,7))
                .when().post("/math/multiply")
                .then()
                .statusCode(200)
                .body(is("21"));
    }
}