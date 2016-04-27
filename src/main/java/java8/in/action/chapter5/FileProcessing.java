package java8.in.action.chapter5;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class FileProcessing {

	public long getLines() {
		long uniqueWords = 0;
		try (Stream<String> lines = Files
				.lines(Paths.get(getClass().getResource("/testFile").toURI()),
						Charset.defaultCharset())) {
			uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		}
		return uniqueWords;
	}
}
