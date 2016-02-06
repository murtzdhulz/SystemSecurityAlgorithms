/**
 * @(#)Vernam.java
 * @Murtaza 
 * @version 1.00 2013/8/8
 */

import java.io.*;
import java.util.Scanner;
import java.util.Random;
public class VernamD {

    public static void main(String[] args) throws Exception{
    	Scanner s = new Scanner(System.in);
    	BufferedReader b = new BufferedReader(new FileReader("ct.txt"));
    	FileWriter fw = new FileWriter("fpt.txt");
    	String pt = b.readLine().toLowerCase();
    	char[] pta = pt.toCharArray();
    	System.out.print ("Enter seed: ");
    	Random r = new Random(s.nextInt());
    	int n,k,n1;
    	try{
    		System.out.println ("NE\tKey\tOPNE");
    		for(int i=0;i<pta.length;i++){
    		if(Character.isLetter(pta[i])){
    			pta[i]-=97;
    		}
    		fw.write((char)(97+(n1=(n=(pta[i]-(k=r.nextInt(50)))%26)>0?n:(n+26))));
    		System.out.println ((int)pta[i]+"\t"+k+"\t"+n1);
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
18  37  7
20  42  4
9   24  11
9   24  11
20  6   14

Ciphertext: sujju
Deciphered text: hello
*/