/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 가장 큰 수(https://programmers.co.kr/learn/courses/30/lessons/42746)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-01-24
 * 종료 날짜 : 2021-01-24
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

package sorting;

import java.util.Arrays;

public class LargestNumber {
	public static String solution(int[] numbers) {

		String answer = "";
		String strNum = Arrays.toString(numbers);

		// 인트 배열을 스트링 배열화
		strNum = strNum.replace("[", "");
		strNum = strNum.replace("]", "");
		String[] strNumArr = strNum.split(", ");

		// 정상적인 정렬을 위한 배열 내 문자열 조정
		for (int i = 0; i < strNumArr.length; i++) {
			strNumArr[i] = strNumArr[i] + strNumArr[i] + strNumArr[i];
		}

		// 정렬
		Arrays.sort(strNumArr);

		// 조정한 값을 원상태로 돌린 후 문자열로 치환
		for (int i = 1; i <= strNumArr.length; i++) {
			String v = strNumArr[strNumArr.length - i];
			answer += v.substring(0, (v.length() / 3));
		}

		// 맨 앞자리가 0인 경우 0으로 처리
		if (answer.charAt(0) == '0') {
			return "0";
		}

		return answer;
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[] number = { 3, 30, 34, 5, 9 };
		System.out.println(solution(number));
	}

}
