import org.w3c.dom.events.EventException;

public class CreateEvent {
    private String typeOfEvent;

    public String getTypeOfEvent(){
        return this.typeOfEvent;
    }
    public CreateEvent(){

    }

    public Competition getEvent(String competitionType){
        Competition obj = new FootballCompetition();
        switch (competitionType){
            case "FootballCompetition":
                this.typeOfEvent = competitionType;
                break;
            case "Formula1Competition":
                this.typeOfEvent = competitionType;
                obj = new Formula1Competition();
                break;
            case "HorseCompetition":
                this.typeOfEvent = competitionType;
                obj = new HorseCompetition();
                break;
            default:
                    short i = 2;
                    throw new EventException(i, "Invalid Type.");
        }
        return obj;
    }

    public void fillSchedule(Competition obj, Participant[] schedule){
        if(schedule.length == 0){
            try {
                throw new EmptySetException("The collection is empty.");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(obj instanceof FootballCompetition)
            ((FootballCompetition) obj).setParticipants(schedule);
        if(obj instanceof Formula1Competition)
            ((Formula1Competition) obj).setParticipants(schedule);
        if(obj instanceof HorseCompetition)
            ((HorseCompetition) obj).setParticipants(schedule);
        else {
            short i = 2;
            try {
                throw new Exception();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
