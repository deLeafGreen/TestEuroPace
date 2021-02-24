package com.company;

import java.util.Random;

public class Bowling {
    private static int pins = 10;
    private int[] game;
    private int[] chances;
    public static int frame = 0;
    public static boolean end = false;
    private boolean strike = false;
    private int score;
    private static int strikeCounter = 0;
    public Bowling(int[] chances,int[] game){
        this.chances = chances;
        this.game = game;
    }



    public static int getPins() {
        return pins;
    }


    public int[] getChances() {
        return chances;
    }

    public void setChances(int[] chances) {
        this.chances = chances;
    }

    public int[] getGame() {
        return game;
    }

    public void setGame(int[] game) {
        this.game = game;
    }



    public void roll(){
        StringBuilder s = new StringBuilder();
        Random random = new Random();
        //check if an extra roll is unlocked
        boolean extraRoll = ((frame == 10 && game[frame-1] == 0 && chances[frame-1] == 1)? true:false);

        if(chances[frame] > 0  || frame < 10 || (extraRoll) ){
            int roll = random.nextInt(11);
            strike = (chances[frame] == 1 && game[frame] == 0)?true:false;


            if(chances[frame] == 0 && frame < 10 || strike) {
                if(game[frame] == 0 ){
                    score+= 15;
                    if(strike && strikeCounter < 2){
                        score+=15;
                        strikeCounter += 1;
                    }
                }else{
                    score+=(pins-game[frame]);
                    if(strikeCounter == 2){
                        strikeCounter = 0;

                    }
                    if (strike && strikeCounter < 2){
                        score+=(pins-game[frame]);
                        strikeCounter += 1;

                    }
                }
                frame += 1;

            }else{
                game[frame]-= (game[frame]-roll < 0  ? game[frame] = 0:roll);

                chances[frame] -= 1;


            }


        }else{
            end = true;
        }
    }
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

                int mainLoop = 0;
                while(mainLoop < frame){
                s.append("-- roll: ").append(mainLoop+1).append(" -- current pins:").append(game[mainLoop]).append(" -- chances: ").append(chances[mainLoop]).append(" \n");
                mainLoop += 1;
            }
                if(frame >= 10){
                    s.append("-- final: ").append(score).append("\n\n").append("-----------------------------------------------------------------------------------------------------------");
                }

        return s.toString();
    }
}
