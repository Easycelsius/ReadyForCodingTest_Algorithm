/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : JadenCase 문자열 만들기(https://programmers.co.kr/learn/courses/30/lessons/12951#)
 * 레벌 : 레벨2
 * 시작 날짜 : 2021-03-12
 * 종료 날짜 : 2021-03-12
 * 
 * 기획
 * Step 1. 문자 전처리
 * Step 2. 논리에 따라 진행
 * 
 * 후기
 *  - 케이스가 적어서 예외처리를 해결하는 데 어려움을 겪음
 *  - 코드 최적화의 필요성을 느껴서 삼중연산자와 스트림을 사용
 */

package basic;

import java.util.Arrays;

public class JadenCase {
	static String answer = "";
	public static String solution(String s) {
        s = s.toLowerCase();
        s = s + "i";
        Arrays.stream(s.split(" ")).forEach(b -> answer += (b.equals(""))? " " : b.substring(0,1).toUpperCase() + b.substring(1) + " ");
        return answer.substring(0,answer.length()-2);
    }
	
//  Arrays.stream(s.split(" ")).forEach(a -> System.out.print(a));
//  Arrays.stream(s.split(" ")).forEach(System.out::print);
	
	// 실행메소드
	public static void main(String[] args) {
		String s = "apple   banana";
//		String s = " 3people      unFollowed            me"; //  3people      UnFollowed            Me
//		String s = "r    "; // "R    "
		System.out.println(solution(s));

	}

}
