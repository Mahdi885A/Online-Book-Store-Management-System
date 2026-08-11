package ir.maktabsharif.repository;

import java.util.Optional;

public interface GenericRepository<T> {

    Long save(T t);

    Optional<T> findById(Long id);

    boolean update(T t);

    boolean delete(Long id);

}
