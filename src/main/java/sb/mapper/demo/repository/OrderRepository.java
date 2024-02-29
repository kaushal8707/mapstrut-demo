package sb.mapper.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.mapper.demo.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
