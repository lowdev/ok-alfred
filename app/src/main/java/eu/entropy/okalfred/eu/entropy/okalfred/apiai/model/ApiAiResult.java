package eu.entropy.okalfred.eu.entropy.okalfred.apiai.model;

import com.google.gson.annotations.Expose;

public class ApiAiResult {
    @Expose
    private ApiAiFulfillment fulfillment;

    @Expose
    private String action;

    public ApiAiFulfillment getFulfillment() {
        return fulfillment;
    }

    public String getAction() {
        return action;
    }
}
