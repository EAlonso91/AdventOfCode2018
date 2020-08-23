import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import day3.Day3;

/**
 * @author Enrique Alonso
 */
public class Day3Test {

	@Test
	public void calculateOverlappingSquaresTest() {
		List<String> claims = new ArrayList<>();
		claims.add("#1 @ 1,3: 4x4");
		claims.add("#2 @ 3,1: 4x4");
		claims.add("#3 @ 5,5: 2x2");
		assertEquals(4, Day3.calculateOverlappingSquares(claims));
	}
}