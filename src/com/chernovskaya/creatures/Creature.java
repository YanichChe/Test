package com.chernovskaya.creatures;

import com.chernovskaya.creatures.exceptions.AttackValueException;
import com.chernovskaya.creatures.exceptions.DamageValueException;
import com.chernovskaya.creatures.exceptions.HealthValueException;
import com.chernovskaya.creatures.exceptions.ProtectionValueException;

public abstract class Creature
{
    public static final int MAX_ATTACK = 20;
    public static final int MAX_PROTECTION = 20;

    public static final int MIN_ATTACK = 1;
    public static final int MIN_PROTECTION = 1;
    public static final int MIN_HEALTH = 1;

    public static final int cubeValueMax = 6;
    public static final int cubeValueMin = 1;

    private final int attack;
    private final int protection;
    private int health;
    private final int maxHealth;

    private final int minDamage;
    private final int maxDamage;

    public Creature(CreatureData creatureData)
            throws AttackValueException, ProtectionValueException,
                   HealthValueException, DamageValueException
    {

        if (creatureData.getAttack() <= 0 || creatureData.getAttack() > MAX_ATTACK)              throw new AttackValueException();
        if (creatureData.getProtection() <= 0 || creatureData.getProtection() > MAX_PROTECTION)  throw new ProtectionValueException();
        if (creatureData.getHealth() <= 0)                                                       throw new HealthValueException();
        if (creatureData.getMinDamage() < 0)                                                     throw new DamageValueException();

        this.attack = creatureData.getAttack();
        this.protection = creatureData.getProtection();
        this.health = creatureData.getHealth();
        this.minDamage = creatureData.getMinDamage();
        this.maxDamage = creatureData.getMaxDamage();
        this.maxHealth = health;
    }
    public void printInfo()
    {
        System.out.println("Current health: " + health);
        System.out.println("Attack: " + attack);
        System.out.println("Protection: " + protection);
        System.out.println("Damage: " + minDamage + " - " + maxDamage);
    }

    public void hick(Creature victim)
    {
        if (isSuccess(victim))
        {
            victim.health = Math.max(victim.health - getRandomNumber(this.minDamage, this.maxDamage), 0);
        }
    }

    public boolean isAlive()
    {
        return health > 0;
    }

    private boolean isSuccess(Creature victim)
    {
        int modifierAttack = this.attack - victim.protection + 1;

        for (int i = 0; i < Math.max(modifierAttack, 1); i++)
        {
            int value = getRandomNumber(cubeValueMin, cubeValueMax);
            if (value == cubeValueMax - 1 || value == cubeValueMax) return true;
        }
        return false;
    }

    public int getHealth()
    {
        return health;
    }

    public void setHealth(int health)
    {
        this.health = health;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    private int getRandomNumber(int min, int max) {
        max += 1;
        return (int) ((Math.random() * (max - min)) + min);
    }
}
