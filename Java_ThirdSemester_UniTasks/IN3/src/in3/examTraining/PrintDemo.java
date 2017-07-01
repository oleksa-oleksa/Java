package in3.examTraining;

import java.io.PrintWriter;

public class PrintDemo {

	public static void main(String[] args) {
		int i = 53978;
		PrintWriter out = new PrintWriter (System.out, true);
		out.printf("Simple arithmetic: %n%%5 from 200 is 10.%n");
		out.printf("Integer: %1$5d and HEX: %1$x%n", i);
		out.printf("Float digit:" + "#%1$-+15.2f#%1$+15.5f#%1$015f#%n", 123545.987);
		}

}
