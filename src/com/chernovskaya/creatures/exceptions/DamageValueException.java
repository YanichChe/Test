package com.chernovskaya.creatures.exceptions;

public class DamageValueException extends Exception
{
    public DamageValueException()
    {
        super("Wrong damage value");
    }
}
