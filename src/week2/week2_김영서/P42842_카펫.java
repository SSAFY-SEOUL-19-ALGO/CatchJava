package week2.week2_김영서;

public class P42842_카펫 {

	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];
		// 갈색이 노랑을 덮으려면 가로세로 각각 +2여야함
		//brownX = yellowX+2, brownY = yellowY+2; 
		int yX, yY;
		//yellow = yellowX*2+yellowY*2-4;
		//-->yellowX = yellow/2+2-yellowY
		//yellow = yellowX*yellowY;
		//-->yellowX = yellow/yellowY;
		//yellow/2+2-yellowY = yellow/yellowY;
		for(int i=1;i<=yellow;i++) {
			if(yellow%i==0) {
				yY =i;
				yX = yellow/i;
                //System.out.println(yY+" "+yX);
				if((yY*2)+(yX*2)+4 ==brown) {
                    answer[0]=yY+2;
                    answer[1]=yX+2;
					System.out.println(yY+" "+yX);
				}
			}
		}
		
		return answer;
	}

}
