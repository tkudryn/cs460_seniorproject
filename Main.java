package flash_card_code;


import java.io.*;
import java.lang.*;
import java.util.*;
import javax.swing.*;

//import static flash_card_code.FlashCardsGui.flashCardsGUI;

public class Main {

    //method for populating an arraylist by user input
    public static void populateByUI(ArrayList<QuestionObject> currentList, Scanner scanner) {
        /*
        TODO The gui should have this embedded in it. We will have to implement a finish button.
         */
        boolean finished = false;

        while (!finished) {
            System.out.println("Enter term");
            String uiTerm = scanner.nextLine();


            System.out.println("Enter definition");
            String uiDefinition = scanner.nextLine();

            QuestionObject currentQ = new QuestionObject(uiTerm, uiDefinition);
            currentList.add(currentQ);

            // TODO This feature will be replaced by a gui button
            System.out.println("would you like to continue? y/n");
            String option = scanner.nextLine();
            if (option.equals("n")) finished = true;

        }

    }

    //outputs an arrayList of type QuestionObject
    public static void outputList(ArrayList<QuestionObject> List)
    {
        for (QuestionObject questionObject : List) {
            System.out.println(questionObject.getTerm() + ": " +
                    questionObject.getDefinition());
        }

    }

    //am implemetation of a pretty lame gui
    public static void flashCardGUI(ArrayList<QuestionObject> List, Scanner scanner)
    {
        int i = 0;
        String outputTerm, userGuess;

        while(i < List.size())
        {
            //object member variables set for easier use of private variables
            String objTerm = List.get(i).getTerm();
            String objDef = List.get(i).getDefinition();

            outputTerm = JOptionPane.showInputDialog(null, "#"+ i +
                    ".\n\n" + objDef);
            i++;


            for(int j = 0; j < 3; j++) {
                if (outputTerm.equals(objTerm)) {
                    JOptionPane.showMessageDialog(null,"Correct guess");
                    break;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect guess. Try Again");
                    outputTerm = JOptionPane.showInputDialog(null, "#" + i + ".\n\n" + objDef);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<QuestionObject> currentList = new ArrayList<QuestionObject>();

        ArrayList<String> stringarray = new ArrayList<String>();


        //depending on the user preference, the files will be filled input by input, or by a formatted file
        System.out.println("Would you like to input term by term, or would you like to attach a formatted text file containing all terms?\n" +
                "Press: f = file, i = individual term by term input");

        String uiChoice = scanner.nextLine();

        //populates term by term
        if (uiChoice == "i") populateByUI(currentList, scanner);

        else {
            System.out.println("\nPlease make sure your file has a unique delimiter between each term and definition " +
                    "along with a period at the end of the definition \n" +
                    "\nEXAMPLE \ninput: definition\n");

            //following code pareses the file line by line.
            BufferedReader reader;
            try {
                reader = new BufferedReader(new FileReader("inputFile.txt"));

                //the following variables are manipulated inside the while following loop to help parse the file.
                String line = reader.readLine();
                String currentTerm = "";
                String currentDef = "";
                Boolean firstTermFound = false;

                while (line != null)
                {
                    //System.out.println(line);

                    for (int i = 0; i < line.length(); i++)
                    {
                       char currentChar = line.charAt(i);

                        //remainder of the string is a definition.
                        if(currentChar == ':') firstTermFound = true;

                        /*
                        if a period is encountered, this mean that the definition is finished.
                        This in turn means that the term and definition can and should be appended to the list of terms.
                        Along with that, the firsttermfound variable, the term and defintion variales should be reset (after appending to list)
                        TODO: need to replace the end of term variable with something other than a period,
                         but something that is still natural .
                         */
                        else if(currentChar == '.')
                        {
                            //System.out.println(currentTerm + ":" + currentDef);
                            QuestionObject currentObj = new QuestionObject(currentTerm, currentDef);
                            currentList.add(currentObj);
                            firstTermFound = false;
                            currentTerm = "";
                            currentDef = "";
                        }

                        //concatinating to term variable because semicolon has not been found yet
                        else if (!firstTermFound) {
                            currentTerm += currentChar;
                        }

                        else
                        {
                            currentDef += currentChar;
                        }
                    }
                    line = reader.readLine();
                }
                outputList(currentList);
                flashCardGUI(currentList, scanner);

            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}


