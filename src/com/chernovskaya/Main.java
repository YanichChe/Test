package com.chernovskaya;

import com.chernovskaya.creatures.exceptions.AttackValueException;
import com.chernovskaya.creatures.exceptions.DamageValueException;
import com.chernovskaya.creatures.exceptions.HealthValueException;
import com.chernovskaya.creatures.exceptions.ProtectionValueException;
import com.chernovskaya.game.Game;

public class Main
{
    public static void main(String[] args)
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        Game game = new Game();
        game.start();
    }
}
