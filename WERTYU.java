import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class WERTYU {

	public static void main (String [] abc) throws IOException  {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s;
		char [] replacement=new char [128];
		for (int i=0;i<replacement.length;i++) {
			replacement[i]=(char)i;
		}
		String [] lines=new String [] {"`1234567890-=", "QWERTYUIOP[]\\",
									   "ASDFGHJKL;'","ZXCVBNM,./"};
		for (int i=0;i<lines.length;i++) {
			for (int i2=1;i2<lines[i].length();i2++) {
				replacement[lines[i].charAt(i2)]=lines[i].charAt(i2-1);
			}
		}
		while ((s=br.readLine())!=null) {
			StringBuilder sb=new StringBuilder();
			for (int i=0;i<s.length();i++) {
				sb.append(replacement[s.charAt(i)]);
			}
			System.out.println(sb.toString());
		}
	}
}


