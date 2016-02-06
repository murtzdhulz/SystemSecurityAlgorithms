import java.util.Scanner;
public class Linearization {
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	System.out.print("Enter Password (max length 5): ");
    	String pass=s.next();
    	if(pass.length()>5){
    		System.out.print("Length Should be Maximum 5 Characters. Retry: ");
    		pass=s.next();
    	}

    	for(int i=0,j;i<pass.length();i++){
    		char x='A',y='a',z='0';
    		j=0;
    		inner: for(;j<62;j++){
    			if(j<26){
    				if(pass.charAt(i)==x)
    					break inner;
    				x++;
    			}else{
    				if(j<52&&j>25){
    					if(pass.charAt(i)==y)
    						break inner;
    					y++;
    				}else{
    					if(pass.charAt(i)==z)
    						break inner;
    					z++;
    				}
    			}
    		}
    		System.out.println(pass.charAt(i)+": "+(j+1));
    	}
    }
}
