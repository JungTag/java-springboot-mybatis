package demo.mybatiscrud.controller;

import demo.mybatiscrud.mapper.CompanyMapper;
import demo.mybatiscrud.model.Company;
import demo.mybatiscrud.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/company")
public class CompanyController {

    private final CompanyMapper companyMapper;
    private final CompanyService companyService;

    @PostMapping("")
    public Company post(@RequestBody Company company) {
//        companyMapper.insert(company);
        companyService.add(company);
        return company;
    }

    @GetMapping("")
    public List<Company> getAll() {
//        return companyService.getAll();
        return companyMapper.getAll();
    }

    @GetMapping("/{id}")
    public Company getById(@PathVariable("id") int id) {
        return companyMapper.getById(id);
    }
}
