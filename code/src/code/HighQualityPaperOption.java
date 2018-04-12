package code;

public class HighQualityPaperOption extends PrintOption {
	public HighQualityPaperOption() {
		super("HighQualityPaper");
	}

	@Override
	public double getChargePerPiece() {
		return 0.10;
	}

}
