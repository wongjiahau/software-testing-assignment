package code;

import java.util.ArrayList;

public class Order {
    private ArrayList<PrintRequest> printRequests;
    public Order() {
        super();
    }

    public Order(ArrayList<PrintRequest> printRequests) {
        super();
        this.printRequests = printRequests;
    }

    public void addPrintRequests(PrintRequest printRequest) {
        this.printRequests.add(printRequest);
    }

    public ArrayList<PrintRequest> getPrintRequests() {
        return this.printRequests;
    }
}
