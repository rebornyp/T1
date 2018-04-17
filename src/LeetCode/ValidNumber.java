package LeetCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class ValidNumber {

	public static void main(String[] args) {
//		File f = new File("C:\\Users\\Gastby\\Desktop/README.md");
		File f = new File("C:\\Users\\Gastby\\Desktop/a.java");
		if(!f.exists()) return;
		System.out.println(f.getName());
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String str = null;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Scanner s = null;
		try {
			s = new Scanner(f);
			System.out.println(f.length());
			s.useDelimiter(" ");
			while(s.hasNextLine())
				System.out.println(s.nextLine());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if(s != null) s.close();
		}
	}

    public static boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        if(s.length() == 0) return false;
//        boolean dotFlag = false, eFlag = false;
        
        for(int i=0; i<s.length(); i++) {
        	switch(s.indexOf(i)) {
        	case '+':
        		System.out.println("dh");
        		break;
        	case '-':
        		System.out.println("dh");
        		break;
        	}
        }
    	return false;
    }

    public static int[] plusOne(int[] dig) {
        if(dig == null || dig.length == 0) return null;
        dig[dig.length-1] += 1;
    	for(int i=dig.length-1; i>0; i--) {
    		if(dig[i] == 10) {
    			dig[i] = 0;
    			dig[i-1] += 1;
    		}
    	}
    	if(dig[0] == 10) {
    		int[] arr = new int[dig.length + 1];
    		for(int i=1; i<arr.length ;i ++)
    			arr[i] = dig[i-1];
    		arr[0] = 1;
    		arr[1] = 0;
    		dig = arr;
    	}
    	return dig;
    }

    public static String addBinary(String a, String b) {
        if(a == null || b == null || (a.length() == 0 && b.length() == 0)) return null;
        if(a.length() == 0) return b;
        if(b.length() == 0) return a;
    	StringBuilder s = new StringBuilder();
        int i = a.length()-1, j = b.length()-1;
        boolean plus = false;
        while(i >= 0 && j >= 0) {
        	if(a.charAt(i) == '1' && b.charAt(j) == '1') {
        		if(plus == true) s.append('1');
        		else {
        			s.append('0');
        			plus = true;
        		}
        	} else if(a.charAt(i) == '0' && b.charAt(j) == '0') {
        		if(plus == true) {
        			s.append('1');
        			plus = false;
        		} else 
        			s.append('0');
        	} else {
        		if(plus == true) {
        			s.append('0');
        		} else
        			s.append('1');
        	}
        	System.out.println(s.toString());
        	i --;
        	j --;
        }
        if(i == -1 && j == -1) {
        	if(plus == true)
        		s.append('1');
        } else if(i == -1) {
    		while(j >= 0) {
    			if(b.charAt(j) == '1') {
    				if(plus == true) s.append('0');
    				else s.append('1');
    			} else {
    				if(plus == true) {
    					s.append('1');
    					plus = false;
    				}
    				else s.append('0');
    			}
    			j --;
    		}
    		if(plus == true) s.append('1');
        } else {
        	while(i >= 0) {
    			if(a.charAt(i) == '1') {
    				if(plus == true) s.append('0');
    				else s.append('1');
    			} else {
    				if(plus == true) {
    					s.append('1');
    					plus = false;
    				}
    				else s.append('0');
    			}
    			i --;
    		}
    		if(plus == true) s.append('1');
        }
        s = s.reverse();
    	return s.toString();
    }

    public static int mySqrt(int x) {
    	if(x < 0) return -1;
    	if(x == 0) return 0;
    	int i = 1, j = x / 2 + 1;
    	while(i < j) {
    		int k = (i + j) / 2;
//    		System.out.println(i + "-" + j + "-" + k);
    		if(x / k >= k && x / (k + 1) < (k + 1))
    			return k;
    		else if(k > x / k)
    			j = k;
    		else {
    			i = k;
    		}
    	}
    	return i;  
    }

    public static String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        String[] arr = path.split("/");
        Stack<String> s1 = new Stack<String>();
        for(int i=0; i<arr.length; i++) {
        	if(arr[i].equals(".") || arr[i].length() == 0)
        		continue;
        	else if(arr[i].equals("..")) {
        		if(!s1.isEmpty())
        			s1.pop();
        	} else {
        		s1.push(arr[i]);
        	}
        }
        Stack<String> s2 = new Stack<String>();
        while(!s1.isEmpty())
        	s2.push(s1.pop());
        StringBuilder sb = new StringBuilder();
        while(!s2.isEmpty()) {
        	sb.append("/");
        	sb.append(s2.pop());
        }
        if(sb.length()==0)
            sb.append("/");
    	return sb.toString();
    }
    
}

