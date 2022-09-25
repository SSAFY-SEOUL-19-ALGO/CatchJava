import java.lang.reflect.Array;
import java.util.*;

public class kko1 {
	public static void main(String[] args) {
		String today = "2022.05.19";
		String[] terms = { "A 6", "B 12", "C 3" };
		String[] privacies = { "2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C" };
		int[] answer = Solution.solution(today, terms, privacies);
		System.out.println(answer);
		
		
		String[][] check=new String[][] {};
		HashMap<String,ArrayList<int[]>>m = new HashMap<>();
		ArrayList<int[]>li = new ArrayList<>();
		li.add(new int[]{1,2});
		m.put("a", li);
        ArrayList<int[]>remain= m.get("a"); //{2,2},{3,5},{4,6}+새값
        System.out.println(remain);
	}

	static class Solution {
		public static int[] solution(String today, String[] terms, String[] privacies) {
			int[] answer = {};
			int idx = 0;
			ArrayList<Integer> ans = new ArrayList<>();
			HashMap<String, String> map = new HashMap();
			for (int i = 0; i < terms.length; i++) {
				String[] a = terms[i].split(" ");
				map.put(a[0], a[1]);
			}

			for (int i = 0; i < privacies.length; i++) {
				String[] a = privacies[i].split(" ");
				String[] expDate = cal(a[0], map.get(a[1])).split("\\.");
				// 값비교
				boolean check = expCal(today, expDate);
				if (check == false) {
					ans.add(i + 1);
				}
			}
			System.out.println(ans);
			Collections.sort(ans);
			answer = new int[ans.size()];
			for (int k : ans) {
				answer[idx] = k;
				idx++;
			}
			return answer;
		}

		static String cal(String date, String expire) {
			String[] dateSplit = date.split("\\.");
			int year = Integer.parseInt(dateSplit[0]);
			int month = Integer.parseInt(dateSplit[1]);
			int day = Integer.parseInt(dateSplit[2]);
			day--;
			if (day == 0) {
				month--;
				day = 28;
			}
			month += Integer.parseInt(expire);
			if (month > 12) {
				year++;
				month -= 12;
			}
			return year + "." + month + "." + day;
		}

		static boolean expCal(String todayparam, String[] expDate) {
			String[] today = todayparam.split("\\.");
			int y = Integer.parseInt(today[0]);
			int m = Integer.parseInt(today[1]);
			int d = Integer.parseInt(today[2]);

			if (y > Integer.parseInt(expDate[0])) {
				return false;
			} else if (y == Integer.parseInt(expDate[0])) {
				if (m > Integer.parseInt(expDate[1])) {
					return false;
				} else if (m == Integer.parseInt(expDate[1])) {
					if (d > Integer.parseInt(expDate[2])) {
						return false;
					}
				}
			}
			return true;
		}
	}
}
