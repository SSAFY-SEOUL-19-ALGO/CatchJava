package week8.week8_박윤환;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1063_킹 {

    // 체스말 클래스
    static class Chessman {
        int x, y;   // 체스말의 행위치, 열위치

        public Chessman(int x, int y) { // 생성자
            this.x = x;
            this.y = y;
        }

        public String getCord() {   // int형 좌표를 원래의 문자열 좌표로 변환하는 메소드
            char[] cord = new char[2];
            cord[0] = (char) (y + 'A');
            cord[1] = (char) (x + '1');
            return String.valueOf(cord);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int x = st[0].charAt(1) - '1';  // 킹의 행위치를 숫자로 변환
        int y = st[0].charAt(0) - 'A';  // 킹의 열위치를 숫자로 변환
        Chessman king = new Chessman(x, y); // 킹 객체 생성

        x = st[1].charAt(1) - '1';  // 돌의 행위치를 숫자로 변환
        y = st[1].charAt(0) - 'A';  // 돌의 열위치를 숫자로 변환
        Chessman rock = new Chessman(x, y); // 돌 객체 생성

        int N = Integer.parseInt(st[2]);    // 움직이는 횟수

        for(int i=0; i<N; i++) {
            String move = br.readLine();    // 움직이는 방향
            int nextKX = king.x;    // 다음 킹의 행위치
            int nextKY = king.y;    // 다음 킹의 열위치
            int nextRX = rock.x;    // 다음 돌의 행위치
            int nextRY = rock.y;    // 다음 돌의 열위치
            switch (move) {
                // 방향에 따라 킹과 돌의 다음 위치 계산
                case "R":
                    nextKY++;
                    nextRY++;
                    break;
                case "L":
                    nextKY--;
                    nextRY--;
                    break;
                case "B":
                    nextKX--;
                    nextRX--;
                    break;
                case "T":
                    nextKX++;
                    nextRX++;
                    break;
                case "RT":
                    nextKX++;
                    nextKY++;
                    nextRX++;
                    nextRY++;
                    break;
                case "LT":
                    nextKX++;
                    nextKY--;
                    nextRX++;
                    nextRY--;
                    break;
                case "RB":
                    nextKX--;
                    nextKY++;
                    nextRX--;
                    nextRY++;
                    break;
                case "LB":
                    nextKX--;
                    nextKY--;
                    nextRX--;
                    nextRY--;
                    break;
            }
            if(nextKX >= 0 && nextKX < 8 && nextKY >= 0 && nextKY < 8) {    // 다음 킹의 위치가 체스판을 안벗어날경우
                if(nextKX == rock.x && nextKY == rock.y) {  // 킹의 위치와 돌의 위치가 같다면
                    if(nextRX >= 0 && nextRX < 8 && nextRY >= 0 && nextRY < 8) {    // 다음 돌의 위치도 체스판을 안벗어난다면
                        // 킹과 돌의 위치 갱신
                        king.x = nextKX;
                        king.y = nextKY;
                        rock.x = nextRX;
                        rock.y = nextRY;
                    }
                } else {    // 다음 킹의 위치가 돌의 위치와 같지 않다면
                    // 킹의 위치만 갱신
                    king.x = nextKX;
                    king.y = nextKY;
                }
            }
        }

        System.out.println(king.getCord()); // 킹의 마지막 위치
        System.out.println(rock.getCord()); // 돌의 마지막 위치
    }
}
