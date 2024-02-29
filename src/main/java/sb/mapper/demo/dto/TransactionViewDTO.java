package sb.mapper.demo.dto;
import lombok.Data;

@Data
public class TransactionViewDTO {

    private String transactionId;

    private PaymentViewType paymentViewType;
}