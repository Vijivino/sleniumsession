package javaPractise;

public class UpperCaseSenten {
	
	public static void main (String [] args) {
		
		String str="this is a very good day";
		String[] split = str.split(" ");
		System.out.println(split);
		
		for(int i=0;i<split.length;i++) {
			
			char char1 = split[i].charAt(0);
			 StringBuilder string = new StringBuilder(split[i]);
		     string.setCharAt(0, Character.toUpperCase(char1));
		     System.out.println(string);
	
		}
		
		
	}

}
