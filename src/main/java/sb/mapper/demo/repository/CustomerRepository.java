package sb.mapper.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.mapper.demo.entity.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{

}