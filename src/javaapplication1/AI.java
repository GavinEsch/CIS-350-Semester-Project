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
    }
    public int getLastDiceFaceAccepted(){return lastDiceFaceAccepted;}

    public int getLastNumDieAccepted(){return lastNumDieAccepted;}

    public int randomNumberGen(int max, int min) {
        int rand = 0;
        rand = (int) (Math.random() * (max - min + 1) + min);
        return rand;
    }

    public void bidSubmit() {


    }

    public void challengePlayer() {


    }

    public void easyAI() {


    }
}
