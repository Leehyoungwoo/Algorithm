package codetree.objectSorting;

import java.util.*;

public class LineUp {

    private static int n;
    private static Student[] students;

    static class Student {
        int height;
        int weight;
        int num;

        public Student(int height, int weight, int num) {
            this.height = height;
            this.weight = weight;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if (a.height == b.height) {
                    if (a.weight == b.weight) {
                        return a.num - b.num;
                    }
                    return b.weight - a.weight;
                }
                return b.height - a.height;
            }
        });
        printAll();
    }

    private static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].height + " "
                    + students[i].weight + " "
                    + students[i].num);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        students = new Student[n];

        for (int i = 0; i < n; i++) {
            int height = input.nextInt();
            int weight = input.nextInt();
            students[i] = new Student(height, weight, i + 1);
        }
    }

}
