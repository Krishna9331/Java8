package java8.in.action.chapter5;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class FileProcessingTest {

	private FileProcessing fp = new FileProcessing();

	@Test public void testGetLines() {
		assertEquals(12, fp.getLines());
	}
}
