package flash_card_code;

import java.util.*;

public class HangMan {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);

        QuestionObject object = new QuestionObject("tim", "9th kudryn");
        QuestionObject object1 = new QuestionObject("ed", "10th kudryn");

        ArrayList<QuestionObject> List = new ArrayList<QuestionObject>();
        List.add(object);
        List.add(object1);

        for(int i = 0; i < List.size(); i++){

            System.out.println(List.get(i).getDefinition());
            String currentTerm = List.get(i).getTerm();

            char a;
            StringBuilder currentCorrect = new StringBuilder();
            for(int b = 0; b < currentTerm.length(); b++){
                currentCorrect.append("_");
            }
            for(int j = 0; j < 6; j++)
            {
                boolean charFound = false;

                System.out.println("enter input\n");
                a = scanner.next().charAt(0);

                for(int k = 0; k < currentTerm.length(); k++)
                {
                    if(currentTerm.charAt(k) == a)
                    {
                        currentCorrect.setCharAt(k,a);
                        charFound =true;
                    }
                }
                if(charFound) {
                    System.out.println("here");
                    j--;
                }
                if(currentCorrect.toString().equals(currentTerm)) {
                    System.out.println("CORRECT!");
                    break;
                }
                System.out.println(currentCorrect);
            }
        }
    }
}
