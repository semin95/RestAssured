import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import jsonModels.Root;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class CollectionsService {

    private static String xAPIKey = Configuration.getInstance("configuration").getValue("x.API.Key");
    private static String baseURI = Configuration.getInstance("configuration").getValue("baseURI");
    private static String basePath = Configuration.getInstance("configuration").getValue("basePath");
    private static String jsonCreateCollectionPath = "src/main/resources/createCollectionBody.json";

    public static ValidatableResponse getAllCollectionRequest() {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;
        return given().header("X-API-Key", xAPIKey)
                .when().get().then().log().all();
    }

    public static ValidatableResponse getSingleCollectionRequest(String uid) {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath + "/" + uid;
        return given().header("X-API-Key", xAPIKey)
                .when().get().then().log().all();
    }

    public static ValidatableResponse createCollection(String collectionName) throws IOException {
        RestAssured.baseURI = baseURI;
        RestAssured.basePath = basePath;

        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(new File(jsonCreateCollectionPath), Root.class);
        root.getCollection().getInfo().setName(collectionName);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonBody = objectWriter.writeValueAsString(root).replace("item2", "item");

        return given().header("X-API-Key", xAPIKey)
                .body(jsonBody).when().post().then().log().all();
    }

}
