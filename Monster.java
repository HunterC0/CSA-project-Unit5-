import java.util.Random;

public class Monster {
    private final String name;
    private final String description;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private final static Random random = new Random();


    private Monster(String name, String description, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;
        this.description = description;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.hitPoints = hitPoints;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return "Monster HP: " + hitPoints;
    }

    public int attack() {
        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }

    public void defend(Player player) {
        int attackStrength = player.attack();
        hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
        System.out.printf("  %s hits %s for %d HP of damage (%s)\n", player, name, attackStrength,
                getStatus());
        if (hitPoints == 0) {
            System.out.println("  " + player + " kills " + name);
        }
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

}

