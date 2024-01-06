package se.lexicon;

import se.lexicon.data.DataStorage;
import se.lexicon.model.Gender;
import se.lexicon.model.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.ToIntFunction;

public class Exercises {

    private final static DataStorage storage = DataStorage.INSTANCE;

    /*
       1.	Find everyone that has firstName: “Erik” using findMany().
    */
    public static void exercise1(String message) {
        System.out.println(message);
        //Write your code here
        for (Person p : storage.findMany((person -> Objects.equals(person.getFirstName(), "Erik")))) {
            System.out.println(p);
        }
        System.out.println("----------------------");
    }

    /*
        2.  Find all females in the collection using findMany().
     */
    public static void exercise2(String message) {
        System.out.println(message);
        //Write your code here
        for (Person p : storage.findMany((person -> Objects.equals(person.getGender(), Gender.FEMALE)))) {
            System.out.println(p);
        }
        System.out.println("----------------------");
    }

    /*
        3.  Find all who are born after (and including) 2000-01-01 using findMany().
     */
    public static void exercise3(String message) {
        System.out.println(message);
        //Write your code here
        for (Person p : storage.findMany((person -> person.getBirthDate().isAfter(LocalDate.parse("1999-12-31"))))) {
            System.out.println(p);
        }
        System.out.println("----------------------");
    }

    /*
        4.  Find the Person that has an id of 123 using findOne().
     */
    public static void exercise4(String message) {
        System.out.println(message);
        //Write your code here
        System.out.println(storage.findOne((person -> person.getId() == 123)));
        System.out.println("----------------------");

    }

    /*
        5.  Find the Person that has an id of 456 and convert to String with following content:
            “Name: Nisse Nilsson born 1999-09-09”. Use findOneAndMapToString().
     */
    public static void exercise5(String message) {
        System.out.println(message);
        //Write your code here
        System.out.println(storage.findOneAndMapToString(
                person -> person.getId() == 456,
                person -> "Name: " + person.getFirstName() + " " + person.getLastName() + " born " + person.getBirthDate())
        );
        System.out.println("----------------------");
    }

    /*
        6.	Find all male people whose names start with “E” and convert each to a String using findManyAndMapEachToString().
     */
    public static void exercise6(String message) {
        System.out.println(message);
        //Write your code here
        for (String s : storage.findManyAndMapEachToString(
                person -> (Objects.equals(person.getGender(), Gender.MALE) && person.getFirstName().startsWith("E")),
                person -> "Name: " + person.getFirstName() + " " + person.getLastName() + " born " + person.getBirthDate()
        )) {
            System.out.println(s);
        }

        System.out.println("----------------------");
    }

    /*
        7.	Find all people who are below age of 10 and convert them to a String like this:
            “Olle Svensson 9 years”. Use findManyAndMapEachToString() method.
     */
    public static void exercise7(String message) {
        System.out.println(message);
        //Write your code here
        ToIntFunction<LocalDate> years = birthDate -> Math.toIntExact(birthDate.until(LocalDate.now(), ChronoUnit.YEARS));
        for (String s : storage.findManyAndMapEachToString(
                person -> years.applyAsInt(person.getBirthDate()) < 10,
                person -> person.getFirstName() + " " +
                        person.getLastName()+ " " +
                        years.applyAsInt(person.getBirthDate()) + " years"
        )) {
            System.out.println(s);
        }

        System.out.println("----------------------");
    }

    /*
        TODO:  8.	Using findAndDo() print out all people with firstName “Ulf”.
     */
    public static void exercise8(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  9.	Using findAndDo() print out everyone who have their lastName contain their firstName.
     */
    public static void exercise9(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  10.	Using findAndDo() print out the firstName and lastName of everyone whose firstName is a palindrome.
     */
    public static void exercise10(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  11.	Using findAndSort() find everyone whose firstName starts with A sorted by birthdate.
     */
    public static void exercise11(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  12.	Using findAndSort() find everyone born before 1950 sorted reversed by lastest to earliest.
     */
    public static void exercise12(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }

    /*
        TODO:  13.	Using findAndSort() find everyone sorted in following order: lastName > firstName > birthDate.
     */
    public static void exercise13(String message) {
        System.out.println(message);
        //Write your code here

        System.out.println("----------------------");
    }
}
