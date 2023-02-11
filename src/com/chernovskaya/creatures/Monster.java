package com.chernovskaya.creatures;

import com.chernovskaya.creatures.exceptions.AttackValueException;
import com.chernovskaya.creatures.exceptions.DamageValueException;
import com.chernovskaya.creatures.exceptions.HealthValueException;
import com.chernovskaya.creatures.exceptions.ProtectionValueException;

public class Monster extends Creature
{
    public Monster(CreatureData creatureData)
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        super(creatureData);
    }
}
