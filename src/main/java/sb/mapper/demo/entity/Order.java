package sb.mapper.demo.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name="order_details")
@ToString
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "description")
    private String description;

    @Column(name = "order_date")
    private LocalDate date;

    @Column(name="status")
    private boolean status;

    @Column(name="quantity")
    private int quantity;
}