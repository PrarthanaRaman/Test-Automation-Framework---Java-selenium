package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Environment;

public class PropertiesUtil {

	public static String readProperty(Environment env, String PropertyName) {

		File propFile = new File(System.getProperty("user.dir") + "//config//" + env + ".properties");
		FileReader reader = null;
		Properties properties = new Properties();

		try {
			reader = new FileReader(propFile);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = properties.getProperty(PropertyName.toUpperCase());
		return value;
	}

}
