package javaPractise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaPractise {

	public static void main(String []args) {
	int[] num= {1,7,8,9,0,3,2,1,0};
	List<Integer> list=new ArrayList<Integer>();
	
	for(Integer e:num) {
		list.add(e);
		
	}
	
	System.out.println(list);
	Collections.sort(list);
	System.out.println(list);
	
	}
}
