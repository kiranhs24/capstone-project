package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	
	static Properties prop;
	
	public static Properties readPropertiesFiles(String fileName) throws IOException {

		FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/props/" + fileName);
		prop = new Properties();
		prop.load(reader);
		reader.close();
		return prop;

	}

}
