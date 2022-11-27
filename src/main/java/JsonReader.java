import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

    public static ObjectMapper objectMapper = getDefaultObjectMapper();

    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;
    }
    public static void makeJsonFile(String str) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("/srs/output.json", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(str);
            out.close();
            System.out.println("file \"output.json\" has been created ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file couldn't be created");
        }
    }
    public static List<String> getValuesForGivenKey(String jsonArrayStr, String key) {
        JSONArray jsonArray = new JSONArray(jsonArrayStr);
        return IntStream.range(0, jsonArray.length())
                .mapToObj(index -> ((org.json.JSONObject)jsonArray.get(index)).optString(key))
                .collect(Collectors.toList());
    }
    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }
    public static Map<String, String> returnIdentification(String jsonArrayStr) {
        List<String> idList;
        List<String> stationList;
        Map<String, String> map = new HashMap<String, String>();

        idList = getValuesForGivenKey(jsonArrayStr, "id");
        stationList = getValuesForGivenKey(jsonArrayStr, "stationName");
        for (int i = 0; i < idList.size(); i++) {
            map.put(stationList.get(i), idList.get(i));
        }
        return map;
    }
}

// [{
//        "id": 14,
//        "stationName": "Działoszyn",
//        "gegrLat": "50.972167",
//        "gegrLon": "14.941319",
//        "city": {
//        "id": 192,
//        "name": "Działoszyn",
//        "commune": {
//        "communeName": "Bogatynia",
//        "districtName": "zgorzelecki",
//        "provinceName": "DOLNOŚLĄSKIE"
//        }
//        },
//        "addressStreet": null
//        }]