/**
 * @(#)Columnarenc.java
 * @Murtaza
 * @version 1.00 2013/8/3
 */
import java.io.*;
import java.util.*;

public class Columnarenc {

    public Columnarenc() {
    }
    public static void main(String[] args) throws Exception{
    	FileReader inputStream = null;
        FileWriter outputStream = null;
        Scanner s = new Scanner(System.in);
        Vector<char[]> v=new Vector<char[]>();
        System.out.println("Enter columns: ");
        int d = s.nextInt();

        try {
            inputStream = new FileReader("pt.txt");
            outputStream = new FileWriter("ept.txt");
            int c;
            int i=0;
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

          for(int k=0;k<p.length;k++)
          {
              if((int)p[k]==0)
              	  p[k]='$';
          }
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
Plaintext:
aaaabbb
Cipher text:
abababa$
*/