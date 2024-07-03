package cristian.dio.api.repository;

import cristian.dio.api.entity.ToDoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoListRepository extends JpaRepository<ToDoList,Long> {
    public boolean existsById(Long id);
}
