package com.qa.ims.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public  class Utils {

	private static final Logger LOGGER = LogManager.getLogger();
	private final Scanner scanner;

	private Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}
	
	public Utils() {
		scanner = new Scanner(System.in);
	}

	public Long getLong() {
		while (!scanner.hasNextLong()) {
			scanner.next();
		}
		return Long.parseLong(scanner.nextLine());

	}

	public String getString() {
		return scanner.nextLine();

	}

	public Integer getInt() {
		while (!scanner.hasNextInt()) {
			scanner.next();
		}
		return Integer.parseInt(scanner.nextLine());

	}

	public Double getDouble() {
		while (!scanner.hasNextDouble()) {
			scanner.next();
		}
		return Double.parseDouble(scanner.nextLine());

	}

}
