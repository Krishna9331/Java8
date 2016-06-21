package java8.in.action.chapter7;

/**
 * Created by mishrk3 on 6/3/2016.
 */

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Spliterators are used to traverse the elements of a source, but they’re also
 * designed to do this in parallel.
 * <pre>
 * {@code
 * public interface Spliterator<T> {
 * boolean tryAdvance(Consumer<? super T> action);
 * <pre>
 *                 sequentially consume the elements of the Spliterator one by one,
 * 	               returning true if there are still other elements to be traversed.
 * </pre
 * Spliterator<T> trySplit();
 *  <pre>
 *                 trySplit method is more specific to the Spliterator interface because it’s used
 *                 to partition off some of its elements to a second Spliterator (the one returned by the method),
 *                 allowing the two to be processed in parallel.
 * </pre
 * long estimateSize();
 * <pre>
 *                 Spliterator may also provide an estimation of the
 *                 number of the elements remaining to be traversed via its estimateSize method, because even an
 *                 inaccurate but quick-to-compute value can be useful to split the structure more or less evenly.
 * </pre>
 * int characteristics();
 * <pre>
 *     	returns an int encoding the set of characteristics of the Spliterator itself. The Spliterator clients can use
 * 		these characteristics to better control and optimize its usage.e.g: ORDERED, DISTINCT, SORTED, SIZED, NONNULL,
 * 		IMMUTABLE, CONCURRENT, SUBSIZED.
 * </pre>
 * }
 * }
 * </pre>
 */
public class WordCounterCustomSpliterator implements Spliterator<Character> {
	private final String string;
	private int currentChar;

	public WordCounterCustomSpliterator(String string) {
		this.string = string;
	}

	/**
	 * @param action Consumer with the Character in the String
	 * @return true if the new cursor position is less than the total String length.
	 * <br/>
	 * <br/>
	 * The tryAdvance method feeds the Consumer with the Character in the String at the current index
	 * position and increments this position. The Consumer passed as argument is an internal Java class
	 * forwarding the consumed Character to the set of functions that have to be applied to it while
	 * traversing the stream, which in this case is only a reducing function, namely, the accumulate method
	 * of the WordCounter class. The tryAdvance method returns true if the new cursor position is less
	 * than the total String length and there are further Characters to be iterated.
	 */
	@Override public boolean tryAdvance(Consumer<? super Character> action) {
		//consume the current character
		action.accept(string.charAt(currentChar++));
		//return true if there is still some character to be consumed
		return currentChar < string.length();
	}

	/**
	 * @return new spliterator if string can be split further.
	 * <br/>
	 * <br/>
	 * The trySplit method is the most important one in a Spliterator because it’s the one defining the
	 * logic used to split the data structure to be iterated.
	 */
	@Override public Spliterator<Character> trySplit() {
		int currentSize = string.length() - currentChar;
		/**
		 * return null to signal that string is too small to split further and can be processed sequentially.
		 */
		if (currentSize < 10) {
			return null;
		}
		//set the candidate's split position to half of the left string to be parsed.
		for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
			//advance the split position until white space is not found.
			if (Character.isWhitespace(string.charAt(splitPos))) {
				//create new spliterator using current char to split position.
				Spliterator<Character> spliterator = new WordCounterCustomSpliterator(
						string.substring(currentChar, splitPos));
				//set start position to split position
				currentChar = splitPos;
				return spliterator;
			}
		}
		return null;
	}

	@Override public long estimateSize() {
		return string.length() - currentChar;
	}

	/**
	 * @return the characteristic method signals to the framework that this Spliterator is ORDERED
	 * (the order is just the sequence of Characters in the String), SIZED (the value returned by the
	 * estimatedSize method is exact), SUBSIZED (the other Spliterators created by the trySplit
	 * method also have an exact size), NONNULL (there can be no null Characters in the String), and
	 * IMMUTABLE (no further Characters can be added while parsing the String because the String
	 * itself is an immutable class).
	 */
	@Override public int characteristics() {
		return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
	}
}
