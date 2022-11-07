public class Test {
    public static void main(String[] args) {
        CreateEvent event = new CreateEvent();
        Competition obj = event.getEvent("FootballCompetition");
        Participant p1 = new Participant(123, "Pesho", 27, 2, 120);
        Participant p2 = new Participant(124, "Gosho", 50, 2.6, 50);
        Participant p3 = new Participant(125, "Tosho", 38, 0.1, 400);
        Participant[] schedule = new Participant[]{p1,p2,p3};
        event.fillSchedule(obj, schedule);
        bets(obj, 123, 20);
        System.out.println("Player 1:\nBet for win: " + p1.getBetToWin() + "\nChance to win:" + p1.getChanceToWin() + "\n" +
                "Player 2:\nBet for win: " + p2.getBetToWin() + "\nChance to win:" + p2.getChanceToWin() + "\n" +
                "Player 3:\nBet for win: " + p3.getBetToWin() + "\nChance to win:" + p3.getChanceToWin() + "\n");
    }

    static void bets(Competition obj, int id, double bet){
        Participant[] players = obj.getSchedule();
        Participant player = new Participant();
        for(int i = 0; i < players.length; i++){
            if(players[i].getId() == id)
                player = players[i];
        }
        double currSum = player.getBetToWin();
        player.setBetToWin(currSum+bet);
        double percentage = player.getBetToWin()/currSum;
        player.setChanceToWin(player.getChanceToWin() - player.getChanceToWin()*(percentage/100));
    }
}