package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Enrique Alonso
 */
public class ResourcePathExtractor {

	public static Path openResource(String resourcePath) {
		return new File(ResourcePathExtractor.class.getClassLoader()
				.getResource(resourcePath)
				.getFile()).toPath();
	}

	public static List<String> fileToLinesStream(String resourcePath){
		try (Stream<String> stream = Files.lines(openResource(resourcePath))) {
			return stream.collect(Collectors.toList());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
}
