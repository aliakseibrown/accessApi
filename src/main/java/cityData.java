public class cityData {
    public int id;
    public String name;
    communeData commune;

    public int getId() {return id;}

    public String getName() {return name;}

    public communeData getCommune() {return commune;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setCommune(communeData commune) {this.commune = commune;}
    public cityData() { };
}