package ui;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import code.CalculateCharge;
import code.DisplayUtility;
import code.Order;
import code.PhotoPrinter;
import code.PrintRequest;

public class App extends Ui {
    Order order;
    CalculateCharge calculateCharge;
    OrderGetter orderGetter;
    PhotoPrinter photoPrinter;
    double charge;

    public static void main(String[] args) {
        DisplayUtility du = new DisplayUtility();
        App app = new App(du, new OrderGetter(du), new CalculateCharge(), new PhotoPrinter());
        while(true) {
            try {
                app.run();
            } catch (Exception ex) {
                du.showToScreen("ERROR : ");
                du.showToScreen(ex.getMessage());
                du.pressAnyKeyToContinue();
            }
        }
    }


    public App(
        DisplayUtility displayUtility, 
        OrderGetter orderGetter, 
        CalculateCharge calculateCharge,
        PhotoPrinter photoPrinter
    ) {
        super(displayUtility);
        this.orderGetter = orderGetter;
        this.calculateCharge = calculateCharge;
        this.photoPrinter = photoPrinter;
    }

    public void run() throws Exception {
        NumberFormat formatter = new DecimalFormat("#0.00");     
        order = orderGetter.getOrder();
        for (int i = 0; i < order.getPrintRequests().size(); i++) {
            du.showToScreen("The charge of print request #" + (i + 1) + " is RM"
                + formatter.format(
                    calculateCharge.getPrintRequestCharge(order.getPrintRequests().get(i))
                )
            ); 
        }
        charge = calculateCharge.getOrderCharge(order);
        du.showToScreen("The charge of the order is RM" + formatter.format(charge));
        for (PrintRequest printRequest : order.getPrintRequests()) {
            photoPrinter.queueRequest(printRequest);
        }
        du.pressAnyKeyToContinue();
    }

    public Order getCurrentOrder() {
        return order;
    }

}