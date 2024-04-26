package Monsters;

import Abilities.Attack;

import java.util.HashMap;
import java.util.Objects;
import java.util.Random;

public abstract class Monster {

    private Integer hp;
    private Integer xp = 10;
    private Integer maxHP;
    private HashMap<String, Integer> items;
    Integer agility = 10;
    Integer defense = 10;
    Integer strength = 10;
    Attack attack;

    public Monster(Integer maxHP, Integer xp, HashMap<String, Integer> items) {
        this.xp = xp;
        this.maxHP = maxHP;
        hp = this.maxHP;
        this.items = items;
    }

    /**
     * This method return an Integer value between min and max.
     * rand.nextInt(n) returns a number between 0-n to get a value between str - maxStr,
     * We need to get a random number from maxStr-str and add str back in.
     * @param min integer
     * @param max integer
     * @return random integer between min and max
     */

    Integer getAttribute(Integer min, Integer max) {
        Random rand = new Random();
        if (min > max) {
            Integer temp = min;
            min = max;
            max = temp;
        }
        //returns a random number between min and max inclusive
        return rand.nextInt(max-min) + min;
    }

    boolean takeDamage(Integer damage) {
        if (damage > 0) {
            hp -= damage;
            System.out.println("The creature was hit for " + damage);
            if (hp <= 0) {
                System.out.println("Oh no! The creature has perished");
                System.out.println(this.toString());
                return false;
            }
        }
        return true;
    }

    public Integer attackTarget(Monster target) {
        Integer damage = attack.attack(target);
        target.takeDamage(damage);
        return damage;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getXp() {
        return xp;
    }

    public Integer getMaxHP() {
        return maxHP;
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<String, Integer> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return Objects.equals(getHp(), monster.getHp()) && Objects.equals(getXp(), monster.getXp()) && Objects.equals(getMaxHP(), monster.getMaxHP()) && Objects.equals(getItems(), monster.getItems()) && Objects.equals(getAgility(), monster.getAgility()) && Objects.equals(getDefense(), monster.getDefense()) && Objects.equals(getStrength(), monster.getStrength()) && Objects.equals(attack, monster.attack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHp(), getXp(), getMaxHP(), getItems(), getAgility(), getDefense(), getStrength(), attack);
    }

    public String toString() {
        return "hp=" + hp + "/" + maxHP;
    }


}
