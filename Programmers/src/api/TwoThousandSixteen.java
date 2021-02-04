/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 2016년(https://programmers.co.kr/learn/courses/30/lessons/12901)
 * 레벌 : 레벨 1
 * 시작 날짜 : 2021-01-24
 * 종료 날짜 : 2021-01-24
 * 
 * 기획
 * Step 1. 날짜 API를 활용한 출력
 * 
 * 후기
 *  - 날짜에 관한 JAVA API 사용법을 배울 수 있었음
 */

package api;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TwoThousandSixteen {

	public static String solution(int a, int b) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("E");

		cal.set(2016, a - 1, b); // 2016-06-24에서 달은 하나를 빼야 정상적으로 진행됨

		return (sdf.format(cal.getTime())).toUpperCase(); // Tue -> TUE
	}

	// 실행 메소드
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		System.out.println(solution(a, b));
	}

}
