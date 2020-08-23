package day3;

import java.util.*;
import java.util.stream.Collectors;

import day2.Claim;
import utils.ResourcePathExtractor;

/**
 * @author Enrique Alonso
 */
public class Day3 {
	private static final String INPUT_FILEPATH = "Day3.txt";

	public static long calculateOverlappingSquaresFromFile() {
		List<String> claims = ResourcePathExtractor.fileToLinesStream(INPUT_FILEPATH);
		return calculateOverlappingSquares(claims);
	}

	public static long calculateOverlappingSquares(final List<String> claims) {
		int[][] fabric = new int[1000][1000];
		Map<Integer, Claim> claimsMap = new HashMap<>();
		for (String claimSeq : claims) {
			Claim claim = new Claim(claimSeq);
			claimsMap.put(claim.getId(), claim);
			for (int i = claim.getDistanceTopMargin(); i < claim.getDistanceTopMargin() + claim.getHeight(); i++) {
				for (int j = claim.getDistanceLeftMargin(); j < claim.getDistanceLeftMargin() + claim.getWidth(); j++) {
					fabric[i][j]++;
				}
			}
		}
		printNonOverlappingClaim(fabric, claimsMap);

		return Arrays.stream(fabric)
				.flatMapToInt(x -> Arrays.stream(x))
				.filter(x -> x > 1)
				.count();
	}

	private static void printNonOverlappingClaim(final int[][] fabric, final Map<Integer, Claim> claimsMap) {
		Map<Integer, int[]> claimsAndCoveredFabric = claimsMap.entrySet()
				.stream()
				.collect(Collectors.toMap(e -> e.getKey(), e -> claimToFabricArray(e.getValue(), fabric)));
		claimsAndCoveredFabric.entrySet()
				.stream()
				.filter(e -> !Arrays.stream(e.getValue())
						.filter(n -> n > 1)
						.findAny()
						.isPresent())
				.map(e -> e.getKey())
				.forEach(e -> System.out.println("			Non-overlapping claim: " + e));
	}

	private static int[] claimToFabricArray(Claim claim, int[][] fabric) {
		int[] coveredFabric = new int[claim.getWidth() * claim.getHeight()];
		int index = 0;
		for (int i = claim.getDistanceTopMargin(); i < claim.getDistanceTopMargin() + claim.getHeight(); i++) {
			for (int j = claim.getDistanceLeftMargin(); j < claim.getDistanceLeftMargin() + claim.getWidth(); j++) {
				coveredFabric[index] = fabric[i][j];
				index++;
			}
		}
		return coveredFabric;
	}
}
