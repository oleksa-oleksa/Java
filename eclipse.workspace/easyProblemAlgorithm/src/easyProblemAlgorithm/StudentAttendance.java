/*You are given a string representing an attendance record for a student. 
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * 
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) 
 * or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
*/

package easyProblemAlgorithm;

import java.io.PrintWriter;

public class StudentAttendance {

	public static void main(String[] args) {
		boolean testBool = false;
		PrintWriter out = new PrintWriter(System.out, true);
		
		// Test cases
		out.printf("Test 1 PLLAPLLLLA: false is expected. %n Otput is: ");
		testBool = checkRecord("PLLAPLLLLA");
		checkResult(testBool, out);
		
		out.printf("Test 2 PAPPLLL: false is expected. %n Otput is: ");
		testBool = checkRecord("PAPPLLL");
		checkResult(testBool, out);

		out.printf("Test 3 PAPPLLPP: true is expected. %n Otput is: ");
		testBool = checkRecord("PAPPLLPP");
		checkResult(testBool, out);

		
	}

	public static boolean checkRecord(String s) {
        
        int a = 0; 
        int l = 0;
        int flag = 0;
        
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'A'){
                if (a == 1){
                    return false;
                }
                a++;
                flag= 0;
            }
            if (s.charAt(i) == 'L'){
                if (l >= 2 && flag >= 2){
                    return false;
                }
                l++;
                flag++;
            }
            if (s.charAt(i) == 'P'){
                flag = 0;
            }
        }
        return true;
    }

	public static void checkResult (boolean b, PrintWriter out){
		if (b == true){
			out.println("TRUE");
		}
		else {
			out.println("FALSE");
		}
	
	}
	
}
