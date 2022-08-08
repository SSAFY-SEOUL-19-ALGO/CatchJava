package week1_김보라;
 
import java.util.Stack;

public class P12909_올바른괄호 {
	static String s = ")()()";
	public static void main(String[] args) {
		Stack<Boolean> st = new Stack<>();
		st.push(true);	//ó����
		//�˻���
		for(int i = 0; i<s.length(); i++) {
			switch(s.charAt(i)) {
			case '(':
				st.push(false);
				break;
			case ')':
				if(true==st.pop()) {	//ó������ ������->)�� �� ���Ҵ���->�ȸ´°�ȣ
					System.out.println("false");
					return;
				}
				
			}
		}//�˻� for ��
		
		//�ڵ� �ۼ��� ���� ���ο��� �� �ۼ��غ����� �̷��� ������ ���α׷��ӽ������� ���Ϲ�� -> return st.pop;
		if(st.pop()==true)
			System.out.println("true");
		else
			System.out.println("false");
		
	}
}
