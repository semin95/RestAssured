package jsonModels;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Body {
    String mode;
    String raw;
    List<Object> formdata;

    @JsonProperty("mode")
    public String getMode() {
        return this.mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("raw")
    public String getRaw() {
        return this.raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @JsonProperty("formdata")
    public List<Object> getFormdata() {
        return this.formdata;
    }

    public void setFormdata(List<Object> formdata) {
        this.formdata = formdata;
    }
}