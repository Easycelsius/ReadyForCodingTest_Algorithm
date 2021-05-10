package codingTest;

import java.util.ArrayList;
import java.util.Arrays;

public class TravelRoute {
	
	// 답 기록 부분
	static ArrayList<String> ans = new ArrayList<>();

	public static String[] solution(String[][] tickets) {
	    
        boolean[] visited = new boolean[tickets.length];
        ArrayList<String> answer = new ArrayList<>();
        
        // 스트링 정렬
        Arrays.sort(tickets, (a, b)->a[1].compareTo(b[1]));
        
        // dfs 시작
        dfs(tickets, visited, "ICN", 0, answer);
        
        return ans.stream().toArray(String[]::new);
    }
    
    public static void dfs(String[][] tickets, boolean[] visited, String startPoint, int count, ArrayList<String> answer){
        answer.add(startPoint);
        System.out.println(answer);
        System.out.println(count);
        
        // 답과 카운트가 동일하다는 의미는 마지막 경로까지 도착했음을 의미
        if(count == tickets.length-1){
            ans = answer;
        }
        
        for(int x = 0; x<tickets.length; x++){ // 공항 순회
            if(tickets[x][0].equals(startPoint) && !visited[x]){ // 공항을 찾음
                visited[x] = true;
                dfs(tickets, visited, tickets[x][1], count+1, answer);
                System.out.println("dfs 종료");
                if(answer.size() < tickets.length) { // dfs가 끝까지 가지 않았다면 그거 빼고 다시 돌기
                	System.out.println("반복");
                	answer.remove(answer.size()-1);
                	visited[x] = false;
                }
            }
        }
        
        
    }

	// 실행 메소드
	public static void main(String[] args) {
		
//		String[][] tickets = {{"ICN", "A"}, {"A", "C"}, {"A", "D"}, {"D", "B"}, {"B", "A"}};
		
		
		String[][] tickets = {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}};
		
		System.out.println(solution(tickets));
	}
}
