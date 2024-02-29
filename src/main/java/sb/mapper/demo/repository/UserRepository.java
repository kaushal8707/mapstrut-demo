package sb.mapper.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sb.mapper.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}