package binarysearch;

import java.util.Arrays;

public class StoneBridge {

	public static int solution(int distance, int[] rocks, long n) {
		int answer = 0;
		Arrays.sort(rocks);
		int left = 0;
		int right = distance;
		int mid = 0;
		while (left <= right) {
			System.out.println("L:" + left + " / R:" + right );
			mid = (left + right) / 2;
			int prv = 0;
			int removeCnt = 0;
			
			for (int i = 0; i < rocks.length; i++) {
				System.out.println("타겟 바위: " + rocks[i] + " / 이전 바위 값: " + prv + " / 중간값 : "+ mid);
				System.out.println("타겟바위 - 이전바위 : " + (rocks[i] - prv));
				if (rocks[i] - prv < mid) {
					removeCnt++;
					System.out.println("바위 제거");
					if (removeCnt > n) {
						System.out.println("멈춤");
						break;
					}
				} else {
					prv = rocks[i];
				}
				System.out.println("현재 제거 수: " + removeCnt);
				System.out.println("-------------------");
			}
			if (removeCnt > n) {
				right = mid - 1;
			} else if(removeCnt == n){
				return mid;
			} else {
				answer = answer > mid ? answer : mid;
				left = mid + 1;
			}
			
			System.out.println("---------회차 종료--------");
		}
		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[] rocks = { 2, 14, 11, 21, 17 };
		System.out.println(solution(25, rocks, 2)); // 4
	}

}
