package com.abcool.Library.Management.System.validations;

public class UserValidations {

	private static final String EMAIL_REGEX ="([A-Za-z0-9-_.]+@[A-Za-z0-9-_]+(?:\\.[A-Za-z0-9]+)+)";
	private static final String USERNAME_REGEX="^[a-zA-Z0-9\\\\._\\\\-]{3,}$";
	private static final String PASSWORD_REGEX="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
	
	public static String checkUsername(String uname) {
		if(uname.matches(USERNAME_REGEX)) {
			return "true";
		}else {
			return "Enter a valid username 6 to 30 characters in length "
					+ "starting with an alphabet, "
					+ "or underscore followed by combination of alphabet, "
					+ "numbers and underscore";
		}
	}
	
	public static String checkEmail(String emailID) {
		if(emailID.matches(EMAIL_REGEX)) {
			return "true";
		}else {
			return "Enter a valid Email ID";
		}
	}
	
	public static String checkPassword(String password) {
		if(password.matches(PASSWORD_REGEX)) {
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
