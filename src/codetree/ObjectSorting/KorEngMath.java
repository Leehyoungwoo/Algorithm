package codetree.ObjectSorting;

import java.util.*;

public class KorEngMath {

    private static int n;
    private static Student[] students;

    static class Student {

        String name;
        int kor;
        int eng;
        int math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                if(a.kor == b.kor) {
                    if(a.eng == b.eng){
                        return b.math - a.math;
                    }
                    return b.eng - a.eng;
                }
                return b.kor - a.kor;
            }
        });
        printAll();
    }

    private static void printAll() {
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].name + " "
                    + students[i].kor + " "
                    + students[i].eng + " "
                    + students[i].math);
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        students = new Student[n];

        for (int i = 0; i < n; i++) {
            String name = input.next();
            int kor = input.nextInt();
            int eng = input.nextInt();
            int math = input.nextInt();

            students[i] = new Student(name, kor, eng, math);
        }
    }
}
