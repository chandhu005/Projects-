package net.chandhuguides.SpringBoot_Transaction.managment.Repository;

import net.chandhuguides.SpringBoot_Transaction.managment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
