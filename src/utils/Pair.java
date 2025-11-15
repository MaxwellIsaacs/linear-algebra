/**
 * A generic immutable pair container for holding two related values.
 *
 * @param <U> the type of the first element
 * @param <V> the type of the second element
 */
public class Pair <U, V> {
  private final U first;
  private final V second;

  /**
   * Constructs a new pair with the specified values.
   *
   * @param first the first element
   * @param second the second element
   */
  public Pair (U first, V second) {
    this.first = first;
    this.second = second;
  }

  /**
   * Returns the first element of this pair.
   *
   * @return the first element
   */
  public U getFirst () {
    return first;
  }

  /**
   * Returns the second element of this pair.
   *
   * @return the second element
   */
  public V getSecond () {
    return second;
  }

}
