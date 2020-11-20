package flash_card_code;

import java.awt.*;

public class Colors {

    public static Colors INSTANCE = new Colors();

    public Color primaryColorGray(){
        return new Color(35, 41, 43);
    }

    public Color secondaryColorBlue(){
        return new Color(17, 70, 70);
    }

    public Color test(){
        return new Color(90, 80,90);
    }
    public Color textColor(){
        return Color.white;
    }

    public Color mouserHoverColor(){
        return secondaryColorBlue().darker();
    }
}
