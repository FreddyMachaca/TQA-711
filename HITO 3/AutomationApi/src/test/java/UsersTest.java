import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

public class UsersTest {

    private static String accessToken;

    @Test
    @Order(1)
    @DisplayName("LoginUser")
    public void testLoginUser() {
        JSONObject requestParams = new JSONObject();
        requestParams.put("username", "emilys");
        requestParams.put("password", "emilyspass");
        requestParams.put("expiresInMins", 30);

        Response response = given()
                .contentType("application/json")
                .body(requestParams.toString())
                .when()
                .post("https://dummyjson.com/user/login")
                .then()
                .statusCode(200)
                .extract().response();

        accessToken = response.jsonPath().getString("accessToken");
        String refreshToken = response.jsonPath().getString("refreshToken");

        // Verificar que el AccessToken y RefreshToken no sean nulos
        assertNotNull(accessToken, "El AccessToken no debe ser nulo");
        assertNotNull(refreshToken, "El RefreshToken no debe ser nulo");
    }


    @Test
    @Order(2)
    @DisplayName("GetAllUsers")
    public void testGetAllUsers() {
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("https://dummyjson.com/users")
                .then()
                .statusCode(200)
                .extract().response();

        // Verificar que la respuesta contenga una lista de usuarios
        assertTrue(response.jsonPath().getList("users").size() > 0, "Debe haber al menos un usuario");
        System.out.println("Cantidad de usuarios: " + response.jsonPath().getList("users").size());
    }

    @Test
    @Order(3)
    @DisplayName("GetSingleUser")
    public void testGetSingleUser() {
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get("https://dummyjson.com/users/1")
                .then()
                .statusCode(200)
                .extract().response();

        // Verificar que la respuesta contenga los detalles del usuario
        assertEquals("Emily", response.jsonPath().getString("firstName"), "El nombre del usuario debería ser Emily");
        System.out.println("Nombre del usuario: " + response.jsonPath().getString("firstName"));
    }

    @Test
    @Order(4)
    @DisplayName("AddUser")
    public void testAddUser() {
        JSONObject newUser = new JSONObject();
        newUser.put("firstName", "Muhammad");
        newUser.put("lastName", "Ovi");
        newUser.put("age", 25);

        Response response = given()
                .contentType("application/json")
                .body(newUser.toString())
                .when()
                .post("https://dummyjson.com/users/add")
                .then()
                .statusCode(201)
                .extract().response();

        // Verificar que el usuario se haya creado y que la respuesta contenga el nuevo ID
        assertNotNull(response.jsonPath().getString("id"), "El id del usuario creado no debe ser nulo");
        System.out.println("ID del usuario creado: " + response.jsonPath().getString("id"));
    }

    @Test
    @Order(5)
    @DisplayName("UpdateUser")
    public void testUpdateUser() {
        JSONObject updateUser = new JSONObject();
        updateUser.put("lastName", "Owais");

        Response response = given()
                .contentType("application/json")
                .body(updateUser.toString())
                .when()
                .put("https://dummyjson.com/users/2")
                .then()
                .statusCode(200)
                .extract().response();

        // Verificar que el apellido del usuario haya sido actualizado
        assertEquals("Owais", response.jsonPath().getString("lastName"), "El apellido del usuario no se actualizó correctamente");
        System.out.println("Apellido del usuario actualizado: " + response.jsonPath().getString("lastName"));
    }

    @Test
    @Order(6)
    @DisplayName("DeleteUser")
    public void testDeleteUser() {
        Response response = given()
                .when()
                .delete("https://dummyjson.com/users/2")
                .then()
                .statusCode(200)
                .extract().response();

        // Verificar que el usuario se haya marcado como eliminado
        assertTrue(response.jsonPath().getBoolean("isDeleted"), "El usuario debería estar marcado como eliminado");
        System.out.println("Usuario eliminado: " + response.jsonPath().getBoolean("isDeleted"));
    }
}
