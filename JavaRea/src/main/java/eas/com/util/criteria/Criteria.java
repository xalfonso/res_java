package eas.com.util.criteria;

/**
 * Created by eduardo on 12/3/2016.
 */
public interface Criteria<T> {
    boolean emptyParam();

    boolean assertCriteria(T t);
}
