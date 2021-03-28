package lineCodingTest;

import java.util.ArrayList;
import java.util.HashMap;

public class T1 {
	public static String[] solution(String[] records) {

		String[] rec;
		ArrayList<String> answer = new ArrayList<>();
		HashMap<String, String> hm = new HashMap<>();
		
		for(String record : records) {
			rec = record.split(" ");
			if(rec[0].equals("Enter")) {
				hm.put(rec[1], rec[2]);
			}
			if(rec[0].equals("Leave")) {}
			if(rec[0].equals("Change")) {
				hm.put(rec[1], rec[2]);
			}
		}
		
		for(String record : records) {
			rec = record.split(" ");
			if(rec[0].equals("Enter")&&hm.containsKey(rec[1])) {
				answer.add(hm.get(rec[1])+"님이 들어왔습니다.");
			}
			
			if(rec[0].equals("Leave")&&hm.containsKey(rec[1])) {
				answer.add(hm.get(rec[1])+"님이 나갔습니다.");
			}
		}
		
        return answer.stream().toArray(String[]::new);
    }
	
	// 실행 메소드
		public static void main(String[] args) {
			String[] v = {
					"Enter uid1234 Muzi", 
					"Enter uid4567 Prodo",
					"Leave uid1234",
					"Enter uid1234 Prodo",
					"Change uid4567 Ryan"
					};
			
			System.out.println(solution(v));
		}

}
