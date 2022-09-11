package array;
import java.util.Scanner;

 

public class Average {

 

	public static void main(String[] args) {

 

		System.out.println(rate());

	}

 

	public static int[][] StudentScore() {

 

		Scanner input = new Scanner(System.in);

		int C = input.nextInt();

		int N = input.nextInt();

		int data[][] = new int[C][N];

 

		for (int i = 0; i < C; i++) {

			for (int j = 0; j < N; j++) {

				data[i][j] = input.nextInt();

			}

		}

		return data;

	}

 

	public static float StudentAverage() {

 

		int Score[][] = StudentScore();

		int sum = 0, count = 0;

		float avg = 0;

		for (int i = 0; i < Score.length; i++) {

			for (int j = 0; j < Score[i].length; j++) {

				sum += Score[i][j];

				count++;

			}

			avg = sum / (float) count;

		}

		return avg;

 

	}

 

	public static float rate() {

		

		float ratio = 0;

		int HighScored = 0;

		float average = StudentAverage();

		int score[][] = StudentScore();

		for (int i = 0; i < score.length; i++) {

			for (int j = 0; j < score[i].length; j++) {

				if (score[i][j] > average) {

					HighScored ++;

				}

				ratio = (HighScored / score[i].length)*100;

			}

		}

		return ratio;

 

	}

}