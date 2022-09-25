package week7.week7_정원철;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class BOJ_빙고 {
    static int sero=0;
    static int garo=0;
    static int RtoLDK=0;
    static int LtoRDK=0;
    static int bingoChk=0;

    static boolean DKchk1=true;
    static boolean DKchk2=true;


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        ArrayList<List<String>> board= new ArrayList<>();

        Queue<String> choice=new ArrayDeque<>();
        for(int i=0; i<5; i++) {
            String st[]=br.readLine().split(" ");
            board.add(Arrays.asList(st));
        }

        for (int i=0; i< 5; i++) {
            String st[]=br.readLine().split(" ");
            for (int j=0; j<5; j++) choice.add(st[j]);
        }

        int cnt=0;
        while(true) {

            String chosen=choice.poll();
            cnt++;

            for (int i=0; i< 5; i++) {
                for (int j=0; j<5; j++) {
                    if (board.get(i).get(j).equals(chosen)) {
                        board.get(i).set(j, "-1");
                        break;
                    }
                }
            }

            for (int i=0; i< 5; i++) {
                for (int j=0; j<5; j++) {
                    //가로줄
                    if(board.get(i).get(j).equals("-1")) {
                        garo++;
                        if(garo==5) {
                            bingoChk++;
                            //System.out.println("가로 ok 현재 빙고수"+bingoChk);
                            if(bingoChk>=3) {
                                System.out.println(cnt);
                                return;
                            }
                        }


                    }

                //세로
                if(board.get(j).get(i).equals("-1")) {
                    sero++;
                    if(sero==5) {
                        bingoChk++;
                        //System.out.println("세로 ok 현재 빙고수"+bingoChk);
                        if(bingoChk>=3) {
                            //System.out.println("막타"+i+" : "+j);
                            System.out.println(cnt);
                            return;
                        }
                    }
                }

                //오왼 대각
                if(board.get(j).get(5-1-j).equals("-1")&&DKchk1) {
                    RtoLDK++;
                    if(RtoLDK==5) {
                        DKchk1=false;
                        bingoChk++;
                        //System.out.println("오왼 ok 현재 빙고수"+bingoChk);
                        //System.out.println("막타오왼"+i+" : "+j);
                        if(bingoChk>=3) {
                            System.out.println(cnt);
                            return;
                        }
                    }

                }
                
                //왼오대각
                if(board.get(j).get(j).equals("-1") && DKchk2) {
                    LtoRDK++;
                    if(LtoRDK==5) {

                        DKchk2=false;
                        bingoChk++;
                        //System.out.println("왼오 ok 현재 빙고수" +bingoChk );
                        if(bingoChk>=3) {
                            System.out.println(cnt);
                            return;
                        }
                    }
                }
            }
            
            sero=0;
            garo=0;
            RtoLDK=0;
            LtoRDK=0;
        }
        DKchk1=true;
        DKchk2=true;
        bingoChk=0;
    }
}
}
