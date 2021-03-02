import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class GetCollectionRequests extends CollectionRequest {

    private static String xAPIKey = Configuration.getInstance("configuration").getValue("x.API.Key");

    public GetCollectionRequests() {
        super();
    }

    public static ValidatableResponse getAllCollectionRequest() {
        RestAssured.baseURI = getBaseURI();
        RestAssured.basePath = getBasePath();
        return given().header("X-API-Key", xAPIKey)
                .when().get().then().log().all();
    }

    public static ValidatableResponse getSingleCollectionRequest(String uid) {
        RestAssured.baseURI = getBaseURI();
        RestAssured.basePath = getBasePath() + "/" + uid;
        return given().header("X-API-Key", xAPIKey)
                .when().get().then().log().all();
    }

}
