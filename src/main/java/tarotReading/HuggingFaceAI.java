package tarotReading;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class HuggingFaceAI {
    public String HuggingFaceModel(String message) throws IOException, InterruptedException {
        String API_Key = "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";
        //String model = "google/gemma-2-2b-it";
        String model = "microsoft/Phi-3.5-mini-instruct";
        String url = "https://api-inference.huggingface.co/models/" + model;

        String body = "{\"inputs\": \"" + message + "\"}";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + API_Key)
                .POST(HttpRequest.BodyPublishers.ofString(body))
                .build();

        var client = HttpClient.newHttpClient();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Thread.sleep(2000);

            //System.out.println("Response Code: " + response.statusCode());

            String responseBody = response.body();
            //return responseBody;


            JSONArray jsonArray = new JSONArray(responseBody);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String generatedText = jsonObject.getString("generated_text");
            return generatedText;


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error occurred while generating text.";
        }


    }
}
