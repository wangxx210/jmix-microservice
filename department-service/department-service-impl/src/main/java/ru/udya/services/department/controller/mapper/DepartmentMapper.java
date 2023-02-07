package ru.udya.services.department.controller.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import ru.udya.services.department.api.model.DepartmentDto;
import ru.udya.services.department.model.Department;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentMapper {

    DepartmentMapper INSTANCE = Mappers.getMapper( DepartmentMapper.class );

    Department departmentDtoToDepartment(DepartmentDto departmentDto);

    DepartmentDto departmentToDepartmentDto(Department department);
}
