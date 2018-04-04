import java.awt.Image;
import java.util.Set;

public class PrintRequest {
    private int quantity;
    private Set<PrintOption> options;
    private Image image;
    public PrintRequest(int quantity, Set<PrintOption> options, Image image) {
        this.quantity = quantity;
        this.options  = options;
        this.image    = image;
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
