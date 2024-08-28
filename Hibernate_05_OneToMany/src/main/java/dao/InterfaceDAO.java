package dao;

import java.util.List;

public interface InterfaceDAO<T, ID> {
    public List<T> selectAll();
    public T selectById(ID id);
    public boolean insert(T t);
    public boolean update(T t);
    public boolean delete(T t);
}
