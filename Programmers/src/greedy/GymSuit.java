/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 체육복(https://programmers.co.kr/learn/courses/30/lessons/42862)
 * 레벌 : 레벨 1
 * 시작 날짜 : 2021-01-25
 * 종료 날짜 : 2021-01-25
 * 
 * 기획
 * Step 1. 아스키 코드 정렬
 * Step 2. 문자열을 반복해서 늘린 후 정렬
 * Step 3. [0,0,0,0] 인 경우 0에 대한 예외 처리
 * 
 * 후기
 *  - 정수가 아닌 아스키 코드를 통해 정렬을 진행하면 해당 문제에 맞게 적절한 정렬이 가능함
 *  - 하지만 3, 30을 정렬하면 30, 3이 되므로 가장 큰 수 정렬을 위해 문자열을 반복해서 늘린 다음, 정렬하는 방향을 선택하여 진행함
 */

package greedy;

public class GymSuit {
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] stArr = new int[n];

		// 기본 배열
		for (int i = 0; i < stArr.length; i++) {
			stArr[i] = 1;
		}

		// 잃어버린 사람 반영
		for (int i : lost) {
			stArr[i - 1] = stArr[i - 1] - 1;
		}

		// 여분 있는 사람 반영
		for (int i : reserve) {
			stArr[i - 1] = stArr[i - 1] + 1;
		}

		// 가지고 있으면 앞으로 먼저 빌려주고, 그 다음에 뒤로 빌려주기
		for (int i = 0; i < stArr.length; i++) {
			if (stArr[i] == 2) {
				try {
					if (stArr[i - 1] == 0) {
						stArr[i - 1] = 1;
						stArr[i] = 1;
					} else if (stArr[i + 1] == 0) {
						stArr[i + 1] = 1;
						stArr[i] = 1;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}

		int count = 0;
		for (int i : stArr) {
			if (i >= 1) {
				System.out.println(i);
				count++;
			}
		}
		return count;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 4 };
		int[] reserve = { 1, 3, 5 };

		System.out.println(solution(n, lost, reserve));
	}

}
