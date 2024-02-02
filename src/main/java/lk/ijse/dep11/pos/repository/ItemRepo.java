package lk.ijse.dep11.pos.repository;

import lk.ijse.dep11.pos.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {
    List<Item> findAllByBalanceQtyEqualsAndActiveStatusEquals(double qty, boolean status);

    Page<Item> findAllByActiveStatusEquals(boolean activeStatus, Pageable pageable);

    long countAllByActiveStatusEquals(boolean activeStatus);
}
