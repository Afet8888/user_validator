package az.itstep.azjava.testapp.service.impl;

import az.itstep.azjava.testapp.dao.DepartmentRepository;
import az.itstep.azjava.testapp.model.Department;
import az.itstep.azjava.testapp.model.dto.DepartmentDTO;
import az.itstep.azjava.testapp.service.DepartmentService;
import az.itstep.azjava.testapp.service.dto.DepartmentDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDtoService departmentDtoService;

    private DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        if(Objects.isNull(department)
                || Objects.nonNull(department.getId()))
            return null;
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department) {
        if(Objects.isNull(department)
                || Objects.isNull(department.getId()))
            return null;
        return departmentRepository.save(department);
    }

    @Override
    public void delete(Integer id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentDTO findById(Integer id) {
        return departmentRepository.findById(id)
                .map(departmentDtoService::convertToDto)
                .orElse(null);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        return null;
    }

    @Autowired
    public void setDepartmentDtoService(DepartmentDtoService departmentDtoService) {
        this.departmentDtoService = departmentDtoService;
    }

    @Autowired
    public void setDepartmentRepository(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
}
