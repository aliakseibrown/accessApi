import java.time.LocalDateTime;

public class stationIndexLevel {

    int id;
    stIndexLevelData stIndexLevel;

//    no2IndexLevel no2IndexLevel;
//    so2IndexLevel so2IndexLevel;
//    pm10IndexLevel pm10IndexLevel;
//    pm25IndexLevel pm25IndexLevel;
//    o3IndexLevel o3IndexLevel;

    LocalDateTime stCalcDate;
    LocalDateTime stSourceDataDate;
    LocalDateTime so2CalcDate;
    LocalDateTime so2SourceDataDate;
    LocalDateTime no2CalcDate;
    LocalDateTime no2SourceDataDate;
    LocalDateTime pm10CalcDate;
    LocalDateTime pm10SourceDataDate;
    LocalDateTime pm25CalcDate;
    LocalDateTime pm25SourceDataDate;
    LocalDateTime o3CalcDate;
    LocalDateTime o3SourceDataDate;

    public int getId(){
        return id;
    }
    public LocalDateTime getStCalcDate(){
        return stCalcDate;
    }
    public stIndexLevelData getStIndexLevel() {
        return stIndexLevel;
    }


    public stationIndexLevel() { };
}
//
//{       "id":52,
//        "stCalcDate":"2022-11-27 19:20:09",
//        "stIndexLevel":{
//              "id":1,
//              "indexLevelName":"Dobry"
//               },
//        "stSourceDataDate":"2022-11-27 18:00:00",
//        "so2CalcDate":"2022-11-27 19:20:09",
//        "so2IndexLevel":{
//              "id":0,"indexLevelName":"Bardzo dobry"
//              },
//        "so2SourceDataDate":"2022-11-27 19:00:00",
//        "no2CalcDate":"2022-11-27 19:20:09",
//        "no2IndexLevel":{
//              "id":0,
//              "indexLevelName":"Bardzo dobry"
//              },
//        "no2SourceDataDate":"2022-11-27 19:00:00",
//        "pm10CalcDate":"2022-11-27 19:20:09",
//        "pm10IndexLevel":{
//              "id":1,
//              "indexLevelName":"Dobry"
//              },
//        "pm10SourceDataDate":"2022-11-27 18:00:00",
//        "pm25CalcDate":"2022-11-27 19:20:09",
//        "pm25IndexLevel":null,

//        "pm25SourceDataDate":null,
//        "o3CalcDate":"2022-11-27 19:20:09",
//        "o3IndexLevel":{
//              "id":0,
//              "indexLevelName":"Bardzo dobry"},
//        "o3SourceDataDate":"2022-11-27 19:00:00",
//        "stIndexStatus":true,
//        "stIndexCrParam":"PYL"}