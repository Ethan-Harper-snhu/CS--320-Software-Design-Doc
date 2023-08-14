package com.gamingroom;

/**
 * A class to test a singleton's behavior
 * 
 * @author Ethan Harper
 */
public class SingletonTester {

	public void testSingleton() {
		
		System.out.println("\nAbout to test the singleton...");
		
		//set the GameService object to the instance in the GamerService class that we create
		GameService service = GameService.getInstance(); 
		
		// a simple for loop to print the games
		for (int i = 0; i < service.getGameCount(); i++) {
			System.out.println(service.getGame(i));
		}

	}
	
}
