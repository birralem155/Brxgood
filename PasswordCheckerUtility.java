/**
 * @author Berhanu Belihu
 * This program checks the password and taste Strings —
 * using the java exception class and few methods which test the input string
 */
import java.util.ArrayList;
public  class PasswordCheckerUtility {
	/**
	 * This method of the program checks the validity of the password string.
	 * @param passwordString
	 * @return boolean
	 * @throws NoDigitException
	 * @throws NoUpperAlphaException
	 * @throws NoLowerAlphaException
	 * @throws InvalidSequenceException
	 * @throws LengthException
	 */
	public static boolean isValidPassword (String passwordString) throws
			NoDigitException, NoUpperAlphaException, NoLowerAlphaException, InvalidSequenceException, LengthException {
		boolean result ;
		if(passwordString.length() < 6){
			throw new LengthException ();
		}
			 result = upperCaseChecker(passwordString);

		if (!result) {
			throw new NoUpperAlphaException ();
		}
			result = lowerCaseChecker(passwordString);

		if (!result) {
				throw new NoLowerAlphaException ();
		}

		result = digitChecker(passwordString);

		if (!result) {

			throw new NoDigitException();
		}

		int count = 0;

		for (int i = 0; i < passwordString.length()-1; i++) {
			if ((passwordString.charAt(i)) == (passwordString.charAt(i + 1))) {
				count = count + 1;
			}
			else {
				count = 0;
			}
			if(count >= 2) {
				throw  new InvalidSequenceException();
			}
		}
		isWeakPassword(passwordString);

		return true;
	}

	/**
	 * This method checks for upper case letters.
	 * If it found an upper case letter, it will return true.
	 * If the method did not find any upper case letter, it would return false
	 *
	 * @param passwordString
	 * @return boolean
	 */
	private static boolean upperCaseChecker(String passwordString ) {

		for (int i = 0; i < passwordString.length(); i++) {
			char checkUpperCase = passwordString.charAt(i);
			if (Character.isUpperCase(checkUpperCase)) {
				return true;
			}
		}

		return false;

	}

	/**
	 * This method checks for lower case letters.
	 * If it found a lower case letter, it will return true.
	 * If the method did not find any lower case letter, it would return false
	 *
	 * @param passwordString
	 * @return boolean
	 */
	private static boolean lowerCaseChecker(String passwordString) {

		for (int i = 0; i < passwordString.length(); i++) {
			char checkUpperCase = passwordString.charAt(i);
			if (Character.isLowerCase(checkUpperCase)) {
				 return  true;
			}
		}

		return false;

	}

	/**
	 * This method checks for digit character letters.
	 * If it found a digit character, it will return true.
	 * If the method did not find any digit character, it would return false
	 *
	 * @param passwordString
	 * @return boolean
	 */
 	private static boolean	digitChecker(String passwordString) {
		for (int i = 0; i < passwordString.length(); i++) {
			char checkUpperCase = passwordString.charAt(i);
			if (Character.isDigit(checkUpperCase)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will check for the strengths of the password
	 * if the password string or the characters in the passwords are
	 * more extended than six and equal to six and less than ten.
	 * It will return true means the password is weak but valid.
	 * If the method returns false, that means the password is strong.
	 *
	 * @param passwordString
	 * @return boolean
	 */
	public static boolean isWeakPassword(String passwordString) {


		 if(passwordString.length() >= 6 && passwordString.length() < 10) {

		 	return true;
		 }else {

			 return false;
		 }

	}

	/**
	 * This method will use ArrayList of strings to check the validity of the strings of password lists.
	 * To test the efficacy of the passwords this method uses a call method to call isValidPassword
	 * method. "isValidPassword" method then checks the argument passed by this method and returns a boolean.
	 * Then this method creates a new ArrayList.
	 * @param passwords
	 * @return ArrayList
	 */
	public static ArrayList<String> invalidPasswords(ArrayList<String> passwords) {

		ArrayList<String> password = new ArrayList<String>();


		for (int i = 0; i <passwords.size(); i++) {
			boolean result = true;
			try {
				if (isValidPassword(passwords.get(i))) {
					result = true;
				}
			} catch (NoDigitException e) {
				e.printStackTrace();

			} catch (NoUpperAlphaException e) {
				e.printStackTrace();
			} catch (NoLowerAlphaException e) {
				e.printStackTrace();
				} catch (InvalidSequenceException e) {
					e.printStackTrace();
				} catch (LengthException e) {
					e.printStackTrace();
				}

				}

		return password;


	}

}