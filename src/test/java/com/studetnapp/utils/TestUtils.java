package com.studetnapp.utils;

import java.util.Random;

public class TestUtils {
	
	public static String getRandomValue() {
		Random random = new Random();
		int randomint =random.nextInt(10000);
		return Integer.toString(randomint);
	}

}
