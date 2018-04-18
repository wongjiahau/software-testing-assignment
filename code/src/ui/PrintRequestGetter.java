package ui;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;

import code.DesignEffectOption;
import code.DisplayUtility;
import code.HighQualityPaperOption;
import code.PrintOption;
import code.PrintRequest;
import exceptions.InvalidOptionException;
import exceptions.InvalidQuantityException;  


public class PrintRequestGetter extends Ui {
    public PrintRequestGetter(DisplayUtility du) {
        super(du);
    }
    public PrintRequest getPrintRequest() throws Exception {
        du.showToScreen("Enter quantity (1-100) :");
        int quantity = Integer.parseInt(du.getFromScreen());
        if(quantity <= 0 || quantity > 100) {
            throw new InvalidQuantityException(quantity);
        }
        du.showToScreen(
            "Select additional option: ",
            "1. High Quality Paper", 
            "2. Design Effect", 
            "3. Both",
            "4. None"
        );
        String optionStr = du.getFromScreen();
        if(!Pattern.matches("^[1234]$", optionStr)) {
            throw new InvalidOptionException(optionStr);
        }
        Set<PrintOption> options = new HashSet<PrintOption>();
        if(optionStr.equals("1")) {
            options.add(new HighQualityPaperOption());
        }
        if(optionStr.equals("2")) {
            options.add(new DesignEffectOption());
        }
        if(optionStr.equals("3")) {
            options.add(new HighQualityPaperOption());
            options.add(new DesignEffectOption());
        }
        if(optionStr.equals("4")) {
            /* Do nothing */
        }

        du.showToScreen("Enter image path :");
        String imagePath = du.getFromScreen();
        return new PrintRequest(quantity, options, imagePath);
    }
}