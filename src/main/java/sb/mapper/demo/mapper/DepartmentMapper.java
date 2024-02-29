package sb.mapper.demo.mapper;

import org.mapstruct.Mapper;
import sb.mapper.demo.dto.DepartmentDTO;
import sb.mapper.demo.entity.Department;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentDTO departmentDTO);
    DepartmentDTO toDTO(Department department);
}
