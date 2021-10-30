package SDET21.Genericutils;

import java.util.Random;

/**
 * this class has generic methods related java library
 * @author DEEPAK LENKA
 *
 */

public class JavaUtility {
	
	/**
	 * Returns the random number to the caller
	 * @return
	 */
	public int getRandomNumber()
	{
		Random ran=new Random();
		int random=ran.nextInt(100);
		return random;
	}

}
