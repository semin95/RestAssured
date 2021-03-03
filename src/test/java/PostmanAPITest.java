import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.json.JSONObject;

public class PostmanAPITest {

    private String collectionName = "Sample collection test";
    private String UID = "14763329-993d31db-29f0-49a4-b268-5033901f9b96";
    private String singleCollectionName = "Sample Collection";
    private String wrongUID = "12345678";
    private String errorMessage = "We could not find the collection you are looking for";

    @Test
    void getAllCollections() {
        Assert.assertNotNull(CollectionsService.getAllCollectionRequest().statusCode(200).extract().asString());
    }

    @Test
    void getSingleCollection() {
        String jsonResponse = CollectionsService.getSingleCollectionRequest(UID).statusCode(200).extract().asString();
        Assert.assertEquals(new JSONObject(jsonResponse).getJSONObject("collection").getJSONObject("info").get("name"), singleCollectionName);
    }

    @Test
    void createColletion() throws IOException {
        String jsonResponse = CollectionsService.createCollection(collectionName).statusCode(200).extract().asString();
        Assert.assertEquals(new JSONObject(jsonResponse).getJSONObject("collection").get("name"), collectionName);
    }

    @Test
    void createThreeCollectionsWithUniqueNames() throws IOException {
        for (int i = 0; i < 3; i++) {
            DateFormat dateFormat = new SimpleDateFormat("ddMMyyhhmmssSSS");
            String uniqueCollectionName = "Sample " + dateFormat.format(Calendar.getInstance().getTime());
            String jsonResponse = CollectionsService.createCollection(uniqueCollectionName).statusCode(200).extract().asString();
            Assert.assertEquals(new JSONObject(jsonResponse).getJSONObject("collection").get("name"), uniqueCollectionName);
        }
    }

    @Test
    void getSingleCollectionWrongUID() {
        String jsonResponse = CollectionsService.getSingleCollectionRequest(wrongUID).statusCode(404).extract().asString();
        Assert.assertEquals(new JSONObject(jsonResponse).getJSONObject("error").get("message"), errorMessage);
    }

}
