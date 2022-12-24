import java.io.Serializable;

public class FootballClub implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String owner;
    private String coach;
    private String captain;
    private int yearOfEstablishing;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCoach() {
        return coach;
    }
    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCaptain() {
        return captain;
    }
    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public int getYearOfEstablishing() {
        return yearOfEstablishing;
    }
    public void setYearOfEstablishing(int yearOfEstablishing) {
        this.yearOfEstablishing = yearOfEstablishing;
    }

    public FootballClub(){

    }

    public FootballClub(String name, String coach, int yearOfEstablishing){
        this.name = name;
        this.owner = "Unknown";
        this.coach = coach;
        this.captain = "Unknown";
        this.yearOfEstablishing = yearOfEstablishing;
    }

    public FootballClub(String name, String owner, String coach, String captain, int yearOfEstablishing){
        this.name = name;
        this.owner = owner;
        this.coach = coach;
        this.captain = captain;
        this.yearOfEstablishing = yearOfEstablishing;
    }
}
