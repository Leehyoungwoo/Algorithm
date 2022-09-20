package BOJ;

import java.util.Scanner;

public class BOJ_1009 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int testCase = input.nextInt(); //// testcase 입력
		int data = 1; //////// 데이터의 개수
		int com[] = new int[testCase]; //////// 몇번째 컴퓨터가 처리하는지 저장할 배열 선언, 필요한 개수는 testCase랑 같음

		for (int i = 0; i < testCase; i++) {
			int a = input.nextInt() % 10; /// 끝자리만 알면 되니까 10으로나눈 나머지만 있으면 댐
			int b = input.nextInt() % 4;///////// 1~9까지는 끝자리 최대 4번을 루틴으로 반복
			if (b == 0) { /////////// b를 4로 나눈 나머지값이 0이되면 data의 개수를 구하는 for문이 이상해지니까
				b = 4; ///// 나머지가 0이면 b를 4로 간주해야댐
			}
			for (int j = 0; j < b; j++) {
				data = data * a;
			}

			if (data % 10 != 0) {
				com[i] = (data % 10);

			}
			if (data % 10 == 0) {
				com[i] = 10;
			}
			data = 1;//// 초기화
		}
		for (int k = 0; k < testCase; k++) {
			System.out.println(com[k]);
		}
	}
}