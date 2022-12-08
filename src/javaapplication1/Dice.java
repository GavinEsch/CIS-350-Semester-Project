package javaapplication1;

import javax.swing.*;

public class Dice{

    final int[] DICENUMBERS = new int[25];
    Icon[] DicePic;
    public void dicePicture(){

    }

    /**
     * Picks a random value from 1 - 6
     *
     * @return - random value from 1 - 6
     */
    public Icon[] DicePhoto() {
        //TODO
        ImageIcon die1 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die1.png");
        ImageIcon die2 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die2.png");
        ImageIcon die3 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die3.png");
        ImageIcon die4 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die4.png");
        ImageIcon die5 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die5.png");
        ImageIcon die6 = new ImageIcon("C:\\Users\\gavin\\IdeaProjects\\Liars Dice\\" +
                "CIS-350-Semester-Project\\src\\javaapplication1\\dice\\Die6.png");

        getDieNumber();
        Icon[] picDie = new Icon[25];
        for (int i = 0; i <= 24; i++) {
            switch (DICENUMBERS[i]) {
                case 1 -> picDie[i] = die1;
                case 2 -> picDie[i] = die2;
                case 3 -> picDie[i] = die3;
                case 4 -> picDie[i] = die4;
                case 5 -> picDie[i] = die5;
                case 6 -> picDie[i] = die6;
            }
        }

        return picDie;
    }
    public int[] getDieNumber() {
        final int DICEARRAY_SIZE = 24;


        final int[] DIECOUNT = new int[7];

        int min = 1;
        int max = 6;
        int random = 0;

        for (int i = 0; i <= DICEARRAY_SIZE; i++) {
            random = (int)Math.floor(Math.random()*(max-min+1)+min);
            DICENUMBERS[i] = random;
        }

        for (int i = 0; i <= DICEARRAY_SIZE; i++) {
            switch (DICENUMBERS[i]) {
                case 1 -> DIECOUNT[1]++;
                case 2 -> DIECOUNT[2]++;
                case 3 -> DIECOUNT[3]++;
                case 4 -> DIECOUNT[4]++;
                case 5 -> DIECOUNT[5]++;
                case 6 -> DIECOUNT[6]++;
            }
        }
        System.out.println(DIECOUNT[1]);
        System.out.println(DIECOUNT[2]);
        System.out.println(DIECOUNT[3]);
        System.out.println(DIECOUNT[4]);
        System.out.println(DIECOUNT[5]);
        System.out.println(DIECOUNT[6]);

        return DIECOUNT;
    }




    public int[] getDiceNumbers() {
        return DICENUMBERS;
    }
}
