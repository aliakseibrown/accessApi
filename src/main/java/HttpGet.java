import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.json.JSONArray;
import org.json.JSONObject;


import java.lang.Object;

import org.json.JSONTokener;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HttpGet {

    public static String getIndexFromJSON (String jsonArrayStr, String key) {
        System.out.println("full Array: " + jsonArrayStr);
        String idNum = null;

        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            String nameStation = jsonObject.optString("city");
            System.out.println("nameStation: " + nameStation);
//            if(nameStation.equals(key)) {
//                idNum = jsonArray.getJSONObject(i).optString("id");
//                return idNum;
//            }
        }
        //String loudScreaming = json.getJSONObject(key).getString("id");
        return idNum;

    }


    public static void main(String[] args) throws IOException {
        /* Create object of CloseableHttpClient */
        CloseableHttpClient httpClient = HttpClients.createDefault();
        org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet("https://api.gios.gov.pl/pjp-api/rest/station/findAll");
        httpGet.addHeader("custom-key", "programming");
        ResponseHandler<String> responseHandler = new ResponseHandler<String>() {

            @Override
            public String handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                int httpResponseCode = httpResponse.getStatusLine().getStatusCode();
                if (httpResponseCode >= 200 && httpResponseCode < 300) {
                    /* Convert response to String */
                    HttpEntity entity = httpResponse.getEntity();
                    return entity != null ? EntityUtils.toString(entity) : null;
                } else {
                    System.out.println("Response code: " + httpResponseCode);
                    return null;
                }
            }
        };
        String strResponse = httpClient.execute(httpGet, responseHandler);

        JsonReader jsonMethods= new JsonReader(); //created method JsonReader

//        String str = "{\"id\": \"123\"}" ;
//        JsonNode node =  jsonMethods.parse(str);
//        System.out.println(node.get("id").asText());

        jsonMethods.makeJsonFile(strResponse);
        jsonMethods.getValuesForGivenKey(strResponse, "stationName").forEach(System.out::println);

        //values.returnIdentification();

        String s = null;
//            while(true){
//                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//                 s = br.readLine();
//                 if( s.equals("quit")) break;
//                 System.out.println("ID: " + getIndexFromJSON(strResponseCopy, s));
//                 //int id = getValuesForGivenKey(strResponse, "stationName").forEach(System.out::println);
//                 //i = String.valueOf(Integer.parseInt(s));
//
//                System.out.println("Response: " + s);
//            }
        //System.out.println("Response: " + strResponse);

    }
}

//    JSONObject obj = HTTP.toJSONObject("POST \"http://www.example.com/\" HTTP/1.1");