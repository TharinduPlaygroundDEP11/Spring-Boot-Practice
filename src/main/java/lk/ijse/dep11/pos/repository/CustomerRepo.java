package lk.ijse.dep11.pos.repository;

import lk.ijse.dep11.pos.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
    public List<Customer> findAllByActiveStatus(boolean status);
}
