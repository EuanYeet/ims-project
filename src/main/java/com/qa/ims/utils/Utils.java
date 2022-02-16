package com.qa.ims.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Utils {

	private static final Logger LOGGER = LogManager.getLogger();
	private static final Scanner scanner = new Scanner(System.in);

	private Utils() {
	}

	public static Long getLong() {
		while (!scanner.hasNextLong()) {
			scanner.next();
		}
		return Long.parseLong(scanner.nextLine());

	}

	public static String getString() {
		return scanner.nextLine();

	}

	public static Integer getInt() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		return Integer.parseInt(scanner.nextLine());

	}

	public static Double getDouble() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
		}
		return Double.parseDouble(scanner.nextLine());

	}

}
