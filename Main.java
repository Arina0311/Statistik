package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {


    static Random r = new Random();
    static int door = 3; //3 doors
    static int effort = 10;
    static boolean doesPlayerChangedChoice = true;
    static int wins = 0;

    public static void main(String[] args) {
        for (int k = 0; k < effort; k++) {
            playGame();
        }
        print("wins:"+wins*100/effort+"%");
    }

    private static void playGame() {
        ArrayList<Integer> doors = new ArrayList<>();
        int doorWithMoney = r.nextInt(door);
        for (int i = 0; i < door; i++) {
            if(i==doorWithMoney) doors.add(1);
            else doors.add(0);
        }
        print(Arrays.toString(doors.toArray()));
        int doorSelectedByPlayer = r.nextInt(door);
        int doorSelectedByBoss;
        while(true){
            doorSelectedByBoss = r.nextInt(door);
            if(doorSelectedByPlayer!=doorSelectedByBoss && doorSelectedByBoss!=doorWithMoney)
                break;
        }
        print("player:"+doorSelectedByPlayer);
        print("boss:"+doorSelectedByBoss);
        if(doesPlayerChangedChoice){
            while(true){
                int anotherDoorSelectedByPlayer = r.nextInt(door);
                if(anotherDoorSelectedByPlayer!=doorSelectedByBoss && anotherDoorSelectedByPlayer!=doorSelectedByPlayer){
                    doorSelectedByPlayer = anotherDoorSelectedByPlayer;
                    print("player changes:"+doorSelectedByBoss);
                    break;
                }
            }
        }
        if(doorSelectedByPlayer==doorWithMoney){//win
            wins++;
            print("WIN! money:"+doorWithMoney+" player:"+doorSelectedByPlayer);
        }
        else
            print("LOSE! money:"+doorWithMoney+" player:"+doorSelectedByPlayer);//lose
            print("");
    }
    private static void print(String message){
        System.out.println(message);
    }
}
