package com.chernovskaya.creatures;

public class CreatureData
{
    private int attack;
    private int protection;
    private int health;
    private int minDamage;
    private int maxDamage;
    private final int maxValue;

    public CreatureData(int maxValue)
    {
        this.maxValue = maxValue;
    }

    public void generateRandomData()
    {
        attack = getRandomNumber(Creature.MIN_ATTACK, Creature.MAX_ATTACK);
        protection = getRandomNumber(Creature.MIN_PROTECTION, Creature.MAX_PROTECTION);
        health = getRandomNumber(Creature.MIN_HEALTH, maxValue * 2);
        minDamage = getRandomNumber(0, maxValue);
        maxDamage = getRandomNumber(minDamage, maxValue);
    }

    public static int getRandomNumber(int min, int max) {
        max += 1;
        return (int) ((Math.random() * (max - min)) + min);
    }
    public int getAttack()
    {
        return attack;
    }

    public int getProtection()
    {
        return protection;
    }

    public int getHealth()
    {
        return health;
    }

    public int getMinDamage()
    {
        return minDamage;
    }

    public int getMaxDamage()
    {
        return maxDamage;
    }
}
