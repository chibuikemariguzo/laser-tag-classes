/*
Player.java
COMP 1020  SECTION A02
INSTRUCTOR:  LAUREN HIMBEAULT
NAME:  ARIGUZO CHIBUIKEM DANIEL 
ASSIGNMENT:  ASSIGNMENT 1 PHASE 1
QUESTION: Create a laser tag player class with its instructed methods  
*/


public class Player {
    // variables
    private String playerName;
    private int noOfGames;
    private int avgScore;
    private int sumScore;
    

    public Player(String name) {
        playerName = name;
        noOfGames = 0;
        sumScore = 0;
        avgScore = 0;
    }//constructor

    public Player(String name, Location place) {
        playerName = name;
        place.addMember(this);
    }//location constructor

    
    public void addGameResult(int newScore) {
        noOfGames++;
        sumScore += newScore;
        avgScore = sumScore / noOfGames;
    }//addGameResult

    public String getName() {
        return playerName;
    }//getter

    public boolean equals(Player other) {
        return this.getName() == other.getName();
    }//equals

    public String toString() {
        String result = "Player: " + this.getName() + " has played ";
        if (noOfGames == 0) {
            result += "no games";
        }
        else if (noOfGames == 1) {
            result += "1 game with an average of " + avgScore;
        }
        else
            result += noOfGames + " games with an average of " + avgScore;
        return result;
    }//toString
}
