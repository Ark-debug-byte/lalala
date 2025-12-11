package Character;

public class CharacterTest {
    public static void main(String[] args) {
        System.out.println("═".repeat(70));
        System.out.println("           CARD ROGUE - INHERITANCE & POLYMORPHISM DEMO");
        System.out.println("═".repeat(70));
        
        // Create array of Character references (polymorphism)
        Character[] party = new Character[2];
        party[0] = new Warrior("Thorgrim the Mighty");
        party[1] = new Mage("Elara the Wise");
        
        // Display initial stats using polymorphism
        System.out.println("\n🎮 PARTY ASSEMBLED!");
        for (Character character : party) {
            character.displayStats();
        }
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("                          ⚔️ BATTLE BEGINS! ⚔️");
        System.out.println("═".repeat(70));
        
        // Create enemies
        Character spider = new Enemy("Giant Spider", 40, 5);
        Character rat = new Enemy("Plague Rat", 30, 4);
        
        // Turn 1 - Warrior vs Spider
        System.out.println("\n--- TURN 1 ---");
        party[0].performSpecialAbility();  // Polymorphic call
        party[0].attack(spider);           // Polymorphic call
        
        // Turn 2 - Mage vs Rat
        System.out.println("\n--- TURN 2 ---");
        if (party[1] instanceof Mage) {    // Type checking
            Mage mage = (Mage) party[1];   // Downcasting
            mage.castFireball(rat);
        }
        
        // Turn 3 - Enemies attack back
        System.out.println("\n--- TURN 3 ---");
        if (spider.isAlive()) {
            spider.attack(party[0]);
        }
        if (rat.isAlive()) {
            rat.attack(party[1]);
        }
        
        // Turn 4 - Final attacks
        System.out.println("\n--- TURN 4 ---");
        party[0].performSpecialAbility();
        party[0].attack(spider);
        
        if (party[1] instanceof Mage) {
            ((Mage) party[1]).restoreMana(20);
        }
        party[1].attack(rat);
        
        // Final status
        System.out.println("\n" + "═".repeat(70));
        System.out.println("                          BATTLE SUMMARY");
        System.out.println("═".repeat(70));
        
        System.out.println("\n🏰 PARTY STATUS:");
        for (Character character : party) {
            character.displayStats();
            System.out.println("Status: " + (character.isAlive() ? "✅ ALIVE" : "💀 DEFEATED"));
        }
        
        System.out.println("\n👹 ENEMY STATUS:");
        spider.displayStats();
        System.out.println("Status: " + (spider.isAlive() ? "✅ ALIVE" : "💀 DEFEATED"));
        rat.displayStats();
        System.out.println("Status: " + (rat.isAlive() ? "✅ ALIVE" : "💀 DEFEATED"));
        
        System.out.println("\n" + "═".repeat(70));
        System.out.println("Key OOP Concepts Demonstrated:");
        System.out.println("✓ Inheritance: Warrior & Mage extend Character");
        System.out.println("✓ Polymorphism: Array of Character references holds different types");
        System.out.println("✓ Abstract Methods: performSpecialAbility() & getCharacterType()");
        System.out.println("✓ Method Overriding: Each class implements abilities differently");
        System.out.println("✓ Encapsulation: Private fields with public methods");
        System.out.println("═".repeat(70));
    }
}

// Simple Enemy class for testing
class Enemy extends Character {
    public Enemy(String name, int health, int attack) {
        super(name, health, attack);
    }
    
    @Override
    public String getCharacterType() {
        return "Enemy";
    }
    
    @Override
    public void performSpecialAbility() {
        System.out.println(name + " has no special ability!");
    }
}