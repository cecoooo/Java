public class Voter {
    private String name;
    private String city;
    private String street;
    private String address;

    public String getName() {return this.name;}
    public String getCity() {return this.city;}
    public String getStreet() {return this.street;}
    public String getAddress() {return this.address;}
    public void setName(String name){ this.name = name;}
    public void setCity(String city){ this.name = city;}
    public void setStreet(String street){ this.name = street;}
    public void setAddress(String address){ this.name = address;}

    public Voter()
    {

    }
    public Voter(String name, String city, String street, String address)
    {
        this.name = name;
        this.city = city;
        this.street = street;
        this.address = address;
    }

    public String ToString()
    {
        return this.name + " from " + this.city + ", " + this.street + ", " + this.address;
    }
}
