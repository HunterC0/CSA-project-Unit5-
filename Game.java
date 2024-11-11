import java.util.Scanner;        


public class Game {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in); 
        System.out.println("Please type in your name."); //ask name
        String name = input.nextLine();
        System.out.println("Please type in the description of your character:"); // character description
        String description = input.nextLine();
        
        
        System.out.println("Choose your Class: ");
        System.out.println("1). Knight");
        System.out.println("2). Mage");
        System.out.println("Please type the number of your choice: ");
       
        int classChoice = input.nextInt();

        // Initialize a player with a name, description, hit points, min damage, and max damage
        if(classChoice == 1){
            Player player = new Player(name, description,"Knight", 50, 10, 20 );
            RoomSystem roomSystem = new RoomSystem(player);
            System.out.println("You have chosen the knight class. Higher HP but lower Damage");
            roomSystem.startAdventure();
        }
        else{
            Player player = new Player(name, description, "Mage", 30, 10, 40);
            RoomSystem roomSystem = new RoomSystem(player);
            System.out.println("You have chosen the mage class. Higher damage but lower HP");
            roomSystem.startAdventure();
        }
        

        // Create the room system and start the game
        
        

    }
}
