/*
Location.java
COMP 1020  SECTION A02
INSTRUCTOR:  LAUREN HIMBEAULT
NAME:  ARIGUZO CHIBUIKEM DANIEL 
ASSIGNMENT:  ASSIGNMENT 1 PHASE 4
QUESTION: Create a laser tag location class with its instructed methods  
*/


public class Location {
    private static final int MAX_MEMBERS = 100;
	private static final int MAX_LOCATIONS = 100;
    private Player[] members = new Player[MAX_MEMBERS];
    
    private String name;
	private String address;
    private int noOfMembers;

	private static Location[] allLocations = new Location[MAX_LOCATIONS];
	private static int noOfLocations = 0;

    public Location(String name, String address) {
		this.name = name;
		this.address = address;

		allLocations[noOfLocations] = this;
		noOfLocations++;
    }

    public void addMember(Player newbie) {
		boolean memberFound = false;
		for (int i = 0; i < noOfMembers; i++)
			if (newbie.equals(members[i]))
				memberFound = true;
		
		if (!memberFound)
			members[noOfMembers++] = newbie;
	}

    public String toString() {
		String s = "Membership list for " + name + ", " + address + " location\n";
		for (int i = 0; i < noOfMembers; i++)
			s += members[i].toString() + "\n";
		return s;
	}

	public static String allLocationNames() {
		String s = "All locations:\n";
		for (int i = 0; i < noOfLocations; i++) {
			s += allLocations[i].name + "\n";
		}
		return s;
	}

	public static String whichLocations(Player who) {
		String s = who.getName() + "is a member at:\n";
		for (int i = 0; i < noOfLocations; i++) {
			//loop through all member of location i
			for (int j = 0; j < allLocations[i].noOfMembers; j++) {
				if (allLocations[i].members[j].equals(who)) {
					s += allLocations[i].name + "\n";
				}
			}
		}
		return s;
	}

}
