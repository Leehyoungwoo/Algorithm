package codetree.objectSorting;

import java.util.*;

public class SortByKey {

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
                return a.height - b.height;
            }
        });
        printEach();
    }

    private static void printEach() {
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
