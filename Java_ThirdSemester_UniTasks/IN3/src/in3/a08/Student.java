package in3.a08;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Student extends Person {
	
		public static void main(String[] args) {
			PrintWriter out = new PrintWriter (System.out, true);
			
			for(Person p : Student.createTestPersons()){
				out.println(p);
			}
			
		}
		
		//two new fields for the subclass 
		public int enrolmentNo;
		public String degreeCourse;
		
		//inheritance 
		public Student (String name, String familyName, int yearOfBirth, String degreeCourse, int enrolmentNo){
			super(name, familyName, yearOfBirth);
			this.enrolmentNo = enrolmentNo;
			this.degreeCourse = degreeCourse;
		}
		
		public String toString (){
			return super.toString() + " " + degreeCourse + " s" + Integer.toString(enrolmentNo);
		}
		
		public static Set<Person> createTestPersons(){
			Set<Person> testPersons = new HashSet<Person>();
			Random rand = new Random();
			String[] names = {"Oleg", "Katerina", "Oleksandra", "Tim", "Larisa", "Natalya", "Roman", "Kirill", "Iryna", "Bogdan"};
			String[] familyNames = {"Schulz", "Schmidt", "Muller", "Schreiber", "Dieser", "Bertando", "Cortador", "Dachlos", "Kroneberg", "Littenburg"};
			int[] yearsOfBirth = {1982, 1961, 1969, 1938, 1939, 1991, 1987, 1990, 1997, 1978};
			String[] degreeCourse = {"Computer Engineering", "Media Informatics", "Music", "Fine Arts", "Beer Manufacturing"};
			
			for (int i = 0; i < 5; i++){
				int  nNames = rand.nextInt(names.length);
				int  nFamNames = rand.nextInt(familyNames.length);
				int  nYears = rand.nextInt(yearsOfBirth.length);

				testPersons.add(new Person(names[nNames], familyNames[nFamNames], yearsOfBirth[nYears]));
			}
			
			for (int i = 0; i < 5; i++){
				int  nNames = rand.nextInt(names.length);
				int  nFamNames = rand.nextInt(familyNames.length);
				int  nYears = rand.nextInt(yearsOfBirth.length);
				int nCourse = rand.nextInt(degreeCourse.length);
				int j = rand.nextInt(5000) + 85000; // 85000 - 90000 as enrollment number
				
				testPersons.add(new Student(names[nNames], familyNames[nFamNames], yearsOfBirth[nYears], degreeCourse[nCourse], j));
			}
			
			return testPersons;
		}

}
