import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import junit.framework.TestCase;
import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonReaderTest extends TestCase {


    public stationData testStation1 = new stationData();
    public communeData testStationCityCommune1 = new communeData();
    public cityData testStationCity1 = new cityData();


    stationData testStation2 = new stationData();
    communeData testStationCityCommune2 = new communeData();
    cityData testStationCity2 = new cityData();

    public List<stationData> testArray = new ArrayList<>();
    public stationData[] testObjects;

    @Before
    public void creatingTestArray() throws JsonProcessingException {
        //test1
        testStation1.setId(1);
        testStation1.setGegrLat((float) 0.111);
        testStation1.setGegrLon((float) 0.211);
        testStation1.setStationName("Happiness");
        testStation1.setAddressStreet("1");
        testStationCity1.setId(1);
        testStationCity1.setName("Happy");

        testStationCityCommune1.setCommuneName("CommuneHappy");
        testStationCityCommune1.setDistrictName("DistrictHappy");
        testStationCityCommune1.setProvinceName("ProvinceHappy");
        testStationCity1.setCommune(testStationCityCommune1);
        testStation1.setCity(testStationCity1);

        //test2
        testStation2.setId(2);
        testStation2.setGegrLat((float) 0.222);
        testStation2.setGegrLon((float) 0.322);
        testStation2.setStationName("Happiness");
        testStation2.setAddressStreet("2");
        testStationCity2.setId(2);
        testStationCity2.setName("Sad");
        testStationCityCommune2.setCommuneName("CommuneSad");
        testStationCityCommune2.setDistrictName("DistrictSad");
        testStationCityCommune2.setProvinceName("ProvinceSad");
        testStationCity2.setCommune(testStationCityCommune2);
        testStation2.setCity(testStationCity2);

        testArray.add(testStation1);
        testArray.add(testStation2);
        testObjects[0] = testStation1;
        testObjects[1] = testStation2;

    }

        @Test
    public void testSerializationToFile() throws JsonProcessingException {
        //System.out.println(testArray);
            System.out.println("1235738");
            System.out.println(testStation1.getId());
//            for(stationData a: testStation1){
//                System.out.println(a.toString());
//           }
        //JsonReader.serializationToFile(, "testStations");
    }
    @Test
    public void testDeserializationToObject() throws IOException {
        JsonReader.deserializationToObject("testStations");

    }

    @Test
    public void testReturnIdentification() {
    }

    @Test
    public void testGETindexLevel() {
    }


    @Test
    public void testPrintStations() throws IOException {
        JsonReader.printStations(testObjects);
    }
}