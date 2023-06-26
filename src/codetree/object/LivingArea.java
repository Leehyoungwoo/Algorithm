package codetree.object;

import java.util.Arrays;
import java.util.Scanner;

class People {
    String name;
    String houseNumber;
    String city;

    public People(String name, String houseNumber, String city) {
        this.name = name;
        this.houseNumber = houseNumber;
        this.city = city;
    }
}

public class LivingArea {

    private static People[] peopleArr;
    private static String[] arr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        peopleArr = new People[n];
        arr = new String[n];

        for (int i = 0; i < peopleArr.length; i++) {
            String name = input.next();
            String houseNumber = input.next();
            String city = input.next();
            peopleArr[i] = new People(name, houseNumber, city);
        }
        printFirstPeople();
    }

    private static void printFirstPeople() {
        People firstPeople = findFirstPeople();
        System.out.println("name " + firstPeople.name);
        System.out.println("addr " + firstPeople.houseNumber);
        System.out.println("city " + firstPeople.city);
    }

    private static People findFirstPeople() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = peopleArr[i].name;
        }
        Arrays.sort(arr);

        for (int i = 0; i < peopleArr.length; i++) {
            if(peopleArr[i].name.equals(arr[arr.length-1])) {
                return peopleArr[i];
            }
        }
        return null;
    }
}
