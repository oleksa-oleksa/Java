package in3.examTraining;

public class PictureData extends BasicPictureData{
	
	protected int farbtiefe;
	
	public PictureData(int width, int height, int farbtiefe){
		super(width, height);
		this.farbtiefe = farbtiefe;
	}
	
	public PictureData(PictureData other){
		this (other.width, other.height, other.farbtiefe);
	}
	
	public PictureData(Dimension d, int farbtiefe){
		this (d.width, d.height, farbtiefe);
	}
	
	protected String getPictureType(){
		if (farbtiefe == 2){
			return "SW-Bild";
		}
		return "Farbbild";
	}
	
	public String toString() {
		return super.toString() + ", " + farbtiefe + " bit";
	}

}
