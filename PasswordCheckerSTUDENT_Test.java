
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerSTUDENT_Test {

	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	
	}

	/**
	 * Test if the password is less than 8 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Cmsc2"));
			System.out.println("Did not throw lengthException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a " +  e);
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("CMSC204_at_Montgomery"));
			System.out.println("Did not throw NoUpperAlphaException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a " + e);
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{

		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Firaoli_CMSC_204_at_Montgomery_College"));
			System.out.println("Did not throw NoLowerAlphaException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()  {
		try {
			String weakPassword = "Cmsc204";
			assertTrue(PasswordCheckerUtility.isValidPassword(weakPassword));
			System.out.println("I do not have anything to throw at you. \nI just think ''" + weakPassword + "'' is a weak password. You should try another one." );
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}

	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Firaoli_CMSC_204_at_Montgomery_College_year_2020"));
			System.out.println("Did not throw InvalidSequenceException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}

	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Firaoli_Seboka_Learing_CMSC_stuff"));
			System.out.println("Did not throw InvalidSequenceException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Firaoli_Seboka_Learing_CMSC_204_stuff"));
			System.out.println("Did not throw NoDigitException");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}
	}
	
	/**
	 * Test the validPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testValidPasswords() {
		try {
			ArrayList<String> validMethodTest = new ArrayList<String>();
			validMethodTest.add("Firaoli_Seboka_Learing_CMSC_204_stuff_in_2020");
			assertTrue(PasswordCheckerUtility.isValidPassword(validMethodTest.get(0)));
			System.out.println("Did not throw any exception");
		} catch (LengthException | NoDigitException | NoLowerAlphaException | InvalidSequenceException | NoUpperAlphaException e) {
			System.out.println("Successfully threw a "+e);
		}
	}
	
}
