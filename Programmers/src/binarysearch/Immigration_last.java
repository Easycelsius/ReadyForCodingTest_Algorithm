/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 입국심사(https://programmers.co.kr/learn/courses/30/lessons/43238)
 * 레벌 : 레벨 3
 * 시작 날짜 : 2021-02-13
 * 종료 날짜 : 2021-02-13
 * 
 * 기획
 * Step 1. 분이 리턴 값이며, 이와 같은 시간은 최소와 최대 시간을 유추할 수 있다.
 * Step 2. 즉, 답의 범위가 정해져 있는 만큼 이진탐색을 실행할 수 있다.
 * 
 * 후기
 *  - 이진 탐색의 원리와 이를 실현하기 위한 방법을 min, mid, max, while문을 통해 구현하였다.
 *  - 이진 탐색 외에 중요했던 부분은 long으로 형변환을 하여 오버플로우를 방지하는 것이었다.
 */

package binarysearch;

import java.util.Arrays;

public class Immigration_last {

	public static long solution(int n, int[] times) {
		// 목표: 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return
		// n : 심사대상, times.length : 심사관 수, times_arrys : 각 심사관이 한명을 검사하는데 걸리는 수

		long count = 0;
		long minMinute = 0;

		Arrays.sort(times);

		long maxMinute = ((long)times[0]) * ((long)n);
		long midMinute;
		long answer = 0;

		while (minMinute<maxMinute) {
			
			System.out.println((maxMinute + minMinute) / 2);
			
			midMinute = (maxMinute + minMinute) / 2;
			
			count = 0;
			for (int time : times) {
				count = count + (midMinute / time);
			}

			if (count >= n) { // 카운트가 크다는 것은 미드넘버가 큰 경우 임으로, maxMinute을 줄여라
				maxMinute = midMinute;
				answer = (long) maxMinute;
			} else if (count < n) {
				minMinute = midMinute+1;
				answer = (long) minMinute;
			}
		}
		
		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int n = 6; // 입국 심사를 기다리는 사람 수
		int[] times = { 7, 10 }; // 각 심사관이 한명을 심사하는데 걸리는 시간이 담긴 배열
		System.out.println(solution(n, times)); // 28
	}

}
