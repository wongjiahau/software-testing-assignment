package ui;

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
        order = orderGetter.getOrder();
        calculateCharge.getOrderCharge(order);
        for (PrintRequest printRequest : order.getPrintRequests()) {
            photoPrinter.queueRequest(printRequest);
        }
    }

    public Order getCurrentOrder() {
        return order;
    }

}