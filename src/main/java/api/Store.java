package api;

public interface Store<T> {

    void addGood(T good);
    T getGoodById(String id);
    T updateGood(String id);
    T deleteGood(String id);

    /**
     *  TODO: remove this method.
     *  This method was added just for demonstration
     *  of using comparator for order data by specified characteristic
     */
    void sortById(String id);

}
