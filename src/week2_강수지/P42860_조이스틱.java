package week2_강수지;

public class P42860_조이스틱 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len-1; // 그냥 끝까지 가는 경우

        // 상하로 알파벳을 고른다
        for(int i=0;i<len;i++){
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);

        int next = i+1; // 다음 위치
        while(next<len && name.charAt(next)=='A'){
            next++; // 다음 위치도 A 라면 A 를 세어준다
        }
        // 좌우의 경우 순서대로 가는 거랑 뒤로 돌아가는 경우 중 더 적은 경우를 택
        move = Math.min(move, i * 2 + len - next);
        move = Math.min(move, (len - next) * 2 + i); //처음부터 뒷부분을 먼저 입력하는 것이 더 빠른 경우
            
        }
        answer+= move;
        return answer;
    }
}
