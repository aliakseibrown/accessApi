public class structureJson {
    public int id;
    public String stationName;
    public String addressStreet;
    public float gegrLat;
    public float gegrLon;
    cityJson city;

    public int getId() {return id;}

    public String getStationName() {return stationName;}

    public float getGegrLat() {return gegrLat;}

    public float getGegrLon() {return gegrLon;}

    public cityJson getCity() {return city;}

    public String getAddressStreet() {return addressStreet;}

    public void setId(int id) {this.id = id;}

    public void setStationName(String stationName) {this.stationName = stationName;}

    public void setGegrLat(float gegrLat) {this.gegrLat = gegrLat;}

    public void setGegrLon(float gegrLon) {this.gegrLon = gegrLon;}

    public void setCity(cityJson city) {this.city = city;}

    public void setAddressStreet(String addressStreet) {this.addressStreet = addressStreet;}

    public structureJson() { }
}