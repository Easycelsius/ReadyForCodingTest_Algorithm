/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 타겟 넘버(https://programmers.co.kr/learn/courses/30/lessons/43165?language=java)
 * 레벌 : 레벨 2
 * 시작 날짜 : 2021-02-07
 * 종료 날짜 : 2021-02-07
 * 
 * 기획
 * Step 1. 숫자의 나열을 더하거나 빼는 것에 중점을 둠
 * Step 2. 덧셈과 뺄셈이 동시에 발생한다는 점에서 완전 탐색을 이용하지 않고 재귀를 이용해 구조를 제작함
 * 
 * 후기
 *  - 전역변수의 활용과 재귀함수의 적절한 활용이 필요한 문제였던 것 같음
 *  - 완전탐색을 진행한다해도 시간 복잡도가 크게 차이 나지 않을 것으로 생각함
 */

package dfsorbfs;

public class TargetNumber {

	// 전역 변수 설정
	static int count = 0;
	static int index = 0;

	public static int solution(int[] numbers, int target) {

		operator(numbers, 0, target);

		return count;
	}

	// 계산을 위한 재귀 메소드
	public static void operator(int[] numbers, int index, int target) {
		printAll(numbers);
		if (numbers.length > index) {
			numbers[index] = numbers[index] * 1;
			operator(numbers, index + 1, target);

			numbers[index] = numbers[index] * -1;
			operator(numbers, index + 1, target);

		} else if (sumArr(numbers) == target) {
			count = count + 1;
		}
	}
	
	// 배열들의 합을 리턴으로 해주는 메소드
	public static int sumArr(int[] Array) {
		int sum = 0;
		for (int i : Array) {
			sum = sum + i;
		}
		return sum;
	}

	// 배열들을 출력해주는 함수 (출력을 통해 과정을 확인하기 위함)
	public static void printAll(int[] Array) {
		for (int i : Array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1};
		int target = 0;

		System.out.println(solution(numbers, target));
	}

}
