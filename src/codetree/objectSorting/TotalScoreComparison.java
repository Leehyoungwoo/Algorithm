package codetree.objectSorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class TotalScoreComparison {

    private static int n;
    private static Student[] students;

    static class Student {

        String name;
        int g1;
        int g2;
        int g3;

        public Student(String name, int g1, int g2, int g3) {
            this.name = name;
            this.g1 = g1;
            this.g2 = g2;
            this.g3 = g3;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return (a.g1 + a.g2 + a.g3) - (b.g1 + b.g2 + b.g3);
            }
        });
        printAll();
    }

    private static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + " "
                    + students[i].g1 + " "
                    + students[i].g2 + " "
                    + students[i].g3);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = input.next();
            int g1 = input.nextInt();
            int g2 = input.nextInt();
            int g3 = input.nextInt();

            students[i] = new Student(name, g1, g2, g3);
        }
    }
}
