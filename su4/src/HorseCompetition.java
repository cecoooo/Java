public class HorseCompetition implements Competition{
    private String breed;
    private Participant[] participants;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
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
