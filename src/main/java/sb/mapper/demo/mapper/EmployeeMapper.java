package sb.mapper.demo.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import sb.mapper.demo.dto.EmployeeDTO;
import sb.mapper.demo.entity.Employee;

@Mapper(componentModel = "spring", uses = {DepartmentMapper.class})
public interface EmployeeMapper {
    @Mapping(source = "empId", target = "id")
    @Mapping(source = "empName", target = "name")
    //@Mapping(source="departmentName",target="department.deptName")  // when departmentName is a direct field inside EmployeeDTO
    @Mapping(source = "departmentDTO", target = "department")
    Employee toEntity(EmployeeDTO employeeDTO);

    @Mapping(source = "id", target = "empId")
    @Mapping(source = "name", target = "empName")
    //@Mapping(source="department.deptName",target="departmentName")  // when departmentName is a direct field inside EmployeeDTO
    @Mapping(source = "department", target = "departmentDTO")
    EmployeeDTO toDTO(Employee employee);
}