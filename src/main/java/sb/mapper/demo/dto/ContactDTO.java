package sb.mapper.demo.dto;
import lombok.Data;

@Data
public class ContactDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
}