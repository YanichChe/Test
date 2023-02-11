package com.chernovskaya.creatures;

import com.chernovskaya.creatures.exceptions.*;

public class Player extends Creature
{

    public static final int MAX_HEALING_FACTOR = 3;

    private int healingFactor;
    private final String name;

    public Player(CreatureData creatureData, String name)
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        super(creatureData);
        this.healingFactor = MAX_HEALING_FACTOR;
        this.name = name;
    }

    public void heal() throws HealingFactorException, MeaninglessHealingException
    {
        if (healingFactor > 0)
        {
            if (this.getHealth() == this.getMaxHealth()) throw new MeaninglessHealingException();

            healingFactor--;
            this.setHealth(Math.min(this.getMaxHealth() / 2 + this.getMaxHealth(), this.getMaxHealth()));

            System.out.println("Your healing factor now is " + healingFactor);
            System.out.println("Your health now is " + this.getHealth());
        }

        else
        {
            throw new HealingFactorException();
        }
    }

    public String getName()
    {
        return name;
    }
}
