/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 짝수와 홀수(https://programmers.co.kr/learn/courses/30/lessons/12937)
 * 레벌 : 없음
 * 시작 날짜 : 2021-01-17
 * 종료 날짜 : 2021-01-17
 * 
 * 기획
 * Step 1. 짝수와 홀수를 구분하기 위해서 2를 나누고 나머지를 확인
 * 
 * 후기
 *  - 나머지를 이용했기 때문에 큰 어려움 없이 문제 해결
 */

package basic;

public class EvenAndOdd {
	
	public static String solution(int num) {
        if (num%2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }
	
	// 실행 메소드
	public static void main(String[] args) {
		int num = 4;
		System.out.println(solution(num));
	}

}
