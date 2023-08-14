package com.gamingroom;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author Ethan Harper
 *
 */
public class Game Extends Entity {
	long id;
	String name;
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private Game() {
	}
	
	//array with list of active teams
	private static List<Team> teams = new ArrayList<Team>();
	

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	public Team addTeam(String name) {
		Team team = null;

		// iterate over teams to look for existing team with the same name
		//if found return the existing instance
		for (int i = 0; i < teams.size() - 1; i++) {
			if (teams.get(i).getName() == name) {
				team = teams.get(i);
			}
		}
		
		if (team == null) {
			GameService instance = GameService.getInstance();
			
			// Get a reference to the GameService instance and then call the getNextTeamId() to get the Id to designate the team.
			team = new Team(instance.getNextPlayerId(), name);
			teams.add(team);
		}

		// return the new or existing team 
		return team;
	
	
	
	
	@Override
	public String toString() {
		
		return "Game [id=" + id + ", name=" + name + "]";
	}

}
