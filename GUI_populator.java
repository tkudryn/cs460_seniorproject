package flash_card_code;

import javax.swing.*;
import java.awt.event.*;
import java.lang.reflect.Array;
import java.util.*;


public class GUI_populator implements ActionListener {

    //terms and labels that are used in main and the other funcitons
    private static JLabel termLabel;
    private static JTextField termText;
    private static JLabel defLabel;
    private static JTextField defText;
    private static JButton confirmTerm;
    private static JLabel success;
    private static JButton next;

    private static String currentTerm;
    private static String currentDef;



    //this function creates a GUI for the user to input terms and definitions
    public static void populatebyGUI(ArrayList<QuestionObject> List){



        int i = 0;

            //creating frame and setting all generic "settings"
            JFrame frame = new JFrame();
            JPanel panel = new JPanel();

            frame.setSize(350, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);

            panel.setLayout(null);

            //creating label for inputting the term acceptor.
            termLabel = new JLabel("Term");
            termLabel.setBounds(10, 20, 80, 25);
            panel.add(termLabel);

            termText = new JTextField(20);
            termText.setBounds(120, 20, 165, 25);
            panel.add(termText);

            //creating label for inputting the definition acceptor.
            defLabel = new JLabel("Definition");
            defLabel.setBounds(10, 50, 80, 25);
            panel.add(defLabel);

            defText = new JTextField(20);
            defText.setBounds(120, 50, 165, 25);
            panel.add(defText);

            confirmTerm = new JButton("confirm");
            confirmTerm.setBounds(10, 80, 80, 25);
            confirmTerm.addActionListener(new GUI_populator());
            panel.add(confirmTerm);

            //test action when button is pressed
            success = new JLabel();
            success.setBounds(10, 110, 300, 25);
            panel.add(success);

            QuestionObject currentObject = new QuestionObject(currentTerm, currentDef);
            List.add(currentObject);


            frame.setVisible(true);
    }



    public static void main(String args[]){
        ArrayList<QuestionObject> dataList = new ArrayList<QuestionObject>();

        populatebyGUI(dataList);
        for(int i = 0; i < dataList.size(); i++){
            System.out.println(dataList.get(i).getTerm() + ": " + dataList.get(i).getDefinition());
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        //setting term and definition to what ever the user input using the .getText() function
        currentTerm = termText.getText();
        currentDef = defText.getText();


        //adding the current term to the List containing all the terms and definitions
        System.out.println(currentTerm + " " + currentDef);
        if(currentTerm != null && currentDef != null){
            success.setText("Enter next input");
            System.exit(0);
        }
    }
}

