package week11.week11_김보라;
/*
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ1062_가르침 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s[] = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int K = Integer.parseInt(s[1]);
		
		int[] word = new int[N];
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.parseInt("1111111111111111111111111", 2));
		
		System.out.println(Integer.toBinaryString(Integer.parseInt("1111",2)&Integer.parseInt("1100",2)));
		System.out.println(Integer.toBinaryString(Integer.parseInt("1101",2)&(1<<'b'-'a')));
		
		
		for(int n = 0; n<N; n++) {
			String tmp = br.readLine();
			for(int t = 4; t<tmp.length()-4; t++) {
				if((word[n]&(1<<tmp.charAt(t)-'a'))==0) {
					word[n]+=(1<<tmp.charAt(t)-'a');
				}
			}
		}
		
		
//		int answer = 0;
//		for(int n = 0; n<N; n++) {
//			String tmp = br.readLine();
//			for(int t = 4; t<tmp.length()-4; t++) {
//				word[tmp.charAt(t)-'a'][n]++;
//			}
//			word['a'-'a'][n]=0;
//			word['n'-'a'][n]=0;
//			word['t'-'a'][n]=0;
//			word['i'-'a'][n]=0;
//			word['c'-'a'][n]=0; 
//		}
//		for(int n = 0; n<N; n++) {
//			System.out.println(word[n]);
//		}
		
		
	}

}
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ1062_가르침 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[];
        
        input = br.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        if(K<5) { // 무조건 5문자 이상 배울 수 있어야 문자를 읽을 수 있음
            System.out.println(0);
            System.exit(0);
        }
        
        int sum[] = new int[26]; // a~z 문자가 나온 횟수를 저장하기 위한 배열
        int alpaNum[] = new int[N]; // 각 문장마다 나오는 알파벳의 갯수를 저장하기 위한 배열
        boolean eng[][] = new boolean[N][26]; // 각문장마다 a~z의 문자가 나왔는지 안나왔는지 판단하기 위한 배열
        
        for(int i=0; i<N; i++) {
            String str = br.readLine();            
            for(int j=0; j<str.length(); j++) {
                if(!eng[i][str.charAt(j)-97]) { // 아직 안나온 문자면
                    eng[i][str.charAt(j)-97]=true; // 나왔다고해주고
                    sum[str.charAt(j)-97]++;  // 알파벳 나온 횟수 ++
                    alpaNum[i]++;  // 이 문장에 나온 알파벳 갯수 ++
                }                
            }                
        }
        
        int max=0; // 우선순위가 가장 높은 것을 가려내기 위한 변수
        int maxIdx=0; // 그 문장이 들어있는 위치를 알아내기위한 변수
        
        for(int i=0; i<N; i++) {
            int sumN=0; // 우선순위 정하기위한 변수
            if(alpaNum[i]>K) // 문장을 구성하는 문자의 갯수가 배울 수 있는 갯수보다 많으면 패스
                continue;
            
            for(int j=0; j<26; j++) {  // 내가 배운 문자가 나온 횟수를 더해줌
                if(eng[i][j])
                    sumN+=sum[j];
            }
            
            if(sumN>max) { // 최대값 저장
                max=sumN;
                maxIdx=i;
            }            
            
        }
        int ans=0; // 정답
        
        for(int i=0; i<N; i++) { // 모든 문장을 들여다 보기 위한 반복문
            boolean tg=true; // 답이 되는 문자인지 판단하기 위한 변수
            if(alpaNum[i]>K) //  문장을 구성하는 문자의 갯수가 배울 수 있는 갯수보다 많으면 패스
                continue;
            
            for(int j=0; j<26; j++) {
                if(eng[i][j]) { // 문장을 이루는 문자가 내가 배운 문자인지 판단
                    if(!(eng[i][j]&eng[maxIdx][j])) { // 안배운 문자면 패스
                        tg=false; 
                        break;
                    }
                }            
                
            }    
            if(tg)  // 모두 배운 문자면 ans++
                ans++;
        }
        
        System.out.println(ans);
        
        
        
        
        

    }

}


/*

저대로라면 앞이랑 뒤에 꼭 들어가야되는 문자는 제외하고

만약 내가 가르칠 수 있는 문자가 5개 이하라면 그냥 0을 출력하고 끝내면 되잖아요

그 경우를 제외하고 진행할때

ababab
abcabc
abbabb
abce
abcd
abee

이런식으로 주어졌다고 하면

중복을 제외하고 알파벳을 계산하면
ab
abc
ab
abce
abcd
abe

이렇게 되잖아여

알파벳이 들어갔는지 아닌지 체크하는 값들
그거 N개 값을 다 더하기

그러면
1 1                 12
1 1 1              15
1 1                 12
1 1 1 0 1        17
1 1 1 1            16
1 1 0 0 1         14

6 6 3 1 2

이렇게 되니까 우선순위가 가장 높은 abce를 배우게 됨!

아 이 예시에서는 배울 수 있는 글자가 4개일 경우!




*/