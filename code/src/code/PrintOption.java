package code;
public abstract class PrintOption {
    private String optionName;
    protected PrintOption(String optionName) {
        super();
        this.optionName = optionName;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((optionName == null) ? 0 : optionName.hashCode());
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
		PrintOption other = (PrintOption) obj;
		if (optionName == null) {
			if (other.optionName != null)
				return false;
		} else if (!optionName.equals(other.optionName))
			return false;
		return true;
	}

    public abstract double getChargePerPiece();
}
