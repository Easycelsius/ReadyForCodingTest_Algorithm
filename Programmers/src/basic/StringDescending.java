/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 문자열 내림차순으로 배치하기(https://programmers.co.kr/learn/courses/30/lessons/12917)
 * 레벌 : 1
 * 시작 날짜 : 2021-02-21
 * 종료 날짜 : 
 * 
 * 기획
 * Step 1. 문자열을 char 형태로 배열에 집어넣기
 * Step 2. 배열을 정렬하기
 * Step 3. String으로 만들어서 반환
 * 
 * 후기
 *  - 따로 코멘트를 안해도 되는 문제
 */

package basic;

import java.util.Arrays;

public class StringDescending {

	public static String solution(String s) {
		char[] charList = new char[s.length()];  
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
        	charList[i] = s.charAt(i);
        }
       
        Arrays.sort(charList);
        
        for (int i = s.length()-1; i >= 0; i--) {
        	answer = answer + charList[i];
        }
        
        return answer;
    }
	
	// 실행 메소드
	public static void main(String[] args) {
		String s = "Zbcdefg"; // gfedcbZ
		System.out.println(solution(s));
	}

}
