package business_logic.algorithm;

/**
 * Business interface : IAlgorithmStrategy : Temperature generation algorithm
 *
 * @author Yannis MAHIOU and Benoit LOUVEAU
 */

@FunctionalInterface
public interface IAlgorithmStrategy {
    /**
     * Generate the new temperature following the algorithm
     *
     * @return the new temperature
     */
    int algorithm();

}
