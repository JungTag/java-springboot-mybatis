package demo.mybatiscrud.model;

import lombok.Data;

@Data
public class Employee {
    private int id;
    private int company_id;
    private String name;
    private String address;
}
