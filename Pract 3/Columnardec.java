/**
 * @(#)Columnardec.java
 * @Murtaza
 * @version 1.00 2013/8/3
 */
 import java.io.*;
import java.util.*;

public class Columnardec {

    public Columnardec() {
    }
    public static void main(String[] args) throws Exception{
    	FileReader inputStream = null;
        FileWriter outputStream = null;
        Scanner s = new Scanner(System.in);
        Vector<char[]> v=new Vector<char[]>();
        System.out.println("Enter columns: ");
        int d1 = s.nextInt();
        int d;
        try {
            inputStream = new FileReader("ept.txt");
            outputStream = new FileWriter("fpt.txt");
            int c;
            int i=0;

            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("ept.txt")));
            int count=br.readLine().length();
            d=count/d1;
            char[] p=new char[d];
            while ((c = inputStream.read()) != -1) {
             if(i<d)
             {
            	if(c>64&&c<91)
                	p[i++]=(char)c;
                else if(c>96&&c<123)
                	p[i++]=(char)c;
            }
            else
            {
            	v.add(p);
            	p=new char[d];
            	i=0;
            	p[i++]=(char)c;
            }
          }
          if((int)p[0]!=0)
              v.add(p);
        for(int k=0;k<d;k++)
        {
        	for(int j=0;j<v.size();j++)
        	{
        		outputStream.write(v.elementAt(j)[k]);
        	}
        }
     }
        finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
     }
}

/*Output:
Cipher text:
abababa$
Final Plaintext:
aaaabbb
*/
