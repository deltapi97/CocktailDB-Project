package Model.Repository;

import java.io.IOException;
import java.util.List;

public interface IGeneric<T> {


    void add(T entity) throws IOException;

    T get(String id);

    void delete(String id);

    List<T> getAll();

    void update(T entity1, T entity2);
}
