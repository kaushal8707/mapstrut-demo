package sb.mapper.demo.dto;
import lombok.Data;
@Data
public class OrderDTO {

    private Long id;
    private String orderAmount;
    private String description;
    private String orderDate;
    private String orderStatus;

    private int quantity;    // used for @BeforeMapping
    private float sum;       // used for @AfterMapping
}