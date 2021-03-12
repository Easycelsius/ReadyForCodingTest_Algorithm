/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 위장(https://programmers.co.kr/learn/courses/30/lessons/42578)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-03-07
 * 종료 날짜 : 2021-03-07
 * 
 * 기획
 * Step 1. 옷을 분류하여 단순하게 숫자 증가로 반영
 * Step 2. 모든 경우의 수에서 아무것도 입지 않은 경우를 제외
 * 
 * 후기
 *  - 수학적으로 모든 경우의 수를 구한 후 제외하는 방법을 접근했기에 빠르게 문제를 해결할 수 있었음
 */

package hash;

import java.util.HashMap;

public class Camouflage {

	public static int solution(String[][] clothes) {
		HashMap<String, Integer> map = new HashMap<>();

		// 옷 갯수 추가하기
		for (String[] clothe : clothes) {
			if (map.containsKey(clothe[1])) {
				map.put(clothe[1], map.get(clothe[1]) + 1);
			} else {
				// 없는 경우도 추가
				map.put(clothe[1], 1);
			}
		}

		// 밸류 값으로 경우의 수 계산 - 아무것도 없는 경우
		long cases = 0;

		cases = 1;
		for (long i : map.values()) {
			cases *= (i + 1);
		}
		cases = cases - 1;

		return (int) cases;
	}

	public static void main(String[] args) {
		// 자체 테스트 케이스 : [4,1,5,3,0]
		String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

		System.out.println(solution(clothes));
	}

}
