package code;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.*;  


public class OrderGetter {
    private DisplayUtility du;

    public OrderGetter(DisplayUtility displayUtility) {
        super();
        this.du = displayUtility;
    }

    public PrintRequest getRequest() throws Exception {
        this.du.showToScreen("Enter quantity");
        int quantity = Integer.parseInt(this.du.getFromScreen());
        if(quantity <= 0 || quantity > 100) {
            throw new NumberFormatException();
        }
        this.du.showToScreen(
            "Select additional option: " + 
            "1. High Quality Paper" + 
            "2. Design Effect" + 
            "3. Both"
        );
        String optionStr = this.du.getFromScreen();
        if(!Pattern.matches("^[123]$", optionStr)) {
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
        return new PrintRequest(quantity, options, null);
    }
}
