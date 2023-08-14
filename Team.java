package com.gamingroom;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author Ethan Harper
 *
 */
public class Team Extends Entity{
	long id;
	String name;
	
	//array for list of active teams
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
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
	
	public Player addPlayer(String name) {
		Player player = null;

		// iterate over players to look for existing players with the same name and if found return the existing name
		for (int i = 0; i < players.size() - 1; i++) {
			if (players.get(i).getName() == name) {
				player = players.get(i);
			}
		}
		
		// if not found, make a new player instance
		if (player == null) {
			GameService instance = GameService.getInstance();
			
			player = new Player(instance.getNextPlayerId(), name);
			players.add(player);
		}

		// return the new or existing player
		return player;

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + "]";
	}
}
