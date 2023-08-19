package kz.bitlab.spring_task.springtask1.repositories;

import kz.bitlab.spring_task.springtask1.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

// Поиск по заданным параметрам с использованием JPQL
    @Query("select  i from Item i "
    + "where i.name ilike concat('%', :search, '%') "
    + "or i.surname ilike concat('%', :search, '%') "
          + " or i.exam = cast(:search as double ) "
    )

    List<Item> search(String search);

    // Поиск по name
//    List <Item> findAllByName(String name);
}
