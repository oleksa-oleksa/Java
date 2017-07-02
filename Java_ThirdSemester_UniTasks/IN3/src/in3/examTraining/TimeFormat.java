package in3.examTraining;
// Gibt die als Parameterwert in Sekunden übergebene Zeit als String zurück, der die Zeit
// im Format hh:mm:ss darstellt. Dabei sind die Angaben für Stunden, Minuten und
// Sekunden jeweils zweistellig. 
// Falls der übergebene Wert von time_s > 24*3600 ist, 
// soll der String >1 Tag zurückgegeben werden. 
// Ist der übergebene Wert von time_s kleiner als Null, 
// dann soll der String ungultig zurückgegeben werden.

public class TimeFormat {
	
	public static void main(String[] args){
		// test cases
		System.out.println(timeFormatted(15));
		System.out.println(timeFormatted(3600));
		System.out.println(timeFormatted(3601));
		System.out.println(timeFormatted(5418));
		System.out.println(timeFormatted(45123));
		System.out.println(timeFormatted(80790));
		System.out.println(timeFormatted(90000));
		System.out.println(timeFormatted(0));
		System.out.println(timeFormatted(-100));
	}
	
	public static String timeFormatted(int time_s){
		
		int hour = 0;
		int min;
		int sec;
		
		if (time_s > 86400){
			return "Wow, it is longer than one day!";
		} else if (time_s < 0){
			return "Bad time parameter";
		} else {
			hour = time_s / 3601;
			min = (time_s - hour * 3600) / 60;
			sec = time_s - (min * 60) - hour * 3600;
		}
		String myTime = String.format("%02d:%02d:%02d", hour, min, sec); 
		return myTime;
	}
}
