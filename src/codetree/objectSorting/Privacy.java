package codetree.objectSorting;

import java.util.*;

public class Privacy {

    private final static Person[] people = new Person[5];

    static class Person {
        String name;
        int height;
        float weight;

        public Person(String name, int height, float weight) {
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
                int compareResult = a.name.compareTo(b.name);
                if (compareResult < 0) {
                    return -1;
                } else if (compareResult > 0) {
                    return 1;
                }
                return 0;
            }
        });
        printByName();
        System.out.println();
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person a, Person b) {
                return b.height - a.height;
            }
        });
        printByHeight();
    }

    private static void printByName() {
        System.out.println("name");
        for (int i = 0; i < 5; i++) {
            System.out.println(people[i].name + " "
                    + people[i].height + " "
                    + people[i].weight);
        }
    }

    private static void printByHeight() {
        System.out.println("height");
        for (int i = 0; i < 5; i++) {
            System.out.println(people[i].name + " "
                    + people[i].height + " "
                    + people[i].weight);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            String name = input.next();
            int height = input.nextInt();
            float weight = input.nextFloat();

            people[i] = new Person(name, height, weight);
        }
    }
}
