package java8.in.action.chapter7;

import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by mishrk3 on 6/3/2016.
 */
public class WordCounter {

	//The iterative approach
	public int countWordIteratively(String s) {
		int counter = 0;
		boolean lastSpace = true;
		for (char c : s.toCharArray()) {
			if (Character.isWhitespace(c)) {
				lastSpace = true;
			} else {
				if (lastSpace) {
					counter++;
				}
				lastSpace = false;
			}
		}
		return counter;
	}

	//The functional approach

	private final int count;
	private final boolean isSpace;

	public WordCounter(int count, boolean isSpace) {
		this.count = count;
		this.isSpace = isSpace;
	}

	public WordCounter accumulate(Character c) {
		if (Character.isWhitespace(c)) {
			return isSpace ? this : new WordCounter(count, true);
		} else {
			return isSpace ? new WordCounter(count + 1, false) : this;
		}
	}

	public WordCounter combine(WordCounter wordCounter) {
		return new WordCounter(count + wordCounter.count, wordCounter.isSpace);
	}

	public int getCount() {
		return count;
	}

	public int countWords(Stream<Character> stream) {
		WordCounter wordCounter = stream
				.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCount();
	}

	/**
	 * WRONG
	 *
	 * @param stream character stream of a line.
	 * @return number of word in the line
	 * The below method always return value more than 19. Because the
	 * original String is split at arbitrary positions, sometimes a word is divided in two and then
	 * counted twice. In general, this demonstrates that going from a sequential stream to a parallel
	 * one can lead to a wrong result if this result may be affected by the position where the stream is
	 * split.
	 * <br/>
	 * <br/>
	 * The solution consists of ensuring that the String isn’t split at a
	 * random position but only at the end of a word. To do this, we’ll have to implement a Spliterator
	 */
	public int countWordsParallel(Stream<Character> stream) {
		WordCounter wordCounter = stream.parallel()
				.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCount();
	}

	public int countWordUsingCustomSpliterator(String line) {
		Spliterator<Character> spliterator = new WordCounterCustomSpliterator(line);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		WordCounter wordCounter = stream.parallel()
				.reduce(new WordCounter(0, true), WordCounter::accumulate, WordCounter::combine);
		return wordCounter.getCount();
	}
}
