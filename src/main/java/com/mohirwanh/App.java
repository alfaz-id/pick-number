package com.mohirwanh;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        Scanner keyboard = new Scanner(System.in);
        Random r = new Random();
        System.out.println( "Pick a number between 10 - 20");
        int pickNumber = keyboard.nextInt();
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<10;i++){
            result.add(r.nextInt(21-pickNumber)+pickNumber);
        }

        int userPick;
        int aiPick;
        int sumUser=0;
        int sumAi=0;
        int ai;
        while(result.size()!=0){
            System.out.println("List "+result.toString().replace(","," ").replace("[","").replace("]",""));
            System.out.println("Pick a number from most left ot right ");
            userPick = keyboard.nextInt();
            try {
                aiPick =result.indexOf(userPick);
                if(result.size()<aiPick){
                    System.out.println("Left");
                    aiPick =result.indexOf(userPick-2);
                }
                result.remove(Integer.valueOf(userPick));
                if(result.size()==aiPick){
                    ai=result.get(aiPick-1);
                    System.out.println("Rigth "+aiPick);
                }else{
                    ai=result.get(aiPick);
                }

                result.remove(Integer.valueOf(ai));
                sumUser =sumUser+userPick;
                sumAi = sumAi+ai;
                System.out.println("Your pick "+userPick);
                System.out.println("AI pick "+ai);
                System.out.println("Sum User "+sumUser);
                System.out.println("Sum AI "+sumAi);
                System.out.println("");
            }catch (Exception e){
                System.out.println("\nPlease pick number from list!\n");
            }
        }

        String win = sumUser<sumAi?"Game Over, You Lose":"Congratulation ! You win";
        System.out.println(win);
    }
}
