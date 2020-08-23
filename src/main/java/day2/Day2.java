package day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import utils.ResourcePathExtractor;

/**
 * @author Enrique Alonso
 */
public class Day2 {
	private static final String INPUT_FILEPATH = "Day2.txt";

	public static int calculateChecksumFromFile() {
		List<String> boxes = ResourcePathExtractor.fileToLinesStream(INPUT_FILEPATH);
		return calculateChecksum(boxes);
	}

	public static int calculateChecksum(List<String> boxes) {
		int threeCount = 0;
		int twoCount = 0;
		for (String box : boxes) {
			//System.out.println("WORD: "+box);
			char[] chars = box.toCharArray();
			Map<Character, Integer> characterCount = new HashMap<>();
			for (char c : chars) {
				if (characterCount.containsKey(c)) {
					characterCount.put(c, characterCount.get(c) + 1);
				} else {
					characterCount.put(c, 1);
				}
			}
			/*characterCount.entrySet().stream().forEach(e-> System.out.println(e));
			System.out.println("---------------------");*/
			if (characterCount.containsValue(2)) {
				twoCount++;
			}
			if (characterCount.containsValue(3)) {
				threeCount++;
			}
		}
		return threeCount * twoCount;
	}

	public static String calculateCommonCharactersFromFile() {
		List<String> boxes = ResourcePathExtractor.fileToLinesStream(INPUT_FILEPATH);
		return calculateCommonCharacters(boxes);
	}

	public static String calculateCommonCharacters(final List<String> boxes) {
		for (String box1 : boxes) {
			char[] chars1 = box1.toCharArray();
			for (String box2 : boxes) {
				if(!box1.equals(box2)){
				char[] chars2 = box2.toCharArray();
				if (chars1.length != chars2.length) {
					break;
				}
				int differences = 0;
				for (int i = 0; i < chars1.length; i++) {
					if (chars1[i] != chars2[i]) {
						differences++;
						if (differences == 2) {
							break;
						}
					}
				}
				if (differences == 1) {
					return commonCharacters(chars1, chars2);
				}
			}}
		}

		throw new RuntimeException("No common boxes found");
	}

	private static String commonCharacters(final char[] box1, final char[] box2) {
		char[] commonChars = new char[box1.length-1];
		int currentChar=0;
		for (int i = 0; i < box1.length; i++) {
			if(box1[i]==box2[i]){
				commonChars[currentChar]=box1[i];
				currentChar++;
			}
		}
		return String.valueOf(commonChars);
	}

}
