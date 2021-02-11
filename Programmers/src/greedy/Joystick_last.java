/* 69 97 115 121 99 101 108 115 105 117 115
 * 문제 : 조이스틱(https://programmers.co.kr/learn/courses/30/lessons/42860)
 * 레벌 : 레벨 1
 * 시작 날짜 : 2021-02-07
 * 종료 날짜 : 2021-02-11
 * 
 * (구)기획
 * Step 1. 문자의 움직임을 확인하려면 char를 활용해야할 것 같음, 특히 문자의 시작과 끝을 계산해서 최솟값을 구해야 함
 * Step 2. 좌우 중에 A가 있으면 다른 방향으로 가볼 것을 고려하되 너무 멀다면 기존 방향으로 이동(이때 카운팅은 추가)
 * 
 * (신)기획
 * Step 1. 앞아벳 위아래 이동에 관한 메소드
 * Step 2. 인덱스 기준으로 좌우에 A의 개수 파악
 * Step 3. 방향에 대한 시그널들을 2개의 변수에 담았고 한번 역방향이 되면 두번은 못가게 막음
 * Step 4. 논리에 따라 역방향을 잘 설정하였지만, 예외 테스트가 있었고 급하게 정방향으로 진행했을 때의 수를 구함
 * Step 5. 역방향과 정방향을 비교하여 최소일 때를 리턴하기로 함
 * 
 * 후기
 *  - 예외 케이스에서 문제가 있어서 다시 설정하였음
 *  - 예외는 역행하는 케이스인 것으로 파악함
 *  - 어느 한 케이스 성공시 다른 한 케이스가 실패할 정도로 다양한 테스트 케이스를 고려해야 했음
 *  - 탐욕법에 맞게 좌우 A 갯수를 비교하였으나 도중에 그대로 진행하는게 유리한 경우도 있었음
 *  - 따라서 정방향, 역방향 모두 계산을 해서 최소값으로 돌려서 진행함
 *  - 생각보다 복잡했던 문제였음
 */

package greedy;

public class Joystick_last {

	public static int solution(String name) {

		int upDownMoving = 0;

		// 알파벳 위아래 이동시 수
		for (int i = 0; i < name.length(); i++) {
			upDownMoving = upDownMoving + alphabetMinMove(name.charAt(i));
		}

		int normalMovCount = 0;
		int movingCount = 0;
		boolean direction = true;
		int directionChange = 0;

		// 좌우 이동 숫자
		for (int index = 0; index < name.length(); index++) {

			// right-side a counting
			int rightA = 0;
			int preRightIndex = index + 1;
			while (preRightIndex < name.length()) {
				if (name.charAt(preRightIndex) == 'A') {
					rightA = rightA + 1;
					preRightIndex = preRightIndex + 1;
				} else {
					break;
				}
			}

			// left-side a counting
			int leftA = 0;
			int preLeftIndex = index - 1;
			while (preLeftIndex != index) {

				if (preLeftIndex < 0) {
					preLeftIndex = (name.length() - 1);
				}

				if (name.charAt(preLeftIndex) == 'A') {
					leftA = leftA + 1;
					preLeftIndex = preLeftIndex - 1;
				} else {
					break;
				}
			}

			// 각 인덱스에서 정방향인지 아닌지 확인하기
			if (leftA >= rightA && directionChange == 0 && index < rightA) {
				direction = true;
			} else if (leftA < rightA && directionChange == 0) {
				direction = false;
				directionChange = 1;
				movingCount = movingCount + index -1 - rightA;
			}

			// 중간 A는 무시하고, 마지막 A가 나오게 되면 종료
			if (direction) {
				System.out.println(index + rightA + " " + (name.length() - 1));
				if (index + rightA == name.length() - 1) {
					System.out.println(movingCount + "/" + upDownMoving);
					return movingCount + upDownMoving;
				}
				movingCount = movingCount + 1;
				
			// 왼쪽이 더 큰 경우, 방향 바꾸고 왼쪽으로 이동, 왼쪽으로 이동시 방향을 바꿀 때의 우측 에이 갯수만큼을 더한 인덱스까지 이동 숫자세기
			} else if (!direction && directionChange == 1) {
				movingCount = movingCount + 1; 
				
			}
			
			if (!(index + rightA >= name.length() - 1)) {
				normalMovCount = normalMovCount + 1;
			}
		}
		
		System.out.println(normalMovCount + " / " + movingCount);
		return Math.min(normalMovCount+ upDownMoving, movingCount + upDownMoving);

	}

	// 알파벳 이동시 최소거리 찾는 메소드
	public static int alphabetMinMove(char ch) {
		char A = 65;
		char Z = 90;
		return Math.min(ch - A, Z + 1 - ch);
	}

	// 실행 메소드
	public static void main(String[] args) {
		String name = "ABABAAAAABA"; //11
		System.out.println(solution(name));
	}

}
