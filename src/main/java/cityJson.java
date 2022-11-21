public class cityJson {
    public int id;
    public String name;
    communeJson commune;

    public int getId() {return id;}

    public String getName() {return name;}

    public communeJson getCommune() {return commune;}

    public void setId(int id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setCommune(communeJson commune) {this.commune = commune;}
    public cityJson() { };
}