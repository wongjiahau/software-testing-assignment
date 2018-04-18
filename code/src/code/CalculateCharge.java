package code;

import exceptions.InvalidQuantityException;

public class CalculateCharge {
	public double getChargePerPiece(PrintRequest printRequest) throws Exception {
		int quantity = printRequest.getQuantity();
		if(quantity < 1 || quantity > 100) {
			throw new InvalidQuantityException(quantity);	
		}
		double chargePerPrice = 
			quantity < 5  ? 1.00 : 
			quantity < 11 ? 0.90 :		
			quantity < 21 ? 0.70 :		
			quantity < 51 ? 0.50 :		
							0.10
			;
		for (PrintOption option : printRequest.getOptions()) {
			chargePerPrice += option.getChargePerPiece();
		}
		return chargePerPrice;
	}

	public double getPrintRequestCharge(PrintRequest printRequest) throws Exception {
		return this.getChargePerPiece(printRequest) * printRequest.getQuantity();
	}

	public double getOrderCharge(Order order) throws Exception {
		if(order.getPrintRequests().size() < 1) {
			throw new Exception("There are no print requests in this order.");
		}
		double totalCharge = 0;
		for (PrintRequest printRequest : order.getPrintRequests()) {
			totalCharge += this.getPrintRequestCharge(printRequest);
		}
		return totalCharge;
	}

}
