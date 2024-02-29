package sb.mapper.demo.dto;
import lombok.Data;

@Data
public class EmployeeDTO {

    private Long empId;
    private String empName;
    private String email;
    private float salary;
    //private String departmentName;  //  How we can pass child elements directly and map from dto to entity using mapStruts ...this case we need to test it separately
    private DepartmentDTO departmentDTO;
}