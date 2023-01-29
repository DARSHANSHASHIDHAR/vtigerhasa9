package genericlibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods for random number and fetching system time
 * @author Darshan S
 *
 */
public class JavaUtility {
	/**
	 * This method generates random number within the given limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNumber(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
	}
	/**
	 * This method returns System in String format
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd__MM__yyyy_mm_sss");
		return sdf.format(date);
	}
}
