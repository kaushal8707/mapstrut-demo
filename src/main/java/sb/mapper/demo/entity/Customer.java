package sb.mapper.demo.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="country")
    private String country;

    @Column(name="registration_date")
    private LocalDate registrationDate;

    @Column(name="type")
    private String type;
}