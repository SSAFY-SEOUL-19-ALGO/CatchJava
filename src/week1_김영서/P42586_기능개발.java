package week1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class P42586_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		int[] answer = {};
		Queue<Integer> p = new LinkedList<Integer>();
		int cnt = 1;

		for (int i = 0; i < progresses.length; i++) {
			int todo = 100 - progresses[i];
			int tmp = 0;
			if (todo % speeds[i] != 0) {
				tmp = todo / speeds[i] + 1;
			} else {
				tmp = todo / speeds[i];
			}
			p.offer(tmp);
		}

		System.out.println(p);
		int pCheck = p.poll();

		ArrayList<Integer> arr = new ArrayList<>();
		
		while (!p.isEmpty()) {
			int now = p.poll();
			if (now <= pCheck) {
				
				cnt++;
			} else {
				arr.add(cnt);
				pCheck = now;
				cnt = 1;
			}
		}

		arr.add(cnt);
		
		answer=new int[arr.size()];
		for(int i=0;i<arr.size();i++) {
			answer[i] = arr.get(i);
		}
		return answer;
	}
}