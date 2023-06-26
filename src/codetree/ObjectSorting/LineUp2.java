package codetree.ObjectSorting;

import java.util.*;

public class LineUp2 {

    static class Student {
        int height;
        int weight;
        int idx;

        public Student(int height, int weight, int idx) {
            this.height = height;
            this.weight = weight;
            this.idx = idx;
        }
    }

    private static int n;
    private static Student[] students;

    public static void main(String[] args) {
        init();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
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
            System.out.println(students[i].height + " "
                    + students[i].weight + " "
                    + students[i].idx);

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
