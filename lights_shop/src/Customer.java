public class Customer {
    private String name;
    private String email;
    private String phone;
    private String city;

    public Customer(){

    }

    public Customer(String name, String email, String phone, String city){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }
}
