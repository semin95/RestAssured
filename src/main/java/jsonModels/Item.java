package jsonModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    String name;
    String description;
    List<Item2> item2;
    Request request;
    List<Object> response;

    @JsonProperty("name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("item2")
    public List<Item2> getItem2() {
        return this.item2;
    }

    public void setItem2(List<Item2> item2) {
        this.item2 = item2;
    }

    @JsonProperty("request")
    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    @JsonProperty("response")
    public List<Object> getResponse() {
        return this.response;
    }

    public void setResponse(List<Object> response) {
        this.response = response;
    }
}