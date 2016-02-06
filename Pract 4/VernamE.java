/**
 * @(#)Vernam.java
 * @Murtaza 
 * @version 1.00 2013/8/8
 */

import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class VernamE {
    public static void main(String[] args) throws Exception{
    	Scanner s = new Scanner(System.in);
    	BufferedReader b = new BufferedReader(new FileReader("pt.txt"));
    	FileWriter fw = new FileWriter("ct.txt");
    	String pt = b.readLine().toLowerCase();
    	char[] pta = pt.toCharArray();
    	System.out.print ("Enter seed: ");
    	int c,k;
    	Random r = new Random(s.nextInt());
    	try{
    		System.out.println ("NE\tKey\tOPNE");
    		for(int i=0;i<pta.length;i++){
    		if(Character.isLetter(pta[i])){
    			pta[i]-=97;
    		}
    		fw.write((char)(97+(c=(pta[i]+(k=r.nextInt(50)))%26)));
    		System.out.println ((int)pta[i]+"\t"+k+"\t"+c);
    	}
    	}catch(Exception e){
    		System.out.println (e);
    	}finally{
    		fw.close();
    		b.close();
    	}    	
    }
}
/*Output:
Enter seed: 5
NE  Key OPNE
7   37  18
4   42  20
11  24  9
11  24  9
14  6   20

Plaintext: hello
Ciphertext: sujju
*/