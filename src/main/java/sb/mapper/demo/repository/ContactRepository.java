package sb.mapper.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.mapper.demo.entity.Contact;

@Repository
public interface ContactRepository  extends JpaRepository<Contact, Long>{

}