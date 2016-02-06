import java.util.Scanner;
public class Bruteforce {
	static StringBuilder passb=new StringBuilder("AAAA");
	static char[] x={'A','A','A','A'},y={'a','a','a','a'},z={'0','0','0','0'};
	public static void changeChar(int pos,int pos2){
		if(pos2<26){
			passb.setCharAt(pos,++x[pos]);
			y[pos]='a';
			z[pos]='0';
    			}else{
    				if(pos2<52){
    					passb.setCharAt(pos,y[pos]++);
    					x[pos]='A';
    					z[pos]='0';
    				}else{
    					passb.setCharAt(pos,z[pos]++);
    					x[pos]='A';
    					y[pos]='a';
    				}
    			}
	}
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter Password (length 4): ");
    	String pass=s.next();
    	if(pass.length()>4){
    		System.out.print("Length Should be 4 Characters. Retry: ");
    		pass=s.next();
    	}
    	long count=0;
    	for(int i=0;i<62;i++){
    		for(int j=0;j<62;j++){
    			for(int k=0;k<62;k++){
    				for(int l=0;l<62;l++){
    					count++;
    					if(pass.equals(passb.toString())){
    						System.out.println("Interation: "+count);
    						System.exit(1);
    					}else{
    						changeChar(3,l);
    					}
    				}
    				if(pass.equals(passb.toString())){
    					System.out.println("Interation: "+count);
    					System.exit(1);
    				}
    				passb.setCharAt(3,'A');
    				changeChar(2,k);
    			}
    			if(pass.equals(passb.toString())){
    				System.out.println("Interation: "+count);
    				System.exit(1);
    			}
    			passb.setCharAt(3,'A');
    			passb.setCharAt(2,'A');
    			changeChar(1,j);
    		}
    		if(pass.equals(passb.toString())){
    			System.out.println("Interation: "+count);
    			System.exit(1);
    		}
    		passb.setCharAt(3,'A');
    		passb.setCharAt(2,'A');
    		passb.setCharAt(1,'A');
    		changeChar(0,i);
    	}
    	System.out.println("No match found!");
    }
}
/*Output:
Enter Password (length 4): ZZZZ
Interation: 6055876
*/