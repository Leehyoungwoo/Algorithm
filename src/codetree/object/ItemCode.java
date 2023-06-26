package codetree.object;

import java.util.Scanner;

class Item {
    String itemName;
    int itemCode;

    public Item(String itemName, int itemCode) {
        this.itemName = itemName;
        this.itemCode = itemCode;
    }
}

public class ItemCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Item itemA = new Item("codetree", 50);
        Item itemB = new Item(input.next(), input.nextInt());

        System.out.println("product " + itemA.itemCode + " is " + itemA.itemName);
        System.out.println("product " + itemB.itemCode + " is " + itemB.itemName);
    }
}
