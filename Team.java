/*
Team.java
COMP 1020  SECTION A02
INSTRUCTOR:  LAUREN HIMBEAULT
NAME:  ARIGUZO CHIBUIKEM DANIEL 
ASSIGNMENT:  ASSIGNMENT 1 PHASE 2
QUESTION: Create a laser tag team class with its instructed methods  
*/


public class Team {
    //variables
    private final int MAX_SIZE = 5;
    private int numPlayers;                
    private Player[] team;                                                      

    public Team() { 
        numPlayers = 0;
        team = new Player[MAX_SIZE];
    }//constructor

    public boolean addMember(Player newOne) {
        //track if found or added
        boolean playerFound = false;
        boolean playerAdded = false;

        //loop through the team and check if player is present
        for (int i = 0; i < numPlayers; i++) {
            if (team[i].equals(newOne)) {
                playerFound = true;
            }  
        }
        //if player is not present and there is space, add player
        if (!playerFound && numPlayers < MAX_SIZE) {
            team[numPlayers] = newOne;
            numPlayers++;  //increase num of players by 1
            playerAdded = true;
        }
        return playerAdded;
    }//addMember

    public String toString() {
        String result = "Team members: \n";
        for (int i = 0; i < numPlayers; i++) {
            result += i+1 + ":" + team[i].getName() + "\n";
        }
        return result;
    }//toString

    public boolean hasCommonPlayers(Team other) {
        boolean hasCommon = false;

        for (int i = 0; i < this.numPlayers; i++) {
            for (int j = 0; j < other.numPlayers; j++) {
                if (this.team[i].equals(other.team[j])) {   
                    hasCommon = true;
                } 
            }
        }
        return hasCommon;
    }//hasCommon

    public boolean teamFull() {
        return numPlayers == MAX_SIZE;
    }//teamFull

    public void awardTeam(int points) {
        //loop through the team and add points to each player
		for (int i = 0; i < numPlayers; i++)
			team[i].addGameResult(points/numPlayers);
	}// awardTeam

    public boolean removePlayer(Player toRemove) {
        boolean playerFound = false;
        for (int i = 0; i < numPlayers; i++) {
            if (playerFound) 
                team[i - 1] = team[i];
            
            if (team[i].equals(toRemove)) 
                playerFound = true;
        }
        if (playerFound)
            numPlayers--;

        return playerFound;
    }//removePlayer

    public Player[] getRoster() {
        //returns a deep copy of the team
        Player[] teamCopy = new Player[this.numPlayers];
        for (int i = 0; i < teamCopy.length; i++)
            teamCopy[i] = this.team[i];
        return teamCopy;    
    }//getRoster

}
