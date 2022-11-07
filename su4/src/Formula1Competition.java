public class Formula1Competition implements Competition{
    private double winnersTime;
    private Participant[] participants;

    public double getWinnersTime() {
        return winnersTime;
    }

    public void setWinnersTime(double winnersTime) {
        this.winnersTime = winnersTime;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }
    public Participant[] getSchedule() {
        return participants;
    }
}
