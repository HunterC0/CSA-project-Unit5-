import java.util.Random;
import java.util.Scanner;

public class RoomSystem {
    private Player player;
    private int currentRoomIndex = 0;
    private Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    public RoomSystem(Player player) {
        this.player = player;
    }
    private void enterBossRoom(){
        Monster slimeKingMonster = new Monster("King Slime", "An enormous slime with a crown", 90, 10, 40);

    }
    
    public void startAdventure() { //main method in main
        System.out.println("Welcome to the Dungeon, " + player + ", " + player.getDescription() + "!" );
        System.out.println("1 - Enter first room, 2 - Exit dungeon");
        String playerChoice = scanner.nextLine();
        if (playerChoice.equals("1")){
            System.out.println("\nYou enter room " + (currentRoomIndex + 1) + ".");
            if (random.nextBoolean()) {
                enterLootRoom();
            } else {
                enterEnemyRoom();
            }
            if (!player.isAlive()) {
                System.out.println("Game over.");
                return;
            }
            while (player.isAlive() && currentRoomIndex < 5) {
                System.out.println("1 - walk into the next room, 2 - rest to restore health, 3 - go one room back");
                String playerRoomProgressChoice = scanner.nextLine();

                switch (playerRoomProgressChoice) {
                    case "1" -> {
                        currentRoomIndex++;
                        if (random.nextBoolean()) {
                            enterLootRoom();
                        } else {
                            enterEnemyRoom();
                        }   if (!player.isAlive()) {
                            System.out.println("Game over.");
                            return;
                        }
                    }
                    case "2" -> player.rest();
                    default -> {
                        System.out.println("You go back one room. The dungeon transfigures..........");
                        currentRoomIndex--;
                        if (random.nextBoolean()) {
                            enterLootRoom();
                        } else {
                            enterEnemyRoom();
                        }   if (!player.isAlive()) {
                            System.out.println("Game over.");
                            return;
                        }
                    }
                }
                
                // Final boss room after the first five rooms
                if (player.isAlive() && currentRoomIndex>=5) {
                    enterBossRoom();
                }
            }
        System.out.println("Your adventure has ended.");
        }
        else{
            System.out.println("Weakling... Your adventure has ended.");
        }
    }
    
        




    private void enterEnemyRoom() {
        Scanner input = new Scanner(System.in);
        Monster monster = new Monster("Slime", "A small blob", 30, 5, 10);
        System.out.println("An enemy " + monster + " appears! Prepare to fight.");
        while(player.getHitPoints() >0 && monster.getHitPoints() >0){ 
            if (player.getClas().equals("Knight")){
                System.out.println("Choose number of your action: 1 - slash, 2 - shattering charge");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.slash(monster);
                }
                else{
                    player.shatteringCharge(monster);
                }
            }
            if (player.getClas().equals("Mage")){
                System.out.println("Choose number of your action: 1 - fireball, 2 - frostbolt");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.fireBall(monster);
                }
                else{
                    player.frostBolt(monster);
                }
            }
            monster.attack(player);
        }
        
        if (player.getHitPoints()>0){
            System.out.println(player.getName() + " has defeated the " + monster.getName());
        }
        else{
            System.out.println(monster.getName() + " has defeated the" + player.getName());
        }
        
    }

    private void enterLootRoom() {
        System.out.println("You find a chest filled with valuable loot!");
        int lootPoints = 20 * currentRoomIndex;
        player.collectLoot(lootPoints);
        System.out.println("You gained " + lootPoints + " HP from the loot.");
        System.out.println(player.getStatus());
    }
}
