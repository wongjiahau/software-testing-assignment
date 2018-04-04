package code;
import java.awt.Image;
import java.util.Set;

public class PrintRequest {
    private int quantity;
    private Set<PrintOption> options;
    private Image image;
    public PrintRequest(int quantity, Set<PrintOption> options, Image image) throws Exception {
		if(quantity < 1 || quantity > 100) {
			throw new Exception("Expected quantity to be between 1 to 100 but got " + this.quantity);
		}
        this.quantity = quantity;
        this.options  = options;
        this.image    = image;
	}
	
	public double getChargePerPiece() {
		double chargePerPrice = 
			this.quantity < 6  ? 1.00 : 
			this.quantity < 11 ? 0.90 :		
			this.quantity < 21 ? 0.70 :		
			this.quantity < 51 ? 0.50 :		
								 0.10
			;
		for (PrintOption option : this.options) {
			chargePerPrice += option.getChargPerPiece();
		}

		return chargePerPrice;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the options
	 */
	public Set<PrintOption> getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(Set<PrintOption> options) {
		this.options = options;
	}
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}


}
