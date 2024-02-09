package exercices;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer> {
	private int debut;
	private int fin;
	private int pas;

	public Range(int debut, int fin, int pas) {
		this.debut = debut;
		this.fin = fin;
		this.pas = pas;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int courant = debut;

			@Override
			public boolean hasNext() {
				return courant < fin;
			}

			@Override
			public Integer next() {
				if (hasNext()) {
					int res = courant;
					courant += pas;
					return res;
				} else {
					throw new NoSuchElementException();
				}
			}
		};
	}

	public static Range range(int start, int end, int step) {
		if (step > 0) {
			return new Range(start, end, step);
		} else {
			throw new IllegalArgumentException("Le pas doit être strictement positif !");
		}
	}

	public static Range range(int start, int end) {
		return range(start, end, 1);
	}

	public static Range range(int end) {
		return range(0, end, 1);
	}
}
