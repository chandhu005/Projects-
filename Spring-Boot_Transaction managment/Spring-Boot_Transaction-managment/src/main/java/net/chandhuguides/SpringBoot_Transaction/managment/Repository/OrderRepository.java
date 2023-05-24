package net.chandhuguides.SpringBoot_Transaction.managment.Repository;

import net.chandhuguides.SpringBoot_Transaction.managment.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
