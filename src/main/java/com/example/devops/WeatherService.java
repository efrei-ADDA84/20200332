package com.example.devops;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


public class WeatherService {
    String uglyJsonString = "{\"one\":\"AAA\",\"two\":[\"BBB\",\"CCC\"],\"three\":{\"four\":\"DDD\",\"five\":[\"EEE\",\"FFF\"]}}";
    public String getWeather(String latitude, String longitude) {

        String responseString = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        final String API_TOKEN = "";

        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?lat=" + latitude + "&lon=" + longitude + "&appid=" + API_TOKEN;
            HttpGet httpGet = new HttpGet(url);

            CloseableHttpResponse response = httpClient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                responseString = EntityUtils.toString(entity);
            } finally {
                response.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // pretty print the response
        assert responseString != null;
        responseString = responseString.replace(",", ",<br>");

        return responseString;
    }


}
