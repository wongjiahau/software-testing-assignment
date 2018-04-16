package code;

import java.util.ArrayList;

public class Order {
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((printRequests == null) ? 0 : printRequests.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (printRequests == null) {
			if (other.printRequests != null)
				return false;
		} else if (!printRequests.equals(other.printRequests))
			return false;
		return true;
	}

	private ArrayList<PrintRequest> printRequests;
    public Order() {
        super();
        this.printRequests = new ArrayList<PrintRequest>();
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
