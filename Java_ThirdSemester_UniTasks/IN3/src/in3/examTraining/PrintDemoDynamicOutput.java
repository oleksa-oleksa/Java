package in3.examTraining;

public class PrintDemoDynamicOutput {
	
	public static void main (String[] args){
		
		int D = 13;
		int hMax = 16;
		
		for (int h = 0; h <= hMax; h++){
			System.out.printf("%" + d(h, D) + "s%0" + 2*(D-d(h, D)) + "d%n", " ", 0);
		}
		// iterations: 
		// h = 0: %12s%02d => gives 12 whitespace and + 2 Nulls
		// h = 1: %11s04d => gives 11 whitespace and 4 Nulls
		// because the output is right aligned, we will get the effect of triangle
	}
	
	public static int d (int h, int D){
		double m = 0.75;
		int hMax = 16;
		int hBranch = 3;
		int hBase = 0;
	
		if ((hMax - h) <= hBase){
			return D - 6;
		} else if ((hMax - h) <= hBranch) {
			return D - 2;
		} else {
			return (int) (m * (hMax - h));
		}
	}
}
