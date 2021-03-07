/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 더 맵게(https://programmers.co.kr/learn/courses/30/lessons/42626?language=java)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-03-07
 * 종료 날짜 : 2021-03-07
 * 
 * 기획
 * Step 1. 체크메소드를 만들어서 리스트에 대한 점검을 우선적으로 진행
 * Step 2. 우선순위 큐를 만들고 이를 통해 알고리즘 구현
 * 
 * 후기
 *  - 힙을 다른 방식으로 구현했으나 효율성 테스트에서 실패함
 *  - 우선순위 큐를 사용하여 효율성을 높였음
 */

package heap;

import java.util.PriorityQueue;

public class MoreSpicy2 {

	public static int solution(int[] scoville, long K) {
		int count = 0;

		PriorityQueue<Long> list = new PriorityQueue<>();

		// 배열 -> 어레이리스트
		for (int i = 0; i < scoville.length; i++) {
			list.add((long) scoville[i]);
		}

		// 스코빌지수가 나타날 때까지 반복
		while (!check(list, K)) {
			System.out.println(list);

			// 사이즈가 1인 것은 더이상 할 게 없다는 의미
			if (list.size() == 1) {
				return -1;
			}

			// 맨 앞에 것을 빼고 그 다음 앞의 것을 더해서 추가하기
			list.add(list.poll() + list.poll() * 2);

			count += 1;
		}

		return count;
	}

	public static boolean check(PriorityQueue<Long> list, long K) {
		for (long num : list) {
			if (num < K) {
				return false;
			}
		}
		return true;
	}

	// 실행 메소드
	public static void main(String[] args) {

		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;

		System.out.println(solution(scoville, k));
	}

}
