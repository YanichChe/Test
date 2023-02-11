package com.chernovskaya.creatures.exceptions;

public class HealthValueException extends Exception
{
    public HealthValueException()
    {
        super("Wrong health value");
    }
}
