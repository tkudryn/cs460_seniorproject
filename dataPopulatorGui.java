package flash_card_code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class dataPopulatorGui implements ActionListener{

    //default frame and panel objects
    private static JFrame frame = new JFrame();
    private static JPanel mainPanel = new JPanel();
    private static JPanel topPanel = new JPanel();


    //default gui parameters TODO make resizable
    private static int frameWidth = 450; //TODO add resizing
    private static int frameHeight = 300;
    private static int topPanelHeight = 25;
    private static int startOfMainPanelHeight = topPanelHeight;

    //used labels
    private static JLabel termLabel;
    private static JLabel defLabel;

    //used textfields
    private static JTextField termTextField;
    private static JTextField defTextField;

    //used button
    private static JButton nextButton;
    private static JButton finishButton;

    //temporary terms that will be used throughout program
    private static String currentTerm;
    private static String currentDef;
    boolean changeAllowed = false;


    public static void setGui(){

        //setting default frame values TODO change to resiazable window that fills colors
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(frameWidth, frameHeight);
        //frame.setPreferredSize(new Dimension(frameWidth, frameHeight));

        //setting default top window
        topPanel.setBounds(0,0,frameWidth, topPanelHeight);
        topPanel.setBackground(Colors.INSTANCE.secondaryColorBlue());


        //setting default main panel size and color.
        mainPanel.setBounds(0, startOfMainPanelHeight, frameWidth, frameHeight-topPanelHeight);
        mainPanel.setBackground(Colors.INSTANCE.primaryColorGray());
        mainPanel.setLayout(null);

        //creating all labels
        termLabel = new JLabel("Term");
        termLabel.setBounds(40, 45, 80, 20);
        termLabel.setForeground(Colors.INSTANCE.textColor());

        defLabel = new JLabel("Definition");
        defLabel.setBounds(40, 90, 80, 20);
        defLabel.setForeground(Colors.INSTANCE.textColor());

        //creating all textFields
        termTextField = new JTextField();
        termTextField.setBackground(Colors.INSTANCE.secondaryColorBlue());
        termTextField.setForeground(Colors.INSTANCE.textColor());
        termTextField.setBounds(200, 45, 175, 20);

        defTextField = new JTextField();
        defTextField.setBackground(Colors.INSTANCE.secondaryColorBlue());
        defTextField.setForeground(Colors.INSTANCE.textColor());
        defTextField.setBounds(200, 90, 175, 20);

        //creating buttons
        nextButton = new JButton();
        nextButton.setText("Next Term");
        nextButton.setBounds(300, 135, 75, 15);
        nextButtonClick();

        finishButton = new JButton();
        finishButton.setText("Done");
        //finishButton.setBackground(Colors.INSTANCE.secondaryColorBlue());
        //finishButton.setForeground(Colors.INSTANCE.textColor());
        finishButton.setBounds(300, 165, 75, 15);
        finishButton.addActionListener(new dataPopulatorGui());
        finishButtonClick();

        //adding buttons, textfields and labels to the main panel
        mainPanel.add(termLabel);
        mainPanel.add(defLabel);
        mainPanel.add(termTextField);
        mainPanel.add(defTextField);
        mainPanel.add(nextButton);
        mainPanel.add(finishButton);

        //adding panels to frame
        frame.add(topPanel);
        frame.add(mainPanel);


        //setting the frame to be visible
        frame.setVisible(true);

    }

//    private Dimension getCustomDimensions(){
//        if ( changeAllowed ){
//            return new Dimension((int)(super.getParent().getBounds().width * 0.3), frame.getBounds().height);
//        }else{
//            return new Dimension(200, Main.getBounds().height);
//        }
//    }
//    @Override
//    public Dimension getMaximumSize(){
//        return getCustomDimensions();
//    }
//    @Override
//    public Dimension getMinimumSize(){
//        return getCustomDimensions();
//    }
//    @Override
//    public Dimension getPreferredSize(){
//        return getCustomDimensions();
//    }

    public static void main(String[] args){

        setGui();

    }


    //below are function that take care of the button presses that occur in this gui object
    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            File myfile = new File("input.txt");
            FileWriter writer = new FileWriter(myfile, true);
            BufferedWriter br = new BufferedWriter(writer);
            br.write(currentTerm + ": " + currentDef + ".\n");
            br.close();
            writer.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void nextButtonClick(){
        nextButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        currentTerm = termTextField.getText();
                        currentDef = defTextField.getText();

                        try {
                            System.out.println("done");
                            File myfile = new File("input.txt");
                            FileWriter writer = new FileWriter(myfile, true);
                            BufferedWriter br = new BufferedWriter(writer);
                            br.write(currentTerm + ": " + currentDef + ".\n");
                            br.close();
                            writer.close();

                        } catch(
                                IOException ex)

                        {
                            ex.printStackTrace();
                        }
                    }
                }
        );
    }

    public static void finishButtonClick(){
        finishButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        frame.dispose(); // for now
                    }
                }
        );
    }

}


