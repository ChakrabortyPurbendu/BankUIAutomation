package browser;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
public class Utility {
	/*
	 *   Reads data from properties file and returns data 
	 */
	public static String properties(String data) throws Exception {  
		String propertiesData = null;
		try {
			String filePath = System.getProperty("user.dir")
			        + File.separator + "src"
			        + File.separator + "main"
			        + File.separator + "resources"
			        + File.separator + "Configure.properties";
			FileReader reader = new FileReader(filePath);
			Properties p = new Properties();
			p.load(reader);
			propertiesData = p.getProperty(data);   
		} catch (Exception e) {
			System.out.println("Properties : " + e);
		}
		return propertiesData;   
	}
	
	public static void main(String [] arg) throws Exception {
		System.out.println(Utility.properties("url"));	}

}