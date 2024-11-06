import java.util.Scanner;

public class RoomSystem {
    private Player player;
    private int currentRoomIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    public RoomSystem(Player player) {
        this.player = player;
    }
//bulk of the room system, choose between the index for each room, if the players HP is below 0 then game over
//you have 4 options where to go, 3 of them mostly do the same thing, with the exception of rest which healths before starts.
    public void startAdventure() {
        System.out.println("Welcome to the Dungeon, " + player + "!");

        while (player.isAlive() && currentRoomIndex < 5) {
            System.out.println("\nYou enter a new room.");

            if (currentRoomIndex == 0 || currentRoomIndex == 3 || currentRoomIndex == 4) {
                enterEnemyRoom();
            } else if (currentRoomIndex == 1) {
                enterLootRoom();
            } else if (currentRoomIndex == 2) {
                enterPuzzleRoom();
            }

            if (!player.isAlive()) {
                System.out.println("You have been defeated. Game over.");
                break;
            }

            System.out.println("Choose an action: walk, search, rest, or quit");
            String action = scanner.nextLine();

            if (action.equalsIgnoreCase("walk")) {
                currentRoomIndex++;
            } else if (action.equalsIgnoreCase("search")) {
                searchCurrentRoom();
            } else if (action.equalsIgnoreCase("rest")) {
                player.rest();
            } else if (action.equalsIgnoreCase("quit")) {
                System.out.println("You have left the dungeon.");
                return;
            } else {
                System.out.println("Invalid command.");
            }
        }
        System.out.println("Your adventure has ended.");
    }
// only monster right now is a goblin, could implement randomization between multiple monsters.
    private void enterEnemyRoom() {
        Monster monster = new Monster("Goblin", "A fierce goblin guarding the path", 30, 5, 10);
        System.out.println("An enemy " + monster + " appears! Prepare to fight.");

        while (monster.isAlive() && player.isAlive()) {
            // Monster attacks player
            int damageToPlayer = monster.attack();
            player.takeDamage(damageToPlayer);
            System.out.printf("%s attacks you for %d damage. %s\n", monster.getName(), damageToPlayer, player.getStatus());

            // Player attacks monster
            if (player.isAlive()) {
                monster.defend(player);
            }
        }

        if (!monster.isAlive()) {
            System.out.println("You defeated the " + monster + "!");
        }
    }
// one of the options for the rooms, if player gets this one, they health (if you want a currency system, that could be added too)
    private void enterLootRoom() {
        System.out.println("You find a chest filled with valuable loot!");
        int lootPoints = 20;
        player.collectLoot(lootPoints);
        System.out.println("You gained " + lootPoints + " HP from the loot.");
        System.out.println(player + " hp is now:" + player.getStatus());
    }
//rushed this part, didnt add the puzzle yet.
    private void enterPuzzleRoom() {
        System.out.println("You encounter a mysterious puzzle on the wall. Solve it to proceed!");
        System.out.println("You manage to solve the puzzle and continue.");
    }
//the index of rooms, what to say with what room you get.
    private void searchCurrentRoom() {
        if (currentRoomIndex == 0 || currentRoomIndex == 3 || currentRoomIndex == 4) {
            System.out.println("You search the area and find signs of a recent battle.");
        } else if (currentRoomIndex == 1) {
            System.out.println("You search the area and find some loot.");
        } else if (currentRoomIndex == 2) {
            System.out.println("You search the area and find strange symbols related to the puzzle.");
        }
    }
}
