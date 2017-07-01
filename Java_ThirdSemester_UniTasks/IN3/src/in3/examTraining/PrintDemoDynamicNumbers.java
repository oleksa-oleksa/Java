// the next should be printed only with two prints-commands, each of them has only one '\n'

//123456789012345
//       11111
//        1111
//         111
//          11
//           1

package in3.examTraining;

public class PrintDemoDynamicNumbers {
	public static void main(String[] args){
		dynamicNumbers();
	}
	
	public static void dynamicNumbers(){
		System.out.printf("%-15s%n", "123456789012345");
		
		for (int i = 11111; i >= 1; i /= 10){
			System.out.printf("% 12d%n", i);
		}
	}
}
