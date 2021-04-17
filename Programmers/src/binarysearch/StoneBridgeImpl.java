package binarysearch;

import java.util.Arrays;

public class StoneBridgeImpl {

	public static int solution(long distance, int[] rocks, long n) {
		// 바위 정렬
		Arrays.sort(rocks);
		
		// 이분탐색을 위한 설정
		long left = 0; // 시작점
		long right = distance; // 끝점
		

		while(left<=right) { // 좌우 간격이 없어질 때까지 진행
			
			long mid = (left+right)/2; // 중간지점 : 12.5 => 12
			
//			System.out.println(left + " / " + right);
			
			int removeCount = 0; // 제거한 바위 갯수
			long _memory = 0; // 바위의 이전 값
			
			for(int i = 0; i<rocks.length; i++) {
				
				if(rocks[i]-_memory < mid) { // 돌사이의 거리가 중간값 보다 작다 = 해당 바위 제거
					removeCount++;
				} else { // 중간값보다 커서 제거하지 못한다면 다음 바위를 진행
					_memory = rocks[i];
				}
				
				if(removeCount > n) { // 제거한 바위의 갯수가 너무 많으면 중간값이 너무 큰 상황임으로 멈춤
					break;
				}
				
			}
			
			// 제거한 바위의 갯수가 n보다 작아서 잘 마무리 된 경우 왼쪽을 늘려서 중간값을 높이기
			if(removeCount<=n) {
				left = mid+1;
			} else {
				// 제거한 바위의 갯수가 n보다 많아서 도중에 끝났다면 오른쪽을 줄여서 중간값을 줄이기
				right = mid-1;
			}
			
		}
		
		// 좌우가 동일한 상태로 끝났으면 그 값이 최적이라는 의미임으로 그대로 리턴
		// 좌우가 틀린 상태로 끝났다는 건 그 값이 최적이 아니고 그 전의 값이 최적이라는 의미임으로 하나 빼서 리턴
		return (int) ((left==right)? left: left-1);
	}

	// 실행 메소드
	public static void main(String[] args) {
		int[] rocks = { 2, 14, 11, 21, 17 };
		System.out.println(solution(25, rocks, 2)); // 4
	}

}
