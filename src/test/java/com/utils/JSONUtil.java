package com.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Environment;
import com.google.gson.Gson;
import com.ui.pojo.Environments;
import com.ui.pojo.config;

public class JSONUtil {
	public static Environments readJSON(Environment env) {

		Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir") + "//config//config.json");
		FileReader reader = null;
		try {
			reader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		config config = gson.fromJson(reader, config.class);
		Environments environment = config.getEnvironments().get("QA");
		return environment;

	}

}
