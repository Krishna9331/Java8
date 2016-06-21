package java8.in.action.chapter7;

import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 6/21/2016.
 */
public class WordCounterTest {

	private static final String LINES =
			" Nel mezzo del cammin di nostra vita mi ritrovai in una selva oscura ché la " + "dritta via era "
					+ "smarrita ";
	private WordCounter counter;

	@Before public void setUp() {
		counter = new WordCounter(0, false);
	}

	@Test public void testCountWordIteratively() {
		assertEquals(19, counter.countWordIteratively(LINES));
	}

	@Test public void testCountWords() {
		Stream<Character> stream = IntStream.range(0, LINES.length()).mapToObj(LINES::charAt);
		assertEquals(19, counter.countWords(stream));
	}

	@Test public void testCountWordsParallel() {
		Stream<Character> stream = IntStream.range(0, LINES.length()).mapToObj(LINES::charAt);
		assertTrue(counter.countWordsParallel(stream) > 19);
	}

	@Test public void testCountWordUsingCustomSpliterator() {
		assertEquals(19, counter.countWordUsingCustomSpliterator(LINES));
	}

}
