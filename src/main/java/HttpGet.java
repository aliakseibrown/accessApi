import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

public class HttpGet {

//    public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
//        JSONArray jsonArray = new JSONArray(jsonArrayStr);
//        return IntStream.range(0, jsonArray.length())
//                .mapToObj(index -> ((JSONObject)jsonArray.get(index)).optString(key))
//                .collect(Collectors.toList());
//    }

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


    public static void main(String[] args) {
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
        try {
            String strResponse = httpClient.execute(httpGet, responseHandler);

            JsonReader values= new JsonReader();

            values.makeJsonFile(strResponse);
            values.getValuesForGivenKey(strResponse, "stationName").forEach(System.out::println);


            //valeus.forEach(System.out::println);
            //getValuesForGivenKey(strResponse, "stationName").forEach(System.out::println);
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
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}

//    JSONObject obj = HTTP.toJSONObject("POST \"http://www.example.com/\" HTTP/1.1");