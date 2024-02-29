package sb.mapper.demo.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sb.mapper.demo.dto.EmployeeDetailsDTO;
import sb.mapper.demo.entity.Department;
import sb.mapper.demo.entity.Employee;
// while we are fetching data from multiple tables and want to return data as a single DTO as a responseDTO
@Mapper(componentModel = "spring")
public interface EmployeeDetailsMapper {

    @Mapping(source = "employee.id", target = "empId")
    @Mapping(source = "employee.name", target = "empName")
    @Mapping(source = "department.id", target = "deptId")
    @Mapping(source = "department.deptName", target = "deptName")
    EmployeeDetailsDTO toEmployeeDetailsDTO(Employee employee, Department department);
}
