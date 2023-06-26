package codetree.objectSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortByHeightAndWeight {

    private static int n;
    private static Person[] people;

    static class Person {
        String name;
        int height;
        int weight;

        public Person(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                if (a.height == b.height) {
                    return b.weight - a.weight;
                }
                return a.height - b.height;
            }
        });
        printAll();
    }

    private static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(people[i].name + " "
                    + people[i].height + " "
                    + people[i].weight);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        people = new Person[n];

        for (int i = 0; i < n; i++) {
            String name = input.next();
            int height = input.nextInt();
            int weight = input.nextInt();

            people[i] = new Person(name, height, weight);
        }
    }
}
