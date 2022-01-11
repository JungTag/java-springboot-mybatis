package demo.mybatiscrud.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Company {
    private int id;
    private String name;
    private String address;
    private List<Employee> employeeList;
}
