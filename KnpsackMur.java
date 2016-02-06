/**
 * @(#)Knpsack.java
 *
 *
 * @Murtaza
 * @version 1.00 2013/10/4
 */
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.math.BigInteger;

public class KnpsackMur {

    /**
     * Creates a new instance of <code>Knpsack</code>.
     */
    public void Knpsack() {
    }
    public static int[] permute(int[] t,int[] p)
    {
    	int[] a=new int[7];
    	for(int i=0;i<7;i++)
    	{
    		a[i]=t[p[i]];
    	}
    	return a;
    }

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter first two elements of b:");
    	int b[]=new int[7];
    	Random rn=new Random(5);
    	for(int i=0;i<2;i++)
    	{
    		b[i]=sc.nextInt();
    	}
    	int perm[]=new int[7];
        System.out.println("Enter permutation tuple :");
        for(int i=0;i<7;i++)
        {
        	perm[i]=sc.nextInt();
        }
    	int sum=b[0]+b[1];
    	for(int i=2;i<7;i++)
    	{
    		b[i]=sum+rn.nextInt(200);
    		sum+=b[i];
    	}
    	System.out.println("Tuple b:"+Arrays.toString(b));
        int n=sum+rn.nextInt(100);
        BigInteger n1=new BigInteger(n+"");
        BigInteger r1=BigInteger.probablePrime(9,rn);
        while(!(n1.gcd(r1)).equals(BigInteger.ONE))
        {
        	r1=BigInteger.probablePrime(9,rn);
        }
        int t[]=new int[7];
        n=n1.intValue();
        int r=r1.intValue();
        for(int i=0;i<7;i++)
        {
        	t[i]=(r*b[i])%n;
        }
        System.out.println("n="+n+" "+"r="+r);
        int a[]=permute(t,perm);
        System.out.println("Public key = a ="+Arrays.toString(a));
    	System.out.println("Enter a character:");
    	char c=sc.next().charAt(0);
    	String str=String.format("%7s",Integer.toBinaryString(c).replace(' ','0'));
    	System.out.println(str);
    	int fsum=0;
    	for(int i=0;i<7;i++)
    	{
    		if(str.charAt(i)=='1')
    		{
    			fsum+=a[i];
    		}
    	}
    	System.out.println("Send the sum(encrypted text):"+fsum);
    	System.out.println("Private key:"+n+","+r+","+Arrays.toString(b));
    	System.out.println("Decryption side ---->");
    	sum=(BigInteger.valueOf(r).modInverse(BigInteger.valueOf(n)).intValue()*fsum)%n;
    	System.out.println("Value of S':"+sum);
    	StringBuilder cb=new StringBuilder();
    	for(int i=6;i>=0;i--)
    	{
    		if(sum>=b[i])
    		{
    			cb.insert(0,"1");
    			sum-=b[i];
    		}
    		else
    		{
    			cb.insert(0,"0");
    		}
    	}
    	System.out.println("Tuple x before permutation:"+cb.toString());
    	char[] bp=new char[7];
    	char[] fin1=new char[7];
    	cb.getChars(0,cb.length(),bp,0);
    	for(int i=0;i<7;i++)
    	{
    		fin1[i]=bp[perm[i]];
    	}
    	StringBuilder db=new StringBuilder();
    	db.append(fin1);
    	System.out.println("Tuple x after permutation:"+db.toString());
    	char fin=(char)Integer.parseInt(db.toString(),2);
    	System.out.println("Finally after decryption:"+fin);
    }
}
/*Output
Enter first two elements of b:
2
3
Enter permutation tuple :
4 3 1 0 2 5 6
Tuple b:[2, 3, 92, 189, 360, 670, 1422]
n=2743 r=457
Public key = a =[2683, 1340, 1371, 914, 899, 1717, 2506]
Private key:2743,457,[2, 3, 92, 189, 360, 670, 1422]
Enter a character:
a
1100001
Send the sum(encrypted text):6529
Decryption side ---->
Value of S':1971
Tuple x before permutation:0001101
Tuple x after permutation:1100001
Finally after decryption:a
*/
