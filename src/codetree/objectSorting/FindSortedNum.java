package codetree.objectSorting;

import java.util.*;

public class FindSortedNum {

    private static int n;
    private static Number[] numbers;

    private static Number[] newNumber;

    static class Number {
        int value;
        int index;
        int changedIdx;

        public Number(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        init();
        Arrays.sort(numbers, new Comparator<Number>() {
            @Override
            public int compare(Number a, Number b) {
                if (a.value == b.value) {
                    return a.index - b.index;
                }
                return a.value - b.value;
            }
        });
        addChangedIdx();
        newNumber = new Number[n];
        changedIdx();
        printChangedIndex();
    }

    private static void addChangedIdx() {
        for (int i = 0; i < n; i++) {
            numbers[i].changedIdx = i + 1;
        }
    }

    private static void printChangedIndex() {
        for (int i = 0; i < n; i++) {
            System.out.print(newNumber[i].changedIdx + " ");
        }
    }

    private static void changedIdx() {
        for (int i = 0; i < n; i++) {
            newNumber[numbers[i].index-1] = numbers[i];
        }
    }

    private static void init() {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        numbers = new Number[n];

        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            numbers[i] = new Number(value, i + 1);
        }
    }
}
