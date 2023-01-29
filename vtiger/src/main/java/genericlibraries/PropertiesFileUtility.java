package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class does all the operation on properties file
 * @author Darshan S
 */
public class PropertiesFileUtility  {
	private Properties property;
	/**
	 * This method initializes properties file and creates an instance of Property class and loads the file
	 * @param path
	 */
	public void propertiesFileInitialization(String path)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method fetches the key data from properties file 
	 * @param key
	 * @return
	 */
	public String fetchProperty(String key) {
		return property.getProperty(key);
	}
	/**
	 * This method modifies the data in properties file and gives corresponding message
	 * @param key
	 * @param value
	 * @param message
	 * @param path
	 */
	public void modifyPropertiesFile(String key, String value, String message, String path) {
		property.put(key, value);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.store(fos, message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
