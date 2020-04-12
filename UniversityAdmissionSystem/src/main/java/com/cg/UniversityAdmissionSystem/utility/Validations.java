package com.cg.UniversityAdmissionSystem.utility;

public class Validations {
	
	public static boolean firstNameValidation(String firstName)
	{
		String pattern = "[A-Z][A-Za-z]{3,20}";
		if(firstName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean lastNameValidation(String lastName)
	{
		String pattern = "[A-Z][A-Za-z]{4,20}";
		if(lastName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean dateOfBirthValidation(String dateOfBirth)
	{
		String pattern = "[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}";
		if(dateOfBirth.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean fatherNameValidation(String fatherName)
	{
		String pattern = "[A-Za-z]{4,30}";
		if(fatherName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean emailValidation(String email)
	{
		String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
		if(email.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean mobileNumberValidation(String mobileNumber)
	{
		String pattern = "{9}{1}-[6-9]{1}[0-9]{9}";
		if(mobileNumber.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean userNameValidation(String userName)
	{
		String pattern = "[A-Za-z]{4,20}[@]{1}[gmail]{5}[.com]{4}";
		if(userName.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean passwordValidation(String password)
	{
		String pattern = "[A-Za-z]{3,6}[0-9]{2}[@#$%&*]{1}";
		if(password.matches(pattern))
		{
			return true;
		}
		else
			return false;
	}
	public static boolean optionValidate(String option) {
		String pattern = "[1-4]{1}";
		if(option.matches(pattern))
			return true;
		else
		return false;
	}
	
	
}



