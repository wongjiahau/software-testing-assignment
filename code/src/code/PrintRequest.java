package code;
import java.util.Set;

public class PrintRequest {
    private int quantity;
    private Set<PrintOption> options;
    private String imagePath;
    public PrintRequest(int quantity, Set<PrintOption> options, String imagePath) {
        this.quantity  = quantity;
        this.options   = options;
        this.imagePath = imagePath;
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

	public String getImage() {
		return imagePath;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(String image) {
		this.imagePath = image;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((imagePath == null) ? 0 : imagePath.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		result = prime * result + quantity;
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
		PrintRequest other = (PrintRequest) obj;
		if (imagePath == null) {
			if (other.imagePath != null)
				return false;
		} else if (!imagePath.equals(other.imagePath))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
