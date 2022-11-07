public class Participant {
    private int id;
    private String name;
    private int age;
    private double chanceToWin=1.1;
    private double betForWin=1.0;

    public Participant() {

    }
    public Participant(int id, String name, int age, double chanceToWin, double betForWin) {
        this.id = id;
        this.name = name;
        this.age = age;
        if(chanceToWin >= 1.1)
            this.chanceToWin = chanceToWin;
        else
            this.chanceToWin = 1.1;
        this.betForWin = betForWin;
    }

    public double getBetToWin() {
        return betForWin;
    }

    public void setBetToWin(double betForWin) {
        this.betForWin = betForWin;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getChanceToWin() {
        return chanceToWin;
    }

    public void setChanceToWin(double chanceToWin) {
        this.chanceToWin = chanceToWin;
        if(this.chanceToWin < 1.1)
            this.chanceToWin = 1.1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
