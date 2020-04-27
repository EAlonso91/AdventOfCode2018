package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.ResourcePathExtractor;

/**
 * @author Enrique Alonso
 */
public class Day1 {
	private static final String INPUT_FILEPATH = "Day1.txt";

	public static int frequencyDriftFixes() {
		List<String> lines = ResourcePathExtractor.fileToLinesStream(INPUT_FILEPATH);
		return lines.stream()
				.mapToInt(Integer::parseInt)
				.sum();

	}

	public static int findFrequencyReachedTwice() {
		List<Integer> driftsList = ResourcePathExtractor.fileToLinesStream(INPUT_FILEPATH)
				.stream()
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		int frequency = 0;
		Set reachedFrequencies = new HashSet<>();
		while (true) {
			for (Integer op : driftsList) {
				frequency += op;
				if (reachedFrequencies.contains(frequency)) {
					return frequency;
				}
				reachedFrequencies.add(frequency);
			}
		}
	}
}
