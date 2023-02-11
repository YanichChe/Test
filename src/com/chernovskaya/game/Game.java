package com.chernovskaya.game;

import com.chernovskaya.creatures.CreatureData;
import com.chernovskaya.creatures.Monster;
import com.chernovskaya.creatures.Player;
import com.chernovskaya.creatures.exceptions.*;

import java.util.Scanner;

public class Game
{
    public static final int MAX_VALUE = 300;

    public void start()
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        printStartInfo();

        boolean exitFlag = false;
        try(Scanner in = new Scanner(System.in))
        {
            while(!exitFlag)
            {
                switch (in.next())
                {
                    case ("start"):
                        Monster monster = createMonster();
                        Player player = createPlayer();
                        game(monster, player);
                        exitFlag = true;
                        break;

                    case ("rules"):
                        printHelp();
                        break;

                    case ("exit"):

                        System.out.println("Goodbye!");
                        exitFlag = true;
                        break;

                    default:
                        System.out.println("Not such options");
                        break;
                }
            }
        }
    }

    private void game(Monster monster, Player player)
    {
        try(Scanner in = new Scanner(System.in))
        {
            while (monster.isAlive() && player.isAlive())
            {
                boolean stepFlag = true;

                System.out.println("Player's step");
                switch (in.next())
                {
                    case ("hick"):
                        player.hick(monster);
                        System.out.println("The Monster's health is " + monster.getHealth());
                        break;

                    case ("heal"):
                        try
                        {
                            player.heal();
                        }
                        catch (HealingFactorException | MeaninglessHealingException e)
                        {
                            System.err.println(e.getMessage());
                            System.out.println("Try again");
                            stepFlag = false;
                        }
                        break;

                    default:
                        System.out.println("Not such command, game info: ");
                        printHelp();
                        stepFlag = false;
                        break;
                }

                if (stepFlag)
                {
                    if (!monster.isAlive()) break;

                    System.out.println("Monster's step");
                    monster.hick(player);
                    System.out.println("The Player's health is " + player.getHealth());

                    if (!player.isAlive()) break;
                }
            }
        }

        if (monster.isAlive()) System.out.println("The monster won");
        else System.out.println(player.getName() + "won");
    }

    private void printStartInfo()
    {
        System.out.println("Welcome to game!");
        System.out.println("Write 'start' to start, 'rules' to read instructions, 'exit' to exit");
    }

    private void printHelp()
    {
        System.out.println("Available commands for player: ");
        System.out.println("'hick'- if successful, it reduces the monster's health");
        System.out.println("'heal' - increases your health by 50% of the maximum health");
    }

    private Monster createMonster()
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        CreatureData creatureData = new CreatureData(MAX_VALUE);
        creatureData.generateRandomData();

        Monster monster = new Monster(creatureData);

        System.out.println("The monster was generated");
        monster.printInfo();

        return monster;
    }

    private Player createPlayer()
            throws ProtectionValueException, HealthValueException,
                   DamageValueException, AttackValueException
    {
        CreatureData creatureData = new CreatureData(MAX_VALUE);
        creatureData.generateRandomData();

        String name;
        System.out.println("Name your character!");

        Scanner in = new Scanner(System.in);
        name = in.next();

        System.out.println("Welcome " + name);
        Player player = new Player(creatureData, name);

        System.out.println("The Player was generated");
        player.printInfo();

        return player;
    }
}
