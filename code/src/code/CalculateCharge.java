package code;

public class CalculateCharge {
	public double getChargePerPiece(PrintRequest printRequest) {
		double chargePerPrice = 
			printRequest.getQuantity() < 5  ? 1.00 : 
			printRequest.getQuantity() < 11 ? 0.90 :		
			printRequest.getQuantity() < 21 ? 0.70 :		
			printRequest.getQuantity() < 51 ? 0.50 :		
                                              0.10
			;
		for (PrintOption option : printRequest.getOptions()) {
			chargePerPrice += option.getChargePerPiece();
		}
		return chargePerPrice;
	}

}
