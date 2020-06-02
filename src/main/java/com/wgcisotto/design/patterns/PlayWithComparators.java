package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.function.Comparator;
import com.wgcisotto.design.patterns.function.Function;
import com.wgcisotto.design.patterns.model.Person;

import java.util.Arrays;
import java.util.List;

public class PlayWithComparators {

    public static void main(String[] args) {

        Person mary = new Person("Mary", 28);
        Person john = new Person("John", 22);
        Person linda = new Person("Linda", 26);
        Person james = new Person("James", 32);
        Person jamesBis = new Person("James", 26);

        List<Person> people = Arrays.asList(mary, john, linda, james, jamesBis);

        people.sort((java.util.Comparator
                .comparing(Person::getName)
                .thenComparing(Person::getAge)));

        people.forEach(System.out::println);

        Function<Person, String> getName = Person::getName;
        Function<Person, Integer> getAge = Person::getAge;

        Comparator<Person> cmpName = Comparator.comparing(getName);
        Comparator<Person> cmpAge = Comparator.comparing(getAge);

        Comparator<Person> cmpNameReversed = cmpName.reversed();

        //Compose
        Comparator<Person> cmp = cmpName.thenComparing(cmpAge);

        //Compose more fluent
        Comparator<Person> cmpFluent =
                Comparator.comparing(Person::getName)
                        .thenComparing(Person::getAge);


        System.out.println("Mary > John : " + (cmpName.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpName.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpName.compare(linda, john) > 0));

        System.out.println();

        System.out.println("Mary > John : " + (cmpNameReversed.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpNameReversed.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpNameReversed.compare(linda, john) > 0));

        System.out.println();

        System.out.println("Mary > John : " + (cmpAge.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpAge.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpAge.compare(linda, john) > 0));

        System.out.println();

        System.out.println("Mary > John : " + (cmp.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmp.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmp.compare(linda, john) > 0));
        System.out.println("james > James Bis : " + (cmp.compare(james, jamesBis) > 0));

        System.out.println();

        System.out.println("Mary > John : " + (cmpFluent.compare(mary, john) > 0));
        System.out.println("John > James : " + (cmpFluent.compare(john, james) > 0));
        System.out.println("Linda > John : " + (cmpFluent.compare(linda, john) > 0));
        System.out.println("james > James Bis : " + (cmpFluent.compare(james, jamesBis) > 0));


    }

}
