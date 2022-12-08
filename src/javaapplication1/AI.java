package javaapplication1;

public class AI {
    public void nextTurn(int lastDiceFaceAccepted, int lastNumDieAccepted, int AI_order) {
        int max = 10;
        int min = 0;
        int Inc_Choice;

        int a = (int) (Math.random() * (max - min + 1) + min);

        if (a % 2 == 0) Inc_Choice = 0;
        else Inc_Choice = 1;


        if (Inc_Choice == 0) {
            lastDiceFaceAccepted++;
            System.out.println("AI [" + (AI_order+2) + "]" + " played bid: Dice Face = [ " +
                    lastDiceFaceAccepted + " ]\n\t\t\t\tNumber of Dice = [ " + lastNumDieAccepted + " ]");

            previousBidTextDisplay.setText("Your current bid is:\n\tDice Face = [ " + lastDiceFaceAccepted +
                    " ]\n\tNumber of Dice = [ " + lastNumDieAccepted + " ]" + "\n\nLast accepted bid was" +
                    ":\n\tDice Face = [ " + lastDiceFaceAccepted + " ]\n\tNumber of Dice = [ "
                    + lastNumDieAccepted + " ]");
        }
        else {
            lastNumDieAccepted++;
            System.out.println("AI [" + (AI_order+2) + "]" + " played bid: Dice Face = [ " +
                    lastDiceFaceAccepted + " ]\n\t\t\t\tNumber of Dice = [ " + lastNumDieAccepted + " ]");
            previousBidTextDisplay.setText("Your current bid is:\n\tDice Face = [ " + lastDiceFaceAccepted +
                    " ]\n\tNumber of Dice = [ " + lastNumDieAccepted + " ]" + "\n\nLast accepted bid was" +
                    ":\n\tDice Face = [ " + lastDiceFaceAccepted + " ]\n\tNumber of Dice = [ "
                    + lastNumDieAccepted + " ]");
        }




    }

    public void bidSubmit() {


    }

    public void challengePlayer() {


    }

    public void easyAI() {


    }
}
