package javaapplication1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author(s): Gavin, Connor, Camryn, Lam
 * Instructor: Prof. DeVries
 * Description: Junit Tests for AI class
 */
class JUnitTest {
        @Test
    public void testDiceConstructor() {
        AI a = new AI();
        //Constructor is empty, so we can put more here if needed
    }

    @Test
    public void testNextTurnMethod() {

        //Test lastDiceFaceAccepted parameter equals to 0
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a1 = new AI();
            a1.nextTurn(0,1);
        });

        //Test lastDiceFaceAccepted parameter is a negative number
        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a2 = new AI();
            a2.nextTurn(-10,1);
        });

        //Test lastDiceFaceAccepted parameter is greater than 6
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a3 = new AI();
            a3.nextTurn(10,1);
        });

        //Test lastNumDieAccepted parameter equals to 0
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a4 = new AI();
            a4.nextTurn(4,0);
        });

        //Test lastNumDieAccepted parameter is a negative number
        IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a5 = new AI();
            a5.nextTurn(2,-5);
        });

        //Test lastNumDieAccepted parameter is greater than 25
        IllegalArgumentException thrown6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a6 = new AI();
            a6.nextTurn(1,77);
        });
    }

    @Test
    public void testRandomNumberGenMethod()
    {
        //Test min value less than 0
        IllegalArgumentException thrown1 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a7 = new AI();
            a7.randomNumberGen(10,-1);
        });

        //Test min value greater than 0 but less than 10
//        IllegalArgumentException thrown2 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            AI a8 = new AI();
//            a8.randomNumberGen(10,6);
//        });

        //Test min value greater than 10
        IllegalArgumentException thrown3 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a9 = new AI();
            a9.randomNumberGen(10,15);
        });

        //Test max value greater than 10
        IllegalArgumentException thrown4 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a10 = new AI();
            a10.randomNumberGen(15,0);
        });

        //Test max value greater than 0 but less than 10
        IllegalArgumentException thrown5 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a11 = new AI();
            a11.randomNumberGen(7,0);
        });

        //Test max value smaller than 0
        IllegalArgumentException thrown6 = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AI a12 = new AI();
            a12.randomNumberGen(-9,15);
        });
    }

    @Test
    public void testChallengePlayer() {
        AI a1 = new AI();
        int[] DICENUMBERS = {0,1,4,6,3,6,3};
        Assertions.assertTrue(a1.challengePlayer(4,5,DICENUMBERS));
        Assertions.assertTrue(a1.challengePlayer(0,5,DICENUMBERS));
        Assertions.assertFalse(a1.challengePlayer(3,5,DICENUMBERS));

    }
    @Test
    public void testLastDiceFaceAccepted() {
        AI a1 = new AI();
        a1.setLastDiceFaceAccepted(5);
        Assertions.assertEquals(a1.getLastDiceFaceAccepted(),5);
    }
    @Test
    public void testLastNumDieAccepted() {
        AI a1 = new AI();
        a1.setLastNumDieAccepted(5);
        Assertions.assertEquals(a1.getLastNumDieAccepted(),5);
    }
    @Test
    public void setPlayerDiceImage() {
        NewJFrame test = new NewJFrame();
        test.setPlayerDiceImage();
        Assertions.assertNotNull(test.player1Die1);
        Assertions.assertNotNull(test.player1Die2);
        Assertions.assertNotNull(test.player1Die3);
        Assertions.assertNotNull(test.player1Die4);
        Assertions.assertNotNull(test.player1Die5);

        Assertions.assertNotNull(test.player2Die1);
        Assertions.assertNotNull(test.player2Die2);
        Assertions.assertNotNull(test.player2Die3);
        Assertions.assertNotNull(test.player2Die4);
        Assertions.assertNotNull(test.player2Die5);

        Assertions.assertNotNull(test.player3Die1);
        Assertions.assertNotNull(test.player3Die2);
        Assertions.assertNotNull(test.player3Die3);
        Assertions.assertNotNull(test.player3Die4);
        Assertions.assertNotNull(test.player3Die5);

        Assertions.assertNotNull(test.player4Die1);
        Assertions.assertNotNull(test.player4Die2);
        Assertions.assertNotNull(test.player4Die3);
        Assertions.assertNotNull(test.player4Die4);
        Assertions.assertNotNull(test.player4Die5);

        Assertions.assertNotNull(test.player5Die1);
        Assertions.assertNotNull(test.player5Die2);
        Assertions.assertNotNull(test.player5Die3);
        Assertions.assertNotNull(test.player5Die4);
        Assertions.assertNotNull(test.player5Die5);
    }
}