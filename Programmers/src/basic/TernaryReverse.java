/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 3진법 뒤집기(https://programmers.co.kr/learn/courses/30/lessons/68935?language=java)
 * 레벌 : 1
 * 시작 날짜 : 2021-02-21
 * 종료 날짜 : 2021-02-21
 * 
 * 기획
 * Step 1. 삼진법을 스트링으로 표현하기 / 동시에 순서를 역으로 넣기
 * Step 2. 삼진법을 십진법으로 바꾸기
 * 
 * 후기
 *  - 나머지를 이용했기 때문에 큰 어려움 없이 문제 해결
 */

package basic;

public class TernaryReverse {

	public static int solution(int n) {
		String ternaryReverse = "";
		int answer;

		while (n > 0) {
			ternaryReverse = ternaryReverse + n % 3;
			n = n / 3;
		}
		
		answer = Integer.parseInt(ternaryReverse, 3);
		
		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int num = 45; // 7
		System.out.println(solution(num));
	}

}
