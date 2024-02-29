package sb.mapper.demo.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="contact")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="phone_no")
    private String phoneNo;
}