public class FootballCompetition implements Competition {
    private int fastestGoal;
    private Participant[] participants;

    public FootballCompetition(){

    }
    public int getFastestGoal() {
        return fastestGoal;
    }
    public void setFastestGoal(int fastestGoal) {
        this.fastestGoal = fastestGoal;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

    @Override
    public Participant[] getSchedule() {
        return this.participants;
    }
}
