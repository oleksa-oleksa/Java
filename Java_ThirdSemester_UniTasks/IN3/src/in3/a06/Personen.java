package in3.a06;

import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import lernhilfe2013ws.io.DirtyFileReader;
import lernhilfe2013ws.io.DirtyFileWriter;
import lernhilfe2013ws.objectPlay.Factory;
import lernhilfe2013ws.objectPlay.Person;
import lernhilfe2013ws.objectPlay.PersonSet;

public class Personen {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Person[] myTestPersons = Factory.createTestPersons();
		PersonSet personSet = new PersonSet();
		String personsB = "./testfiles/persons_b.txt";
		
		for (int i = 0; i < myTestPersons.length; i++){
			personSet.add(myTestPersons[i]);
		}
		PrintWriter out = new PrintWriter(System.out, true);
		printPersons(personSet, out);
		printPersons(personSet, personsB);
		demoMengenOperationen();
	}
	
	public static void printPersons(PersonSet persons, PrintWriter out){
		// converting set back to array
		Person[] printPersons = persons.toArray();
		for (int i = 0; i < printPersons.length; i++){
			Person p = printPersons[i];
			out.format("%s %s %d%n", p.getVorname(), p.getNachname(), p.getGeburtsjahr());
		}
	}
	
	public static void printPersons(PersonSet persons, String filename){
		PrintWriter fout = new PrintWriter(new DirtyFileWriter(filename));
		printPersons(persons, fout);
		fout.flush();
		fout.close();
	}
	
	public static Person createPerson(Scanner in){
		String name = in.next();
		String familyName = in.next();
		int year = in.nextInt();
		Person newHuman = new Person(name, familyName, year);
		return newHuman;
	}
	
	public static PersonSet getPersonsFrom(Scanner in){
		PersonSet people = new PersonSet();
		while (in.hasNext()){
			Person p = createPerson(in);
			people.add(p);
		}
		return people;
	}
	
	public static PersonSet getPersonsFrom(String filename){
		DirtyFileReader dfr = new DirtyFileReader(filename);
		Scanner in = new Scanner(dfr);
		return getPersonsFrom(in);
	}
	
	public static void demoMengenOperationen(){
		PersonSet sportFriends = getPersonsFrom("./persondata/sportfreunde.txt");
		PersonSet uniFriends = getPersonsFrom("./persondata/kommilitonen.txt");
		
		// Intersection
		PersonSet interSet = new PersonSet(sportFriends);
		interSet.retainAll(uniFriends);
		printPersons(interSet, "./persondata/SundK.txt");
		
		// Difference
		PersonSet diffSet = new PersonSet(uniFriends);
		diffSet.remove(sportFriends);
		printPersons(diffSet, "./persondata/KaberNichtS.txt");
		
		// Union
		PersonSet unionSet = getPersonsFrom("./testfiles/persons_b.txt");
		unionSet.addAll(uniFriends);
		printPersons(unionSet, "./persondata/TvereinigtK.txt");
	}
}


