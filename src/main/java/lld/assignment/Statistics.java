package lld.assignment;

/**
 * @author author_name (vinay.saini@thoughtspot.com)
 * Hevo Data - Assignment
 */

/**
 * Provide an implementation of the following interface.
 * The implementation has to be thread-safe.
 *
 * Also, please provide your feedback on how to improve this interface
 * We encourage you to write tests to ensure the correctness of the program.
 * Please add comments explaining your choices
 */
public interface Statistics {
    /**
     * The only method which takes events as input.
     * @param n
     */
    void event(int n);
    /**
     * Minimum of all the events consumed
     * @return
     */
    int min();
    /**
     * Maximum of all the events consumed
     * @return
     */
    int max();
    /**
     * Mean of all the events consumed
     * @return
     */
    float mean();
    /**

     * Variance of all the events consumed
     * @return
     */
    float variance();
}