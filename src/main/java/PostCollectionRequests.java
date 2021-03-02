import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jsonModels.Root;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class PostCollectionRequests extends CollectionRequest {

    private static String xAPIKey = Configuration.getInstance("configuration").getValue("x.API.Key");
    private static String jsonCreateCollectionPath = "src/main/resources/createCollectionBody.json";

    public PostCollectionRequests() {
        super();
    }

    public static ValidatableResponse createCollection(String collectionName) throws IOException {
        RestAssured.baseURI = getBaseURI();
        RestAssured.basePath = getBasePath();

        ObjectMapper objectMapper = new ObjectMapper();
        Root root = objectMapper.readValue(new File(jsonCreateCollectionPath), Root.class);
        root.getCollection().getInfo().setName(collectionName);

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String jsonBody = objectWriter.writeValueAsString(root).replace("item2", "item");

        return given().header("X-API-Key", xAPIKey)
                .body(jsonBody).when().post().then().log().all();
    }
}
