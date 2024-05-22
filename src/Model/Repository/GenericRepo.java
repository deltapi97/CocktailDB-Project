package Model.Repository;

import java.io.IOException;
import java.util.List;


public abstract class GenericRepo<T> implements IGeneric<T> {


    private List<T> entities;


    public GenericRepo(List<T> entities) {

        this.entities = entities;
    }


    @Override
    public void add(T entity) throws IOException {
        entities.add(entity);
    }

    @Override
    public T get(String id) {
        return entities.get(Integer.parseInt(id));
    }


    @Override
    public void delete(String id) {
        T entity = get(id);
        entities.remove(entity);
    }

    @Override
    public List<T> getAll() {
        return entities;
    }

    @Override
    public void update(T entity1, T entity2) {

        entities.remove(entity1);
        entities.add(entity2);
    }

}
