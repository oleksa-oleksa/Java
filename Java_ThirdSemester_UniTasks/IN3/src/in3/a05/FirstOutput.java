package in3.a05;

import java.io.PrintWriter;
import java.util.Locale;
import lernhilfe2013ws.io.DirtyFileWriter;

public class FirstOutput {

	public static void main(String[] args) {
	Locale.setDefault(Locale.US);
	dirtyFileWriterTesten();
	}
	
	public static void dirtyFileWriterTesten(){
		DirtyFileWriter dfw = new DirtyFileWriter("./testfiles/zahlen-test-001.txt");
		PrintWriter fout = new PrintWriter(dfw, true);
		
		//test 1
		for (int i = 1; i < 10; i++){
			fout.println(i);
		}
		
		fout.printf("%n");
		
		//test 2
		for (int i = 1; i < 1000; i++){
			fout.printf("%4d",i);
			if (i % 25 == 0){
				fout.printf("%n");
			}
		}
		
		fout.printf("%n%n");
		
		//test 3
		for (int i = 1; i < 1000; i++){
			fout.printf("%11d",i);
			if (i % 10 == 0){
				fout.printf("%n");
			}
		}
				
		fout.close();
	}

}
