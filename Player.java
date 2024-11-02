import java.util.Random;

public final class Player {
  // instance variables
  private final String name;
  private final String description;


  private int hitPoints;
  private int minDamage;
  private int maxDamage;

  private final Random random = new Random();
  // contructor
  Player(String name, String description, int hitPoints, int minDamage, int maxDamage) {
      this.name = name;
      this.description = description;

      this.minDamage = minDamage;
      this.maxDamage = maxDamage;
      
      this.hitPoints = hitPoints;
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
  public int attack() {
      return random.nextInt(maxDamage - minDamage + 1) + minDamage;
  }
  // defend against monster
  public void defend(Monster monster) {
      int attackStrength = monster.attack();
      //ternary operator is used to determine character's health/hitpoints after the damage done by monster
      hitPoints = (hitPoints > attackStrength) ? hitPoints - attackStrength : 0;
      //I use formatted strings for convenience;however, it's not a requirement
      System.out.printf("  " + name + " is hit for %d HP of damage (%s)\n", attackStrength,
              getStatus());
      if (hitPoints == 0) {
          System.out.println("  " + name + " has been defeated");
      }
  }
  public boolean isAlive() {
      return hitPoints > 0;
  }

  public String getStatus() {
      return "Player HP: " + hitPoints;
  }

  @Override
  public String toString() {
      return name;
  }

  public String getDescription() {
      return description;
  }
}