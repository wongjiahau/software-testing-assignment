package ui;

import code.DisplayUtility;
import code.Order;

public class OrderGetter extends Ui {
    private PrintRequestGetter printRequestGetter;
    public OrderGetter(DisplayUtility du) {
        super(du);
        this.printRequestGetter = new PrintRequestGetter();
    }

    public Order getOrder() throws Exception {
        Order order = new Order();
        while(true) {
            order.addPrintRequests(this.getPrintRequest());
            this.du.showToScreen("Do you have any more photo to be printed? (y/n)");
            String userInput = this.du.getFromScreen();
            if(!Pattern.matches("^[yY]$", userInput)) {
                return order;
            }
        }
    }

}
