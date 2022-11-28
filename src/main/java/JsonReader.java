import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.json.JSONArray;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonReader {
    stationData data = new stationData();
    public static ObjectMapper objectMapper = getDefaultObjectMapper();

    //ObjectMapper objectMapper = new ObjectMapper();


//    public List<stationIndexLevel> stream(){
//        List <String> namesNewJava = students.stream()
//                .map(student -> student.getName())
//                .filter (name-> name.startsWith("A"))
//                .collect (Collectors.toList());
//    }

    public static ObjectMapper getDefaultObjectMapper() {
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        defaultObjectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return defaultObjectMapper;
    }
    public static void serializationToFile(String str, String fileName) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter out = null;
        try {
            fw = new FileWriter("src/main/resources/"+fileName+".json", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.println(str);
            out.close();
            //System.out.println("file \"" +fileName+ ".json\" has been created ");
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


    public static stationData[] deserializationToObject(String fileName) throws IOException { //deserialization
        File jsonFile  = new File("src/main/resources/" + fileName + ".json");
        //stationData stationDataList = objectMapper.readValue(jsonFile, stationData.class); //reads one jsonObject
        stationData[] stationDataList = objectMapper.readValue(jsonFile,                     //reads an array of jsonObjects
                stationData[].class);
        return stationDataList;
    }

    public static void printStations(stationData[] stationDataList) throws IOException {
        //stationData[] stationDataList = jsonToObject();
        for(stationData a: stationDataList){
            System.out.println(a.getStationName() + " " +  a.getId());
        }
    }

    public int returnIdentification(stationData[] stationDataList, String stationName) throws IOException {
        for (stationData a :stationDataList) {
            if(stationName.equals(a.getStationName())){
                return a.getId();
            }
        }
        return 0;
    }

    public String GETindexLevel(int stationIndex) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        org.apache.http.client.methods.HttpGet httpGet = new org.apache.http.client.methods.HttpGet("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/"+ stationIndex);
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
        return httpClient.execute(httpGet, responseHandler);
    }

    public void createPDF(String fileName) throws IOException, DocumentException {

        File jsonFile = new File("src/main/resources/"+fileName+".json").getAbsoluteFile();
        ObjectMapper mapper = new ObjectMapper();
        // enable pretty printing
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        // read map from file
        MapType mapType = mapper.getTypeFactory().constructMapType(Map.class, String.class, Object.class);
        Map<String, Object> map = mapper.readValue(jsonFile, mapType);

        // generate pretty JSON from map
        String json = mapper.writeValueAsString(map);
        // split by system new lines
        String[] strings = json.split(System.lineSeparator());

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.COURIER, 12);
        contentStream.beginText();
        contentStream.setLeading(14.5f);
        contentStream.newLineAtOffset(25, 725);
        for (String string : strings) {
            contentStream.showText(string);
            // add line manually
            contentStream.newLine();
        }
        contentStream.endText();
        contentStream.close();

        document.save("src/main/resources/PDF" + fileName + ".pdf");
        document.close();
    }

    public static stationIndexLevel deserializationIndexLevel(String fileName) throws IOException { //deserialization
        File jsonFile  = new File("src/main/resources/" + fileName + ".json");
        stationIndexLevel indexLevel = objectMapper.readValue(jsonFile, stationIndexLevel.class); //reads one jsonObject
//        stationData[] stationDataList = objectMapper.readValue(jsonFile,                     //reads an array of jsonObjects
//                stationData[].class);
        return indexLevel;
    }
}
