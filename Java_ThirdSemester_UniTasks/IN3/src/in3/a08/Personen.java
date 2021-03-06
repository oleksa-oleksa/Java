package in3.a08;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

import lernhilfe2013ws.io.DirtyFileReader;
import lernhilfe2013ws.io.DirtyFileWriter;
import lernhilfe2013ws.objectPlay.Factory;

public class Personen {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Set<Person> personSet = new HashSet<Person>();
		String testPersonsFile = "./testfiles/persons_b.txt";
		
		for (lernhilfe2013ws.objectPlay.Person p : Factory.createTestPersonliste()){
			personSet.add(new Person (p));
		}
		PrintWriter out = new PrintWriter(System.out, true);
		printPersons(personSet, out);
		printPersons(personSet, testPersonsFile);
		demoMengenOperationen();
	}
	
	public static void printPersons(Set<Person> persons, PrintWriter out){
		// converting set back to array
		Person[] printPersons = new Person[persons.size()];
		persons.toArray(printPersons);
		for (int i = 0; i < printPersons.length; i++){
			Person p = printPersons[i];
			out.format("%s %s %d%n", p.getName(), p.getFamilyName(), p.getYearOfBirth());
		}
	}
	
	public static void printPersons(Set<Person> persons, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout);
		fout.flush();
		fout.close();
	}
	
	public static Set<Person> getPersonsFrom(Scanner in){
		Set<Person> people = new HashSet<Person>();
		while (in.hasNext()){
			Person p = Person.createPerson(in);
			people.add(p);
		}
		return people;
	}
	
	public static Set<Person> getPersonsFrom(String filename){
		DirtyFileReader dfr = new DirtyFileReader(filename);
		Scanner in = new Scanner(dfr);
		return getPersonsFrom(in);
	}
	
	public static void demoMengenOperationen(){
		Set<Person> sportFriends = getPersonsFrom("./persondata/sportfreunde.txt");
		Set<Person> uniFriends = getPersonsFrom("./persondata/kommilitonen.txt");
		
		// Intersection
		Set<Person> interSet = new HashSet<Person>(sportFriends);
		interSet.retainAll(uniFriends);
		printPersons(interSet, "./persondata/SundK.txt");
		
		// Difference
		Set<Person> diffSet = new HashSet<Person>(uniFriends);
		diffSet.remove(sportFriends);
		printPersons(diffSet, "./persondata/KaberNichtS.txt");
		
		// Union
		Set<Person> unionSet = getPersonsFrom("./testfiles/persons_b.txt");
		unionSet.addAll(uniFriends);
		printPersons(unionSet, "./persondata/TvereinigtK.txt");
	}
}


