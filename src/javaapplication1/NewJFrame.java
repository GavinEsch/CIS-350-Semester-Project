package javaapplication1;

import javax.swing.*;

import java.awt.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.awt.event.ActionListener;
import java.lang.Math;



/**
 *
 * @author Gavin, Lam, Connor, Camryn
 */
public class NewJFrame extends javax.swing.JFrame {
    int lastDiceFaceAccepted = 1;
    int lastNumDieAccepted = 1;
    String AI_Difficulty = "Easy";
    int AI_order = 2;
    final int[] DICENUMBERS = new int[25];
    final int[] DIECOUNT = new int[7];

    //dice color change
    int RGB = 0;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        //TODO
        initComponents();

    }

    @SuppressWarnings("unchecked")

    private void initComponents() {
        player2Name = new javax.swing.JLabel();
        player1Name = new javax.swing.JLabel();
        player5Name = new javax.swing.JLabel();
        player4Name = new javax.swing.JLabel();
        player3Name = new javax.swing.JLabel();
        playerBidSubmitButton = new javax.swing.JButton();
        nextTurnButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        previousBidTextDisplay = new javax.swing.JTextPane();
        challengePlayer = new javax.swing.JButton();
        playerBidNumberOfDieInput = new javax.swing.JTextField();
        player1Die1 = new javax.swing.JLabel();
        player1Die2 = new javax.swing.JLabel();
        player1Die3 = new javax.swing.JLabel();
        player1Die4 = new javax.swing.JLabel();
        player1Die5 = new javax.swing.JLabel();
        player2Die1 = new javax.swing.JLabel();
        player5Die1 = new javax.swing.JLabel();
        player2Die3 = new javax.swing.JLabel();
        player2Die4 = new javax.swing.JLabel();
        player2Die5 = new javax.swing.JLabel();
        player2Die2 = new javax.swing.JLabel();
        player5Die2 = new javax.swing.JLabel();
        player5Die3 = new javax.swing.JLabel();
        player5Die4 = new javax.swing.JLabel();
        player5Die5 = new javax.swing.JLabel();
        player4Die1 = new javax.swing.JLabel();
        player3Die2 = new javax.swing.JLabel();
        player3Die3 = new javax.swing.JLabel();
        player3Die4 = new javax.swing.JLabel();
        player3Die5 = new javax.swing.JLabel();
        player3Die1 = new javax.swing.JLabel();
        player4Die2 = new javax.swing.JLabel();
        player4Die3 = new javax.swing.JLabel();
        player4Die4 = new javax.swing.JLabel();
        player4Die5 = new javax.swing.JLabel();
        playerBidDieFaceInput = new javax.swing.JTextField();
        playerBidDieFacejLabel = new javax.swing.JLabel();
        playerBidNumberOfDiejLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        hostGameMenuItem = new javax.swing.JMenu();
        joinGameMenuItem = new javax.swing.JMenu();
        exitGameMenuItem = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //Sets text of player names above the dice
        player2Name.setText("Player 2 - AI 2");
        player1Name.setText("Player 1");
        player5Name.setText("Player 5 - AI 5");
        player4Name.setText("Player 4 - AI 4");
        player3Name.setText("Player 3 - AI 3");

        //bid submit button text
        playerBidSubmitButton.setText("Submit Bid");
        nextTurnButton.setText("Next");

        nextTurnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBidDieFaceInputActionPerformed(evt);
                AI ai_challenge = new AI();

                if(AI_order == 1) {
                    JOptionPane.showMessageDialog(null, "It is your turn!");
                }
                else if (AI_Difficulty.equalsIgnoreCase("Easy")){
                    ai_challenge.nextTurn(lastDiceFaceAccepted,lastNumDieAccepted);
                    lastNumDieAccepted = ai_challenge.getLastNumDieAccepted();
                    lastDiceFaceAccepted = ai_challenge.getLastDiceFaceAccepted();
                    previousBidTextDisplay.setText("Player " + AI_order + " current bid is:\n\tDice Face = [ " + lastDiceFaceAccepted +
                            " ]\n\tNumber of Dice = [ " + lastNumDieAccepted + " ]" + "\n\nLast accepted bid was" +
                            ":\n\tDice Face = [ " + lastDiceFaceAccepted + " ]\n\tNumber of Dice = [ "
                            + lastNumDieAccepted + " ]");
                }


                AI_order++;
                if (AI_order == 6) {
                    AI_order = 1;
                }
            }
        });

        //action listener for the submit bid button
        //TODO make sure this submits both fields and clears it after submit
        playerBidSubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                int diceFaceInput;
                int numDieInput;


                playerBidSubmitButtonActionPerformed(evt);

                diceFaceInput = Integer.valueOf(playerBidDieFaceInput.getText());
                numDieInput = Integer.valueOf(playerBidNumberOfDieInput.getText());

                if ((diceFaceInput > lastDiceFaceAccepted) && (numDieInput == lastNumDieAccepted))
                {
                    lastDiceFaceAccepted= diceFaceInput;
                    lastNumDieAccepted = numDieInput;
                }
                else if ((diceFaceInput == lastDiceFaceAccepted) && (numDieInput > lastNumDieAccepted))
                {
                    lastDiceFaceAccepted = diceFaceInput;
                    lastNumDieAccepted = numDieInput;
                }
                else if ((diceFaceInput > lastDiceFaceAccepted) && (numDieInput > lastNumDieAccepted))
                {
                    lastDiceFaceAccepted = diceFaceInput;
                    lastNumDieAccepted = numDieInput;
                }

                else JOptionPane.showMessageDialog(null, "The dice face or the number of dice has to be greater than the previous bid");

                previousBidTextDisplay.setText("Your current bid is:\n\tDice Face = [ " + diceFaceInput +
                        " ]\n\tNumber of Dice = [ " + numDieInput + " ]" + "\n\nLast accepted bid was" +
                        ":\n\tDice Face = [ " + lastDiceFaceAccepted + " ]\n\tNumber of Dice = [ "
                        + lastNumDieAccepted + " ]");
            }
        });

        challengePlayer.setText("Challenge");
        challengePlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBidDieFaceInputActionPerformed(evt);
                AI ai = new AI();

                boolean ChallengeTF = ai.challengePlayer(lastDiceFaceAccepted, lastNumDieAccepted);

                if(ChallengeTF) {
                    JOptionPane.showMessageDialog(null, "Congratulation!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Maybe Next Time!");
                }
                RGB = 255;
                player2Die1.setBackground(Color.WHITE);
                player2Die2.setBackground(Color.WHITE);
                player2Die3.setBackground(Color.WHITE);
                player2Die4.setBackground(Color.WHITE);
                player2Die5.setBackground(Color.WHITE);
                
                player3Die1.setBackground(Color.WHITE);
                player3Die2.setBackground(Color.WHITE);
                player3Die3.setBackground(Color.WHITE);
                player3Die4.setBackground(Color.WHITE);
                player3Die5.setBackground(Color.WHITE);
                
                player4Die1.setBackground(Color.WHITE);
                player4Die2.setBackground(Color.WHITE);
                player4Die3.setBackground(Color.WHITE);
                player4Die4.setBackground(Color.WHITE);
                player4Die5.setBackground(Color.WHITE);
                
                player5Die1.setBackground(Color.WHITE);
                player5Die2.setBackground(Color.WHITE);
                player5Die3.setBackground(Color.WHITE);
                player5Die4.setBackground(Color.WHITE);
                player5Die5.setBackground(Color.WHITE);

            }
        });

        jScrollPane2.setViewportView(previousBidTextDisplay);

        //where the number of dice in the bid is inputted
        //TODO link up with submit button
        playerBidNumberOfDieInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBidNumberOfDieInputActionPerformed(evt);
            }
        });

        //where the face of the bid die is inputted
        //TODO link up with submit button
        playerBidDieFaceInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerBidDieFaceInputActionPerformed(evt);
            }
        });

        //From lines 113 to 211 is all just setting the background color of the dice
        player1Die1.setBackground(new java.awt.Color(255, 255, 255));
        player1Die1.setOpaque(true);
        player1Die1.setPreferredSize(new java.awt.Dimension(80, 80));

        player1Die2.setBackground(new java.awt.Color(255, 255, 255));
        player1Die2.setOpaque(true);
        player1Die2.setPreferredSize(new java.awt.Dimension(80, 80));

        player1Die3.setBackground(new java.awt.Color(255, 255, 255));
        player1Die3.setOpaque(true);
        player1Die3.setPreferredSize(new java.awt.Dimension(80, 80));

        player1Die4.setBackground(new java.awt.Color(255, 255, 255));
        player1Die4.setOpaque(true);
        player1Die4.setPreferredSize(new java.awt.Dimension(80, 80));

        player1Die5.setBackground(new java.awt.Color(255, 255, 255));
        player1Die5.setOpaque(true);
        player1Die5.setPreferredSize(new java.awt.Dimension(80, 80));

        player2Die1.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player2Die1.setOpaque(true);
        player2Die1.setPreferredSize(new java.awt.Dimension(80, 80));

        player5Die1.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player5Die1.setOpaque(true);
        player5Die1.setPreferredSize(new java.awt.Dimension(80, 80));

        player2Die3.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player2Die3.setOpaque(true);
        player2Die3.setPreferredSize(new java.awt.Dimension(80, 80));

        player2Die4.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player2Die4.setOpaque(true);
        player2Die4.setPreferredSize(new java.awt.Dimension(80, 80));

        player2Die5.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player2Die5.setOpaque(true);
        player2Die5.setPreferredSize(new java.awt.Dimension(80, 80));

        player2Die2.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player2Die2.setOpaque(true);
        player2Die2.setPreferredSize(new java.awt.Dimension(80, 80));

        player5Die2.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player5Die2.setOpaque(true);
        player5Die2.setPreferredSize(new java.awt.Dimension(80, 80));

        player5Die3.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player5Die3.setOpaque(true);
        player5Die3.setPreferredSize(new java.awt.Dimension(80, 80));

        player5Die4.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player5Die4.setOpaque(true);
        player5Die4.setPreferredSize(new java.awt.Dimension(80, 80));

        player5Die5.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player5Die5.setOpaque(true);
        player5Die5.setPreferredSize(new java.awt.Dimension(80, 80));

        player4Die1.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player4Die1.setOpaque(true);
        player4Die1.setPreferredSize(new java.awt.Dimension(80, 80));

        player3Die2.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player3Die2.setOpaque(true);
        player3Die2.setPreferredSize(new java.awt.Dimension(80, 80));

        player3Die3.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player3Die3.setOpaque(true);
        player3Die3.setPreferredSize(new java.awt.Dimension(80, 80));

        player3Die4.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player3Die4.setOpaque(true);
        player3Die4.setPreferredSize(new java.awt.Dimension(80, 80));

        player3Die5.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player3Die5.setOpaque(true);
        player3Die5.setPreferredSize(new java.awt.Dimension(80, 80));

        player3Die1.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player3Die1.setOpaque(true);
        player3Die1.setPreferredSize(new java.awt.Dimension(80, 80));

        player4Die2.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player4Die2.setOpaque(true);
        player4Die2.setPreferredSize(new java.awt.Dimension(80, 80));

        player4Die3.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player4Die3.setOpaque(true);
        player4Die3.setPreferredSize(new java.awt.Dimension(80, 80));

        player4Die4.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player4Die4.setOpaque(true);
        player4Die4.setPreferredSize(new java.awt.Dimension(80, 80));

        player4Die5.setBackground(new java.awt.Color(RGB, RGB, RGB));
        player4Die5.setOpaque(true);
        player4Die5.setPreferredSize(new java.awt.Dimension(80, 80));

        //puts dice image up
        playerBidDieFaceInput.setToolTipText("");

        playerBidDieFacejLabel.setText("Die Face");

        playerBidNumberOfDiejLabel.setText("Number of Die");

        //menu text and button add
        //TODO make all of these menu button do something
        hostGameMenuItem.setText("Host Game");
        jMenuBar1.add(hostGameMenuItem);

        joinGameMenuItem.setText("Join Game");
        jMenuBar1.add(joinGameMenuItem);

        exitGameMenuItem.setText("Exit Game");
        jMenuBar1.add(exitGameMenuItem);

        setJMenuBar(jMenuBar1);

        //start of setting the layout of the gui
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(player5Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player5Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player5Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player5Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player5Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(612, 612, 612)
                                                                .addComponent(playerBidDieFaceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player5Name)
                                                                .addGap(112, 112, 112)
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(playerBidDieFacejLabel)
                                                                .addGap(29, 29, 29)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addComponent(playerBidNumberOfDieInput, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(playerBidSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                                                .addComponent(player2Name))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addComponent(playerBidNumberOfDiejLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(355, 355, 355)
                                                .addComponent(challengePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(131, 131, 131)
                                                .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(player1Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(player1Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player1Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player1Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player1Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(player1Name)
                                                                .addGap(219, 219, 219)))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(player2Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(player2Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(player2Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(player2Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(player2Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(62, 62, 62))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(player4Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player4Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player4Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player4Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player4Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(player3Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player3Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player3Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player3Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(player3Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(203, 203, 203))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(349, 349, 349)
                                .addComponent(player4Name)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(player3Name)
                                .addGap(419, 419, 419))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(player4Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player4Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player4Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player4Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player4Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(player4Name))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(player3Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player3Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player3Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player3Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player3Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(player3Name)))
                                .addGap(63, 63, 63)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(playerBidDieFacejLabel)
                                                        .addComponent(playerBidNumberOfDiejLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(playerBidDieFaceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(playerBidNumberOfDieInput, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(playerBidSubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(284, 284, 284))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(player2Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player2Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(player2Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(49, 49, 49)
                                                                                .addComponent(player2Name)))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player2Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player2Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(player5Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player5Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addComponent(player5Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(18, 18, 18))
                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                .addComponent(player5Name)
                                                                                .addGap(49, 49, 49)))
                                                                .addComponent(player5Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(player5Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 48, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addComponent(player1Name)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(player1Die2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player1Die1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player1Die3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player1Die4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(player1Die5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nextTurnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(challengePlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37))))
        );
        Dice die = new Dice();
        setPlayerDiceImage();

        pack();
        setVisible(true);
    } //end of setting up gui components


    private void playerBidSubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    private void playerBidNumberOfDieInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }

    private void playerBidDieFaceInputActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO
    }



    /**
     *
     * @param args
     */

    public static void main(String[] args) {
        int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

            //catches some common errors or exceptions
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        NewJFrame gui = new NewJFrame();

    }

    public void setPlayerDiceImage() {
 //       DicePic = DicePhoto();
        Dice die = new Dice();
        Icon[] DicePic = die.DicePhoto();

        player1Die1.setIcon(DicePic[0]);
        player1Die2.setIcon(DicePic[1]);
        player1Die3.setIcon(DicePic[2]);
        player1Die4.setIcon(DicePic[3]);
        player1Die5.setIcon(DicePic[4]);

//        //gets pictures of javaapplication1.dice for player2 javaapplication1.dice
        player2Die1.setIcon(DicePic[5]);
        player2Die2.setIcon(DicePic[6]);
        player2Die3.setIcon(DicePic[7]);
        player2Die4.setIcon(DicePic[8]);
        player2Die5.setIcon(DicePic[9]);
//
//        //gets pictures of javaapplication1.dice for player3 javaapplication1.dice
        player3Die1.setIcon(DicePic[10]);
        player3Die2.setIcon(DicePic[11]);
        player3Die3.setIcon(DicePic[12]);
        player3Die4.setIcon(DicePic[13]);
        player3Die5.setIcon(DicePic[14]);

//        //gets pictures of javaapplication1.dice for player4 javaapplication1.dice
        player4Die1.setIcon(DicePic[15]);
        player4Die2.setIcon(DicePic[16]);
        player4Die3.setIcon(DicePic[17]);
        player4Die4.setIcon(DicePic[18]);
        player4Die5.setIcon(DicePic[19]);
//
//        //gets pictures of javaapplication1.dice for player5 javaapplication1.dice
        player5Die1.setIcon(DicePic[20]);
        player5Die2.setIcon(DicePic[21]);
        player5Die3.setIcon(DicePic[22]);
        player5Die4.setIcon(DicePic[23]);
        player5Die5.setIcon(DicePic[24]);
    }


    // Variables declaration - do not modify
    private javax.swing.JButton challengePlayer;
    private javax.swing.JMenu exitGameMenuItem;
    private javax.swing.JMenu hostGameMenuItem;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu joinGameMenuItem;

    private javax.swing.JTextPane previousBidTextDisplay;
    public javax.swing.JLabel player1Die1;
    public javax.swing.JLabel player1Die2;
    public javax.swing.JLabel player1Die3;
    public javax.swing.JLabel player1Die4;
    public javax.swing.JLabel player1Die5;
    public javax.swing.JLabel player1Name;
    public javax.swing.JLabel player2Die1;
    public javax.swing.JLabel player2Die2;
    public javax.swing.JLabel player2Die3;
    public javax.swing.JLabel player2Die4;
    public javax.swing.JLabel player2Die5;
    public javax.swing.JLabel player2Name;
    public javax.swing.JLabel player3Die1;
    public javax.swing.JLabel player3Die2;
    public javax.swing.JLabel player3Die3;
    public javax.swing.JLabel player3Die4;
    public javax.swing.JLabel player3Die5;
    public javax.swing.JLabel player3Name;
    public javax.swing.JLabel player4Die1;
    public javax.swing.JLabel player4Die2;
    public javax.swing.JLabel player4Die3;
    public javax.swing.JLabel player4Die4;
    public javax.swing.JLabel player4Die5;
    public javax.swing.JLabel player4Name;
    public javax.swing.JLabel player5Die1;
    public javax.swing.JLabel player5Die2;
    public javax.swing.JLabel player5Die3;
    public javax.swing.JLabel player5Die4;
    public javax.swing.JLabel player5Die5;
    public javax.swing.JLabel player5Name;
    public javax.swing.JTextField playerBidDieFaceInput;
    public javax.swing.JLabel playerBidDieFacejLabel;
    public javax.swing.JTextField playerBidNumberOfDieInput;
    public javax.swing.JLabel playerBidNumberOfDiejLabel;
    public javax.swing.JButton playerBidSubmitButton;
    public javax.swing.JButton nextTurnButton;

    // End of variables declaration
}
