package com.chernovskaya.creatures.exceptions;

public class MeaninglessHealingException extends Exception
{
    public MeaninglessHealingException()
    {
        super("Have enough health");
    }
}
