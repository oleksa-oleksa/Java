package in3.examTraining;

public abstract class BasicPictureData {
	protected int width;
	protected int height;
	public BasicPictureData (int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public double getPixelCount() {
		return width*height;
	}
	
	protected String sizeToString() {
		return width +  " X " + height;
	}
	
	protected abstract String getPictureType();
	
	public String toString() {
		return getPictureType() + ": " + sizeToString();
	}
}
