package scripts;

public class AssertionTest1 {
	
	public boolean isText(String text){
		String pattern= "^[a-zA-Z ]*$";
	    return text.matches(pattern);
	}
	public boolean isNumber(String number){
		String pattern= "^[0-9]*$";
	    return number.matches(pattern);
	}
	public boolean isAlphaNumeric(String alphaNumeric){
	    String pattern= "^[a-zA-Z0-9]*$";
	    return alphaNumeric.matches(pattern);
	}
	
	public boolean notNull(String str){
	String pattern = "";
	return str.matches(pattern);
		
	}
	
}
