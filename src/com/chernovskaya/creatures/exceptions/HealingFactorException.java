package com.chernovskaya.creatures.exceptions;

public class HealingFactorException extends Exception
{
    public HealingFactorException()
    {
        super("Can't restore health");
    }
}
