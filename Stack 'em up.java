import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount=Integer.parseInt(br.readLine());
		
		//Construct the deck.
		String [] suits=new String [] {"Clubs","Diamonds","Hearts","Spades"};
		String [] values=new String [] {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
		String [] stockDeck=new String [52];
		StringBuilder sb;
		for (int i=0;i<suits.length;i++) {
			for (int i2=0;i2<values.length;i2++) {
				sb=new StringBuilder();
				sb.append(values[i2]);
				sb.append(" of ");
				sb.append(suits[i]);
				stockDeck[i*values.length+i2]=sb.toString();
			}
		}
		
		br.readLine(); //blank line.
		String s;
		for (int testCase=1;testCase<=testCaseCount;testCase++) {
			int n=Integer.parseInt(br.readLine());
			int [][] combn=new int [n][52];
			
			StringTokenizer st=new StringTokenizer("");
			for (int i=0;i<n;i++) {
				for (int i2=0;i2<52;i2++) {
					if (!st.hasMoreTokens()) {
						st=new StringTokenizer(br.readLine());
					}
					combn[i][i2]=Integer.parseInt(st.nextToken())-1;
				}
			}
			
			String [] currDeck=Arrays.copyOf(stockDeck, stockDeck.length);
			while (true) {
				s=br.readLine();
				if (s==null || s.equals("")){
					break;
				}
				int combnId=Integer.parseInt(s)-1;
				String [] newDeck=new String[52];
				for (int i=0;i<52;i++) {
					newDeck[i]=currDeck[combn[combnId][i]];
				}
				currDeck=newDeck;
			}
			
			sb=new StringBuilder();
			for (int i=0;i<currDeck.length;i++){
				sb.append(currDeck[i]);
				sb.append("\n");
			}
			
			if (testCase<testCaseCount) {
				sb.append("\n");
			}
			System.out.print(sb.toString());
		}

	}
}

