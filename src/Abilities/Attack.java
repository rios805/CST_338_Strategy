package Abilities;

import Abilities.Ability;
import Monsters.Monster;

public interface Attack extends Ability {
    public Integer attack(Monster target);
}
