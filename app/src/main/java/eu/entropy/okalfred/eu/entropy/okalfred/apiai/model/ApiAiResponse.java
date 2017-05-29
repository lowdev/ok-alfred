package eu.entropy.okalfred.eu.entropy.okalfred.apiai.model;

import com.google.gson.annotations.Expose;

public class ApiAiResponse {
    @Expose
    private ApiAiResult result;

    public String getSpeech() {
        return result.getFulfillment().getSpeech();
    }
    public String getAction() {return result.getAction(); }
}
