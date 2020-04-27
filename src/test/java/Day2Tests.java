import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import day1.Day2;

/**
 * @author Enrique Alonso
 */
public class Day2Tests {
	@Test
	public void calculateChecksumFromBoxListTest() {
		List<String> boxes = new ArrayList<>();
		boxes.add("abcdef");
		boxes.add("bababc");
		boxes.add("abbcde");
		boxes.add("abcccd");
		boxes.add("aabcdd");
		boxes.add("abcdee");
		boxes.add("ababab");
		assertEquals(12, Day2.calculateChecksum(boxes));
	}
	@Test
	public void calculateCommonCharactersTest(){
		List<String> boxes = new ArrayList<>();
		boxes.add("abcde");
		boxes.add("fghij");
		boxes.add("klmno");
		boxes.add("pqrst");
		boxes.add("fguij");
		boxes.add("axcye");
		boxes.add("wvxyz");
		assertEquals("fgij", Day2.calculateCommonCharacters(boxes));

	}
}
