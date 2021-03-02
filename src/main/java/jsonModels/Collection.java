package jsonModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Collection {
    List<Object> variables;
    Info info;
    List<Item> item;

    @JsonProperty("variables")
    public List<Object> getVariables() {
        return this.variables;
    }

    public void setVariables(List<Object> variables) {
        this.variables = variables;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return this.info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    @JsonProperty("item")
    public List<Item> getItem() {
        return this.item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
