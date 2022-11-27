public class stationData {
    int id;
    float gegrLat;
    float gegrLon;
    String stationName;
    String addressStreet;
    cityData city;

    public int getId() {return id;}
    public String getStationName() {
        return stationName;
    }
    public float getGegrLat() {
        return gegrLat;
    }
    public float getGegrLon() {
        return gegrLon;
    }
    public cityData getCity() {
        return city;
    }
    public String getAddressStreet() {
        return addressStreet;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }
    public void setGegrLat(float gegrLat) {
        this.gegrLat = gegrLat;
    }
    public void setGegrLon(float gegrLon) {
        this.gegrLon = gegrLon;
    }
    public void setCity(cityData city) {
        this.city = city;
    }
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public stationData() { }
}


// [{
//        "id": 14,
//        "stationName": "Działoszyn",
//        "gegrLat": "50.972167",
//        "gegrLon": "14.941319",
//        "city": {
//          "id": 192,
//          "name": "Działoszyn",
//          "commune": {
//              "communeName": "Bogatynia",
//              "districtName": "zgorzelecki",
//              "provinceName": "DOLNOŚLĄSKIE"
//                  }
//              },
//        "addressStreet": null
//        }]