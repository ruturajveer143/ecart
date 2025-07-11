package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	static {
		try {
			prop = new Properties();
			InputStream configPath = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties");
			if (configPath == null) {
				throw new RuntimeException("configReader.properties not found on classpath");
			}
			prop.load(configPath);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static String get(String key) {
		return prop.getProperty(key);
	}

}
