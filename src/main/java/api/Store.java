package api;

public interface Store<T> {

    void addGood(T good);
    T getGoodById(String id);
    T updateGood(String id);
    T deleteGood(String id);

}
