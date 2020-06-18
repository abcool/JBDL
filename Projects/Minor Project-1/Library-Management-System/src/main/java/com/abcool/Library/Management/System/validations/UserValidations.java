package com.abcool.Library.Management.System.validations;

public class UserValidations {

	public static String checkUsername(String uname) {
		if(uname.matches("^[aA-zZ]\\w{5, 29}$")) {
			return "true";
		}else {
			return "Enter a valid username 6 to 30 characters in length "
					+ "starting with an alphabet, "
					+ "or underscore followed by combination of alphabet, "
					+ "numbers and underscore";
		}
	}
	
	public static String checkEmail(String emailID) {
		if(emailID.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\r\n" + 
				"      @[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
			return "true";
		}else {
			return "Enter a valid Email ID";
		}
	}
	
	public static String checkPassword(String password) {
		if(password.matches("((?=.*[a-z])(?=.*\\\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")) {
			return "true";
		}else {
			return "Enter a password that is between 8 and 40 characters long \n"
					+"Contain at least one digit \n"
					+"Contain at least one lower case character \n"
					+"Contain at least one upper case character \n"
					+"Contain at least on special character from [ @ # $ % ! . ] \n";
		}
	}
}
