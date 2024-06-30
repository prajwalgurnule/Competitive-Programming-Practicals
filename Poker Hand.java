import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static class Card implements Comparable<Card> {
		int value;
		char suit;
		public int compareTo(Card c) {
			if (this.value!=c.value) {
				return this.value-c.value;
			}
			return this.suit-c.suit;
		}
	}
	public static void main (String[]args) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		HashMap<Character,Integer> charToValue=new HashMap<>();
		for (int i=1;i<10;i++) {
			charToValue.put((char)(i+'0'), i);
		}
		charToValue.put('T',10);
		charToValue.put('J',11);
		charToValue.put('Q',12);
		charToValue.put('K',13);
		charToValue.put('A',14);
		while ((s=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(s);
			Card [] blackCards=new Card[5];
			Card [] whiteCards=new Card[5];
			for (int i=0;i<blackCards.length;i++) {
				String cStr=st.nextToken();
				Card c=new Card();
				c.value=charToValue.get(cStr.charAt(0));
				c.suit=cStr.charAt(1);
				blackCards[i]=c;
			}
			for (int i=0;i<whiteCards.length;i++) {
				String cStr=st.nextToken();
				Card c=new Card();
				c.value=charToValue.get(cStr.charAt(0));
				c.suit=cStr.charAt(1);
				whiteCards[i]=c;
			}
			
			//Sort for easier execution
			Arrays.sort(blackCards);
			Arrays.sort(whiteCards);
			int [] blackScore=getScore(blackCards);
			int [] whiteScore=getScore(whiteCards);
			String text="";
			if (blackScore[0]>whiteScore[0]) {
				text="Black wins.";
			} else if (whiteScore[0]>blackScore[0]) {
				text="White wins.";
			} else {
				if (blackScore[1]>whiteScore[1]) {
					text="Black wins.";
				} else if (whiteScore[1]>blackScore[1]) {
					text="White wins.";
				} else {
					int v=-1;
					//Flush, High Cards
					if (blackScore[0]==6 || blackScore[0]==1) {
						v=highCard(blackCards,whiteCards);
					} else if (blackScore[0]==3 || blackScore[0]==2) {
						v=comparePair(blackCards,whiteCards);
					}
					if (v==0) {
						text="Black wins.";
					} else if (v==1) {
						text="White wins.";
					} else {
						text="Tie.";
					}
				}
			}
			System.out.println(text);
		}
	}

	public static int [] getScore (Card [] c) {
		int [] rank=new int [2];
		int straightV=straight(c);
		int flushV=flush(c);
		int [] calcDupValueV=calculateDuplicateValue(c);
		if (straightV!=-1 && flushV!=-1) {
			rank[0]=9;
			rank[1]=straightV;
			return rank;
		}
		int fourOfAKindV = fourOfAKind(calcDupValueV);
		if (fourOfAKindV!=-1) {
			rank[0]=8;
			rank[1]=fourOfAKindV;
			return rank;
		}
		//full house
		int tripleV = triple(calcDupValueV);
		int pairsCountV = pairCount(calcDupValueV);
		if (tripleV!=-1 && pairsCountV==1) {
			rank[0]=7;
			rank[1]=tripleV;
			return rank;
		}
		if (flushV!=-1) {
			rank[0]=6;
			rank[1]=flushV;
			return rank;
		}
		if (straightV!=-1) {
			rank[0]=5;
			rank[1]=straightV;
			return rank;
		}
		if (tripleV!=-1 && pairsCountV==0) {
			rank[0]=4;
			rank[1]=tripleV;
			return rank;
		}
		if (pairsCountV==2) {
			rank[0]=3;
			rank[1]=pairMax(calcDupValueV);
			return rank;
		}
		if (pairsCountV==1) {
			rank[0]=2;
			rank[1]=pairMax(calcDupValueV);
			return rank;
		}
		rank[0]=1;
		rank[1]=c[c.length-1].value;
		return rank;
    }

	public static int [] calculateDuplicateValue(Card [] c) {
		int [] v=new int [15];
		for (int i=0;i<c.length;i++) {
			v[c[i].value]++;
		}
		return v;
	}

	public static int fourOfAKind(int [] v) {
		for (int i=0;i<v.length;i++) {
			if (v[i]==4) {
				return i;
			}
		}
		return -1;
	}

	public static int flush (Card [] c) {
		for (int i=1;i<c.length;i++) {
			if (c[i].suit!=c[i-1].suit) {
				return -1;
			}
		}
		return c[c.length-1].value;
	}

	public static int straight(Card [] c) {
		for (int i=1;i<c.length;i++) {
			if (c[i].value-c[i-1].value!=1) {
				return -1;
			}
		}
		return c[c.length-1].value;
	}

	public static int triple(int [] valuesCount) {
		for (int i=0;i<valuesCount.length;i++) {
			if (valuesCount[i]==3) {
				return i;
			}
		}
		return -1;
	}

	public static int pairCount(int [] valuesCount) {
		int pairsCount=0;
		for (int i=0;i<valuesCount.length;i++) {
			if (valuesCount[i]==2) {
				pairsCount++;
			}
		}
		return pairsCount;
	}

	public static int pairMax(int [] valuesCount) {
		int pairMax=-1;
		for (int i=0;i<valuesCount.length;i++) {
			if (valuesCount[i]==2) {
				pairMax=Math.max(pairMax, i);
			}
		}
		return pairMax;
	}

	public static int highCard(Card [] c1, Card [] c2) {
		for (int i=c1.length-1;i>=0;i--) {
			if (c1[i].value>c2[i].value) {
				return 0;
			} else if (c1[i].value<c2[i].value) {
				return 1;
			}
		}
		return -1;
	}

	public static int comparePair (Card [] c1, Card [] c2) {
		int [] calcDupValueV1=calculateDuplicateValue(c1);
		int [] calcDupValueV2=calculateDuplicateValue(c2);
		
		int [] c1PV=new int [2];
		int c1PVCount=0;
		for (int i=2;i<calcDupValueV1.length;i++) {
			if (calcDupValueV1[i]==2) {
				c1PV[c1PVCount++]=i;
			}
		}
		int [] c2PV=new int [2];
		int c2PVCount=0;
		for (int i=2;i<calcDupValueV1.length;i++) {
			if (calcDupValueV2[i]==2) {
				c2PV[c2PVCount++]=i;
			}
		}
		for (int i=c1PVCount-1;i>=0;i--) {
			if (c2PV[i]>c1PV[i]) {
				return 1;
			} else if (c2PV[i]<c1PV[i]) {
				return 0;
			}
		}
		//Still not found yet. Compare the remaining card...
		Card [] c1x=new Card [5-c1PVCount*2];
		int c1xCount=0;
		for (int i=0;i<5;i++) {
			if (calcDupValueV1[c1[i].value]==1) {
				c1x[c1xCount++]=c1[i];
			}
		}
		Card [] c2x=new Card [5-c2PVCount*2];
		int c2xCount=0;
		for (int i=0;i<5;i++) {
			if (calcDupValueV2[c2[i].value]==1) {
				c2x[c2xCount++]=c2[i];
			}
		}
		return highCard(c1x,c2x);
	}
}



