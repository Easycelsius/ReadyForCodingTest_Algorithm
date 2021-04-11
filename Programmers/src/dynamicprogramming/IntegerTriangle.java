package dynamicprogramming;

import java.util.Arrays;

public class IntegerTriangle {
	
	public static int solution(int[][] triangle) {
        int answer = 0;
        
        for(int i=0; i<triangle.length-1; i++) {
        	int _memory=0;
        	for(int in = 0; in<triangle[i].length; in++) {
        		
        		// 현재값
        		int num = triangle[i][in];

        		// 같은 인덱스의 다음 값에 대한 처리
        		// 전값과 현재값 더한게 더 크면 갈아버리기
        		// 그렇지 않다면 그냥 통과
        		// 1번 인덱스는 예외로 처리
        		if(triangle[i+1][in]<num + _memory && in != 0) {
        			triangle[i+1][in] = num + _memory;
        		} else if(in == 0) {
        			triangle[i+1][in] += num;
        		}
        		
        		// 다음 값 임시 저장
        		_memory= triangle[i+1][in+1];
        		
        		// 다음 인덱스의 다음 값 처리
        		triangle[i+1][in+1] += num;
        		
        	}
        }
        
//        Arrays.stream(triangle).forEach(a -> {
//        	for(int ac : a) {
//        		System.out.print(ac + " ");        		
//        	}
//        	System.out.println();
//        });
        
        return Arrays.stream(triangle[triangle.length-1]).max().getAsInt();
    }

	public static void main(String[] args) {
		int[][] triangle = {
				{7}, 
				{3, 8}, 
				{8, 1, 0}, 
				{2, 7, 4, 4}, 
				{4, 5, 2, 6, 5}
				};
		System.out.println(solution(triangle));
	}
}
