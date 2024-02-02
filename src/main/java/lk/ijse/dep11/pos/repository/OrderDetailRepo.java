package lk.ijse.dep11.pos.repository;

import lk.ijse.dep11.pos.entity.Order;
import lk.ijse.dep11.pos.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer> {
}
