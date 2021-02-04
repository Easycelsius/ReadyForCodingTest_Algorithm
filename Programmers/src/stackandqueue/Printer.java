/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 프린터(https://programmers.co.kr/learn/courses/30/lessons/42587)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-01-31
 * 종료 날짜 : 2021-01-31
 * 
 * 기획
 * Step 1. 출력이 된 횟수를 구하는 카운트, 원하는 문서의 위치를 나타내는 로케이션 변수를 생성
 * Step 2. 우선순위를 먼저 출력하는 로직을 만들고 각 케이스에 맞게 카운트와 로케이션을 조절하여 리턴 값을 반환
 * 
 * 후기
 *  - 큐의 대표적인 예를 학습하는 좋은 기회였으며, 카운트와 로케이션 변수를 통해 큐의 자료구조를 효율적으로 처리할 수 있었음
 */

package stackandqueue;

import java.util.ArrayList;

public class Printer {

	public static int solution(int[] priorities, int location) {
		int count = 0;
		int loca = location;

		ArrayList<Integer> prioritiesList = new ArrayList<Integer>();

		// 어레이리스트로 만들기
		for (int i : priorities) {
			prioritiesList.add(i);
		}

		// 리턴이 발생할 때까지 반복하라
		while (true) {
			// 맨 앞자리수가 제일 큰 거면 출력하고 카운트 올려라
			// 위치는 출력하고 줄어들어라
			if (iamMax(prioritiesList)) {
				// 프린트가 출려되고 카운트를 올린다
				prioritiesList.remove(0);
				count = count + 1;

				if (loca == 0) {
					return count;
				} else {
					loca = loca - 1;
				}

				if (loca < 0) {
					loca = prioritiesList.size() - 1;
				}

			} else {
				// 만약 맨 앞자리수보다 큰 것이 있다면 앞자리에 있는 것을 지우고 뒤로 옮겨라
				// 위치는 출력하고 줄어드는데 0보다 작아지면 배열의 마지막 길이로 다시 지정해라

				prioritiesList.add(prioritiesList.remove(0));
				loca = loca - 1;
				if (loca < 0) {
					loca = prioritiesList.size() - 1;
				}
			}
		}
	}

	public static boolean iamMax(ArrayList<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			if (((int) list.get(0)) < ((int) list.get(i))) {
				return false;
			}
		}
		return true;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[] priorities = { 1, 1, 9, 1, 1, 1 };
		int location = 0;

		System.out.println(solution(priorities, location));
	}
}
