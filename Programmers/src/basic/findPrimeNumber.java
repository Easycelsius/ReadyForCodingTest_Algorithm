package basic;

import java.util.Arrays;
import java.util.stream.IntStream;

public class findPrimeNumber {

	public static long solution(int n) {

		int[] primeArr = IntStream.range(0, n + 1).map(i -> i).toArray();

		for (int i = 2; i <= n; i++) {
			int count = 2;
			while (primeArr[i] != 0 && i * count <= n) {
				primeArr[i * count] = 0;
				count++;
			}
		}
		
		// Arrays.stream(primeArr).filter(i -> i != 0).forEach(System.out::println);

		return Arrays.stream(primeArr).filter(i -> i != 0).count()-1;
	}

	public static void main(String[] args) {
		System.out.println(solution(10));

	}

}
