package genericUtility;

import java.util.Date;
import java.util.Random;

public class javaUtility {
	/**
	 * this method is used to obtain random number
	 * 
	 * @return
	 */
	public int toGetRandomNumber() {
		Random r = new Random();
		int random = r.nextInt(100000);
		return random;
	}

	/**
	 * This method will get actual date and time in required format
	 */

	public String toGetSystemDateAndTime() {
		Date d = new Date();
		String date[] = d.toString().split(" ");
		// System.out.println(d); //Wed Mar 20 08:37:31 IST 2024
		String day = date[0];
		String month = date[1];
		String date1 = date[2];
		String time = date[3].replace(":", "-");
		String year = date[5];
		String finaldate = day + " " + month + " " + date1 + " " + time + " " + year;
		// System.out.println(finaldate); //Wed Mar 20 08-41-40 2024
		return finaldate;
	}

}
