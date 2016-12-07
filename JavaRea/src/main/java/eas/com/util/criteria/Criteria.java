package eas.com.util.criteria;

/**
 * Created by eduardo on 12/3/2016.
 */
public interface Criteria<T> {

    /**
     * @return true if do not exist some param to search, false otherwise
     */
    boolean emptyParam();

    /**
     * @return true if the t object assert the criteria, false otherwise
     */
    boolean assertCriteria(T t);
}
