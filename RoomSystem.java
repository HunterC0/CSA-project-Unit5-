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
    private void enterBossRoom(){ //boss
        System.out.println("\n------------------------------------------------------------");
        System.out.println("You enter the boss room.");
        System.out.println("A massive shadow is looming over you.");
        Scanner input = new Scanner(System.in);
        Monster slimeKingMonster = new Monster("King Slime", "An enormous slime with a crown", 90, 10, 40);
        System.out.println("An enemy " + slimeKingMonster + " appears! " + slimeKingMonster.getDescription() + ". Prepare to fight.");
        while(player.getHitPoints() >0 && slimeKingMonster.getHitPoints() >0){ // ||
            if (player.getClas().equals("Knight")){
                System.out.println("Type number of which action to do: 1 - slash, 2 - shattering charge");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.slash(slimeKingMonster);
                }
                else{
                    player.shatteringCharge(slimeKingMonster);
                }
            }
            if (player.getClas().equals("Mage")){
                System.out.println("Type number of which action to do: 1 - fireball, 2 - frostbolt");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.fireBall(slimeKingMonster);
                }
                else{
                    player.frostBolt(slimeKingMonster);
                }
            }
            slimeKingMonster.attack(player);
            System.out.println("");
            System.out.println(player + "'s HP is :" + player.getHitPoints());
            System.out.println(slimeKingMonster + "'s HP is : " + slimeKingMonster.getHitPoints());
            System.out.println("");
        }
        
        if (player.getHitPoints()>0){
            System.out.println(player.getName() + " has defeated the " + slimeKingMonster.getName());
            System.out.println("Congratulations you beat the game!");
        }
        else{
            System.out.println(slimeKingMonster.getName() + " has defeated " + player.getName());
        }
    }
    
    public void startAdventure() { //main method in main
        System.out.println("Welcome to the Dungeon, " + player + ", " + player.getDescription() + "!" );
        System.out.println("1 - Enter first room, 2 - Exit dungeon");
        String playerChoice = scanner.nextLine();
        if (playerChoice.equals("1")){
            System.out.println("\n------------------------------------------------------------");
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
                System.out.println("\n------------------------------------------------------------");
                System.out.println("1 - walk into the next room, 2 - rest to restore health, 3 - go one room back");
                String playerRoomProgressChoice = scanner.nextLine();

                switch (playerRoomProgressChoice) {
                    case "1": {
                        currentRoomIndex++;
                        System.out.println("\n------------------------------------------------------------");
                        System.out.println("\nYou enter room " + (currentRoomIndex + 1) + ".");
                        if (random.nextBoolean()) {
                            enterLootRoom();
                        } else {
                            enterEnemyRoom();
                        }   if (!player.isAlive()) {
                            System.out.println("Game over.");
                            return;
                        }
                        break;
                    }
                    case "2":{
                        System.out.println("\n------------------------------------------------------------");
                        player.rest();
                        break;
                    }
                    default: {
                        if(currentRoomIndex > 0){
                            System.out.println("\n------------------------------------------------------------");
                            System.out.println("You go back one room. The dungeon transfigures..........");
                            currentRoomIndex--;
                            System.out.println("\nYou enter room " + (currentRoomIndex + 1) + ".");
                            if (random.nextBoolean()) {
                                enterLootRoom();
                            } else {
                                enterEnemyRoom();
                            }
                        }else{
                            System.out.println("You are already at the start of the dungeon. You cannot go back further.");
                        }
                        if (!player.isAlive()) {
                            System.out.println("Game over.");
                            return;
                        }
                        break;
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
        System.out.println("An enemy " + monster + " appears! " + monster.getDescription() + ". Prepare to fight.");
        while(player.getHitPoints() >0 && monster.getHitPoints() >0){ 
            if (player.getClas().equals("Knight")){
                System.out.println("Type number of which action to do: 1 - slash, 2 - shattering charge");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.slash(monster);
                }
                else{
                    player.shatteringCharge(monster);
                }
            }
            if (player.getClas().equals("Mage")){
                System.out.println("Type number of which action to do: 1 - fireball, 2 - frostbolt");
                String combatChoice = input.nextLine();
                if (combatChoice.equals("1")){
                    player.fireBall(monster);
                }
                else{
                    player.frostBolt(monster);
                }
            }
            monster.attack(player);
            System.out.println("");
            System.out.println(player + "'s HP is :" + player.getHitPoints());
            System.out.println(monster + "'s HP is : " + monster.getHitPoints());
            System.out.println("");
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
