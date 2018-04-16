package ui;

import java.util.regex.Pattern;

import code.DisplayUtility;
import code.Order;

public class OrderGetter extends Ui {
    private PrintRequestGetter printRequestGetter;
    public OrderGetter(DisplayUtility du) {
        super(du);
        this.printRequestGetter = new PrintRequestGetter(du);
    }

    public Order getOrder() throws Exception {
        Order order = new Order();
        while(true) {
            order.addPrintRequests(printRequestGetter.getPrintRequest());
            this.du.showToScreen("Do you have any more photo to be printed? (y/n)");
            String userInput = this.du.getFromScreen();
            if(!Pattern.matches("^[yY]$", userInput)) {
                return order;
            }
        }
    }

}
