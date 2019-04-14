package unittest.repository;

public interface Repository<T> {
    void save(T object);
    T load();

}
