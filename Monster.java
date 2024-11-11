import java.util.Random;

public class Monster {
    private final String name;
    private final String description;
    private int hitPoints;
    private final int minDamage;
    private final int maxDamage;
    private static final Random random = new Random();

    public Monster(String name, String description, int hitPoints, int minDamage, int maxDamage) {
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

    public void attack(Player player) {
        int damageToPlayer = random.nextInt(maxDamage - minDamage + 1) + minDamage;
        player.setHitPoints(player.getHitPoints() - damageToPlayer);
        System.out.println(this.getName() + " dealt " + damageToPlayer + " damage to " + player.getName());
    }

    
    public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getName() {
        return name;
    }
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    public int getHitPoints(){
        return hitPoints;
    }
}
