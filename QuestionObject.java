package flash_card_code;

import java.lang.*;

public class QuestionObject {
    private String term;
    private String definition;

    //default constructor
    QuestionObject()
    {
        term = null;
        definition = null;
    }

    //overwritten constructor
    QuestionObject(String uiTerm, String uiDefinition)
    {
        term = uiTerm;
        definition = uiDefinition;
    }


    public String getTerm() {
        return term;
    }

    public String getDefinition(){
        return definition;
    }

}

