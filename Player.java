import java.util.Random;

public class Player {
     // instance variables
    private final String name;
    private final String description;
    private String clas;
    public int hitPoints;
    
    private int minDamage;
    private int maxDamage;
    private final Random random = new Random();
//constructor
    public Player(String name,String description,String clas, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;
        this.description = description;
        this.clas = clas;
        this.hitPoints = hitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
//default constructor
  Player() {
      this.name = "Arthur";
      this.description = "King of England";
      this.minDamage = 10;
      this.maxDamage = 20;
      
      this.hitPoints = 40;
  }
  

  
  // attack method randInt delta(damage)
  public void slash(Monster monster){
      int damageToMonster = random.nextInt(maxDamage - minDamage + 1) + minDamage;
      monster.setHitPoints(monster.getHitPoints() - damageToMonster);
      System.out.println("⚔︎ ⚔︎ ⚔︎");
      System.out.println("You have dealt " + damageToMonster + " damage to the monster");
  }
  public void shatteringCharge(Monster monster){
      int damageToMonster = random.nextInt(maxDamage - minDamage + 1) + minDamage;
      monster.setHitPoints(monster.getHitPoints() - damageToMonster);
      System.out.println("--------> -------> ----->");
      System.out.println("You have dealt " + damageToMonster + " damage to the monster");
  }
  public void fireBall(Monster monster){
      int damageToMonster = random.nextInt(maxDamage - minDamage + 1) + minDamage;
      monster.setHitPoints(monster.getHitPoints() - damageToMonster);
      System.out.println("🔥🔥🔥");
      System.out.println("You have dealt " + damageToMonster + " damage to the monster");
  }
  public void frostBolt(Monster monster){
      int damageToMonster = random.nextInt(maxDamage - minDamage + 1) + minDamage;
      monster.setHitPoints(monster.getHitPoints() - damageToMonster);
      System.out.println("❄️❄️❄️");
      System.out.println("You have dealt " + damageToMonster + " damage to the monster");
  }
  /*
  public void takeDamage(int damage) {
       hitPoints = Math.max(hitPoints - damage, 0);
  }
  */

    public void rest() {
        System.out.println("You take a moment to rest and regain some strength.");
        hitPoints += 10;  // Adjust health restoration as desired
        System.out.println("HP is now:" + hitPoints);
    }

    public void collectLoot(int lootValue) {
        hitPoints += lootValue;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public String getStatus() {
        return "Player HP: " + hitPoints;
    }
    public void setHitPoints(int hitPoints){
        this.hitPoints = hitPoints;
    }
    public int getHitPoints(){
        return hitPoints;
    }
    public String getName(){
        return name;
    }
    public String getClas() {
        return clas;
    }
    @Override
    public String toString() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
