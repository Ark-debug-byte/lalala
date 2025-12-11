package Character;


abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int attack;
    
    public Character(String name, int health, int attack) {
        this.name = name;
        this.health = health;
        this.maxHealth = health;
        this.attack = attack;
    }
    
    // Getters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttack() { return attack; }
    
    // Abstract method - must be implemented by subclasses
    public abstract void performSpecialAbility();
    
    // Abstract method for getting character type
    public abstract String getCharacterType();
    
    // Common method for all characters
    public void takeDamage(int damage) {
        health -= damage;
        System.out.println(name + " takes " + damage + " damage! Health: " + 
                         Math.max(0, health) + "/" + maxHealth);
    }
    
    public void attack(Character target) {
        System.out.println(name + " attacks " + target.getName() + " for " + attack + " damage!");
        target.takeDamage(attack);
    }
    
    public boolean isAlive() {
        return health > 0;
    }
    
    public void displayStats() {
        System.out.println("\n--- " + name + " (" + getCharacterType() + ") ---");
        System.out.println("Health: " + health + "/" + maxHealth);
        System.out.println("Attack: " + attack);
    }
}

// Warrior subclass - focuses on high damage
class Warrior extends Character {
    private int rage;
    
    public Warrior(String name) {
        super(name, 100, 15);
        this.rage = 0;
    }
    
    @Override
    public String getCharacterType() {
        return "Warrior";
    }
    
    @Override
    public void performSpecialAbility() {
        rage += 10;
        int bonusDamage = rage / 10;
        System.out.println("\n⚔️ " + name + " enters a RAGE! Bonus damage: +" + bonusDamage);
        System.out.println("Rage level: " + rage);
    }
    
    @Override
    public void attack(Character target) {
        int totalDamage = attack + (rage / 10);
        System.out.println(name + " strikes with FURY for " + totalDamage + " damage!");
        target.takeDamage(totalDamage);
    }
    
    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Rage: " + rage);
    }
}

// Mage subclass - uses mana and spells
class Mage extends Character {
    private int mana;
    private int maxMana;
    
    public Mage(String name) {
        super(name, 60, 8);
        this.mana = 100;
        this.maxMana = 100;
    }
    
    @Override
    public String getCharacterType() {
        return "Mage";
    }
    
    @Override
    public void performSpecialAbility() {
        if (mana >= 30) {
            mana -= 30;
            System.out.println("\n🔮 " + name + " casts FIREBALL!");
            System.out.println("Mana used: 30 | Remaining mana: " + mana + "/" + maxMana);
        } else {
            System.out.println("\n❌ " + name + " doesn't have enough mana!");
        }
    }
    
    public void castFireball(Character target) {
        if (mana >= 30) {
            performSpecialAbility();
            int spellDamage = 25;
            System.out.println("🔥 Fireball deals " + spellDamage + " magic damage!");
            target.takeDamage(spellDamage);
        }
    }
    
    public void restoreMana(int amount) {
        mana = Math.min(maxMana, mana + amount);
        System.out.println(name + " restores " + amount + " mana. Current: " + mana + "/" + maxMana);
    }
    
    @Override
    public void displayStats() {
        super.displayStats();
        System.out.println("Mana: " + mana + "/" + maxMana);
    }
}