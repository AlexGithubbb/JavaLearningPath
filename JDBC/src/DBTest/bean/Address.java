package DBTest.bean;

public class Address {

    private int id;
    private String name;
    private String street;
    private String prov;
    private int country_id;
    private String ZipCode;

    public Address() {
    }

    public Address(int id, String name, String street, String prov, int country_id, String ZipCode) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.prov = prov;
        this.country_id = country_id;
        this.ZipCode = ZipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getZipcode() {
        return ZipCode;
    }

    public void setZipcode(String ZipCode) {
        this.ZipCode = ZipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", prov='" + prov + '\'' +
                ", country_id=" + country_id +
                ", ZipCode='" + ZipCode + '\'' +
                '}';
    }
}
