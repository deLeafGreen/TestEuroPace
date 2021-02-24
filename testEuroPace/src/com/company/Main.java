package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] chances = new int[10];
        int[] game = new int[10];

        for (int i = 0; i< chances.length;i++){
            chances[i] = 2;
            game[i] = 10;
        }
        Bowling bowl = new Bowling(chances,game);
        System.out.println("############################################");
        System.out.println("            BOWLING -- GAME");
        System.out.println("############################################");
        Scanner scan = new Scanner(System.in);
        String  s = scan.next();

        while(!bowl.end && bowl.frame < 10){



            if(s.equals("roll")){
                bowl.roll();
                System.out.println(bowl.toString());
            }

        }
    }
}
