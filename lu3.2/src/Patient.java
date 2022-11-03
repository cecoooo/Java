public abstract class Patient {
    private String name;
    private String address;
    private String egn;

    public String getName(){
        return this.name;
    }
    public String getAddress(){
        return this.address;
    }
    public String getEgn(){
        return this.egn;
    }
    public void setName(String n){
        this.name = n;
    }
    public void setAddress(String n){
        this.address = n;
    }
    public void setEgn(String n){
        this.egn = n;
    }

    public Patient(String name, String address, String egn){
        this.name = name;
        this.address = address;
        this.egn = egn;
    }

    public abstract void cure(String cure, double dose);
}
