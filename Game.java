/*
Game.java
COMP 1020  SECTION A02
INSTRUCTOR:  LAUREN HIMBEAULT
NAME:  ARIGUZO CHIBUIKEM DANIEL 
ASSIGNMENT:  ASSIGNMENT 1 PHASE 3
QUESTION: Create a laser tag game class with its instructed methods  
*/


public class Game {
    private Team homeTeam;
    private Team awayTeam;
    public static final int COLUMN_WIDTH = 20; //NOTE: width can be higher depending on the size of the player names

    public Game(Team home, Team away) {
        homeTeam = home;
        awayTeam = away;
    }

    public boolean validGame() {         
        return (!homeTeam.hasCommonPlayers(awayTeam) && homeTeam.teamFull() && awayTeam.teamFull());
    }

    public void awardWinner(Team winner, int points) {
		if (winner == homeTeam) {
			homeTeam.awardTeam(points);
			awayTeam.awardTeam(0);
		}
		else {
			homeTeam.awardTeam(0);
			awayTeam.awardTeam(points);
		}
    }

    public String toString() {
		String s = "Not a valid game";
		Player leftTeam[];
		Player rightTeam[];

		if (validGame()) {
			s = "Team rosters:\n";
			
			leftTeam = this.homeTeam.getRoster();
			rightTeam = this.awayTeam.getRoster();
			
			for (int i = 0; i < leftTeam.length; i++) {
				String name  = leftTeam[i].getName();
				s += name;
				
				
				for (int j = name.length(); j < COLUMN_WIDTH; j++)
					s += " ";
				
				s += rightTeam[i].getName() + "\n";
			}
		}
		return s;
    }
}