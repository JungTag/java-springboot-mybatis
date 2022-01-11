package demo.mybatiscrud.controller;

import demo.mybatiscrud.mapper.EmployeeMapper;
import demo.mybatiscrud.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @PostMapping("")
    public Employee post(@RequestBody Employee employee) {
        employeeMapper.insert(employee);
        return employee;
    }

    @GetMapping("")
    public List<Employee> getAll() {
        return employeeMapper.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") int id) {
        return employeeMapper.getById(id);
    }
}
