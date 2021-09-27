package com.mindtree.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public static Properties loadFile() throws IOException  {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(".\\config.properties");
		prop.load(fis);
		System.out.print("working");
		return prop;
	}
}
