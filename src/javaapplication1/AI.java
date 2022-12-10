package javaapplication1;

public class AI{

    int lastDiceFaceAccepted;
    int lastNumDieAccepted;
    public void nextTurn(int lastDiceFaceAccepted, int lastNumDieAccepted) {
        int maxDieCount = 10;
        int minDieCount = 0;
        int randPicker;
        int maxDieFace  = 6;
        int minDieFace = 1;
        int Inc_Choice;


        randPicker = randomNumberGen(maxDieCount,minDieCount);

        if (randPicker % 2 == 0) Inc_Choice = 0;
        else Inc_Choice = 1;
        //aa


        if (Inc_Choice == 0) {
            if(lastDiceFaceAccepted == 6) {
                lastDiceFaceAccepted = 1;
                lastNumDieAccepted++;
            }
            else {
                int temp = lastDiceFaceAccepted;
                while(temp >= lastDiceFaceAccepted)
                    lastDiceFaceAccepted = randomNumberGen(maxDieFace, minDieFace);
            }
        }
        else {
            lastNumDieAccepted++;
        }

        this.lastDiceFaceAccepted = lastDiceFaceAccepted;
        this.lastNumDieAccepted = lastNumDieAccepted;
        if (lastDiceFaceAccepted < 1){
            throw new IllegalArgumentException("The lastDiceFaceAccepted parameter can not less than 1");
        }

        //Check to see if the lastDiceFaceAccepted parameter is greater than 6
        if (lastDiceFaceAccepted > 6){
            throw new IllegalArgumentException("The lastDiceFaceAccepted parameter can not greater than 6");
        }

        //Check to see if the lastNumDieAccepted parameter less than 1
        if (lastNumDieAccepted < 1){
            throw new IllegalArgumentException("The lastDiceFaceAccepted parameter can not less than 1");
        }

        //Check to see if the lastNumDieAccepted parameter is greater than 25
        if (lastNumDieAccepted > 25){
            throw new IllegalArgumentException("The lastDiceFaceAccepted parameter can not greater than 25");
        }
        /*
         * JUnitTest Section for nextTurn method
         */
        //Check to see if the lastDiceFaceAccepted parameter less than 1

    }
    public int getLastDiceFaceAccepted(){return lastDiceFaceAccepted;}

    public int getLastNumDieAccepted(){return lastNumDieAccepted;}

    public void setLastDiceFaceAccepted(int lastDiceFaceAccepted){this.lastDiceFaceAccepted = lastDiceFaceAccepted;}

    public void setLastNumDieAccepted(int lastNumDieAccepted){this.lastNumDieAccepted = lastNumDieAccepted;}

    public int randomNumberGen(int max, int min) {
        int rand = 0;
        rand = (int) (Math.random() * (max - min + 1) + min);

        if (min < 0){
            throw new IllegalArgumentException("Min value can not be less than 0");
        }

        //Test min value greater than 0 but less than 10

        //Test min value greater than 10
        if (min > 10){
            throw new IllegalArgumentException("Min can not be greater than 10, it has to be equal to 0");
        }

        //Test max value less than 0
        if (max < 0){
            throw new IllegalArgumentException("Max value can not be less than 0, it has to be equal to 10");
        }

        //Test max value greater than 0 but less than 10

        //Test max value greater than 10
        if (max > 10){
            throw new IllegalArgumentException("Max can not be greater than 10, it has to be equal to 10");
        }
        return rand;
    }

    public void bidSubmit() {


    }
    public boolean challengePlayer(int lastDiceFaceAccepted, int lastNumDieAccepted, int[] DICENUMBERS) {
        boolean result = false;

        if(DICENUMBERS[lastDiceFaceAccepted] < lastNumDieAccepted) {
            result = true;
        }

        return result;

    }



    public void easyAI() {


    }
}
