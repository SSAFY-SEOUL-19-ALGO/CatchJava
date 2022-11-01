package week12.week12_조민수;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 카드섞기 {
	static int S[], P[], card[];
 
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		S = new int[N];
		P = new int[N];
		card = new int[N];

		String[] list = br.readLine().split(" ");

		for(int i = 0;i < N;i++)
		{
			P[i] = Integer.parseInt(list[i]);
			card[i] = i % 3;
		}


		list = br.readLine().split(" ");

		for(int i = 0;i < N;i++)
			S[i] = Integer.parseInt(list[i]);

		int count = 0;

		while(!Arrays.equals(card, P))
		{
			int temp[] = card.clone();


			for(int i = 0;i < N;i++)
				card[i] = temp[S[i]];

			if(count >99999)
			{
				System.out.println(-1);
				return;
			}

			count++;
		}

		System.out.println(count);
	}



}

