package BOJ;

import java.util.Stack;
import java.util.Scanner;

public class BOJ_3986 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		int N = input.nextInt();
		int count = 0;
		input.nextLine();

		for (int i = 0; i < N; i++) {
			String str = input.nextLine();
			for (int j = 0; j < str.length(); j++) {
				if (!stack.isEmpty() && stack.peek() == str.charAt(j)) {
					stack.pop();
				} else {
					stack.push(str.charAt(j));
				}
			}
			if (stack.isEmpty()) {
				count++;
			}
			stack.clear();
		}
		System.out.println(count);
	}
}
