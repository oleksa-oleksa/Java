package in3.a07;

import java.util.Scanner;


public class Person {

	protected String name;
	protected String familyName;
	protected int yearOfBirth;
	
	
	public Person(String name, String familyName, int yearOfBirth){
		this.name = name;
		this.familyName = familyName;
		this.yearOfBirth = yearOfBirth;
	}
	
	public Person(Person p){
		this(p.name, p.familyName, p.yearOfBirth);
	}
	
	public Person(lernhilfe2013ws.objectPlay.Person p){
		this.name = p.getVorname();
		this.familyName = p.getNachname();
		this.yearOfBirth = p.getGeburtsjahr();
	}
	
	public String getName(){
		return name;
	}
	
	public String getFamilyName(){
		return familyName;
	}
	
	public int getYearOfBirth(){
		return yearOfBirth;
	}
	
	public String toString(){
		String s = name + " " + familyName + " " + Integer.toString(yearOfBirth);
		return s;
	}
	
	public static Person createPerson(Scanner in){
		String name = in.next();
		String familyName = in.next();
		int year = in.nextInt();
		Person newHuman = new Person(name, familyName, year);
		return newHuman;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((familyName == null) ? 0 : familyName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + yearOfBirth;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (familyName == null) {
			if (other.familyName != null)
				return false;
		} else if (!familyName.equals(other.familyName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (yearOfBirth != other.yearOfBirth)
			return false;
		return true;
	}
}
