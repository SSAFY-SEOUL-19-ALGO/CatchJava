package week12.week12_박건우;

import java.io.*;

public class BJ1091_카드섞기 {
    static int N;
    static int[] dest, shuffle, cards;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   // br
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw
        String[] ipt;   // string array to get input
        StringBuilder sb = new StringBuilder();
        String str;

        N = Integer.parseInt(br.readLine());
        dest = new int[N];
        cards = new int[N];
        shuffle = new int[N];
        ipt = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            dest[i] = Integer.parseInt(ipt[i]);
            cards[i] = dest[i];
        }
        ipt = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            shuffle[i] = Integer.parseInt(ipt[i]);
        }

        int idx = 0;

        while(true){
            if(check(cards)){
                break;
            }

            doShuffle(cards, shuffle);
            idx++;

            if(isSame(dest, cards)){
                idx = -1;
                break;
            }
        }
        bw.write(idx+"\n");
        bw.flush();
    }

    static void doShuffle(int[] destArr, int[] shuffleArr){
        int len = destArr.length;
        int[] newDest = new int[len];

        for (int i = 0; i < len; i++) {
            newDest[shuffleArr[i]] = destArr[i];
        }

        for (int i = 0; i < len; i++) {
            destArr[i] = newDest[i];
        }
        newDest = null;
    }

    static boolean check(int[] destArr) {   // 카드에서 원하는 플레이어에게 줄 수 있나 체크
        for (int i = 0; i < destArr.length; i++) {
            if (destArr[i] != i % 3) {
                return false;
            }
        }
        return true;
    }
    
    static boolean isSame(int[] destArr, int[] cardArr){
        for (int i = 0; i < destArr.length; i++) {
            if(destArr[i] != cardArr[i]){
                return false;
            }
        }
        return true;
    }
}
