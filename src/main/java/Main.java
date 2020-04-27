import java.util.ArrayList;

import day1.Day1;
import day1.Day2;

/**
 * @author Enrique Alonso
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("--- Day 1: Chronal Calibration ---");
		System.out.println("			Part 1 solution: "+ Day1.frequencyDriftFixes());
		System.out.println("			Part 2 solution: "+ Day1.findFrequencyReachedTwice());
		System.out.println("--- Day 2: Inventory Management System ---");
		System.out.println("			Part 1 solution: "+ Day2.calculateChecksumFromFile());
		System.out.println("			Part 2 solution: "+ Day2.calculateCommonCharactersFromFile());
	}
}
