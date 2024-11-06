import java.util.Random;

public class Player {
     // instance variables
    private final String name;
    public int hitPoints;
    private int minDamage;
    private int maxDamage;
    private final Random random = new Random();
//constructor
    public Player(String name, int hitPoints, int minDamage, int maxDamage) {
        this.name = name;

        this.hitPoints = hitPoints;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }
//default constructor
  Player() {
      this.name = "Arthur";
    //description is missing, can re add later but it gave an error to room systems so I just removed it for now
    //ill put it back later
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
    public void takeDamage(int damage) {
        hitPoints = Math.max(hitPoints - damage, 0);
    }

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

    @Override
    public String toString() {
        return name;
    }
}


  public String getDescription() {
      return description;
  }
}
