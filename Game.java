public class Game {
  public static void main(String[] args) {
        // Initialize a player with a name, description, hit points, min damage, and max damage
        Player player = new Player();
        
        // Create the room system and start the game
        RoomSystem roomSystem = new RoomSystem(player);
        roomSystem.startAdventure();
  }
}
