/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 짝수와 홀수(https://programmers.co.kr/learn/courses/30/lessons/12937)
 * 레벌 : 없음
 * 시작 날짜 : 2021-01-17
 * 종료 날짜 : 2021-01-17
 * 
 * 기획
 * Step 1. 총 합을 배열 길이로 나누어서 평균값 도출
 * 
 * 후기
 *  - 수학적으로 평균값을 도출했기 때문에 큰 어려움 없이 문제 해결
 */

package basic;

public class Average {

	public static double solution(int[] arr) {
        // int 사용시 나중에 나누었을 때 int 값으로 반환될 수 있기 때문에 double 사용함.
        double sum = 0; 
        
        // for each문을 활용해 각 배열을 하나씩 꺼내서 sum으로 합한다.
        for (int i:arr) {
            sum += i;
        } 
        
        // 추가로 변수선언 없이 결과값을 리턴함.
        return sum/arr.length;
    }
	
	// 실행 메소드
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		System.out.println(solution(arr));
	}

}
