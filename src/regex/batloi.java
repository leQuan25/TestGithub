package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class batloi {

	public  boolean kiemtaten(String ten)
	{
		String regex="[a-zA-z]+";
		Matcher match1=Pattern.compile(regex).matcher(ten); 
		return match1.matches();
		
		
		
	}

	public boolean kiemtaten1(String text) {
		String regex="[0-9]+";
		Matcher match1=Pattern.compile(regex).matcher(text); 
		return match1.matches();
	}
	
	public boolean kiemtraemai(String text) {
		String regex="^([\\w]+[\\@]gmail[\\.]com)$";
		Matcher match=Pattern.compile(regex).matcher(text); 
		return match.matches();

	}
	
	public boolean kiemtralop(String text){
		String regex="^([0-9]{1,2}+[A-Z])$";
		Matcher match=Pattern.compile(regex).matcher(text); 
		return match.matches();
	}
	
}
