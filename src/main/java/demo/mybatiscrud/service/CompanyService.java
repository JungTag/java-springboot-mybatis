package demo.mybatiscrud.service;

import demo.mybatiscrud.mapper.CompanyMapper;
import demo.mybatiscrud.mapper.EmployeeMapper;
import demo.mybatiscrud.model.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public List<Company> getAll() {
        List<Company> companyList = companyMapper.getAll();

        if (companyList != null && companyList.size() > 0) {
            for (Company company : companyList) {
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }

        return companyList;
    }

    @Transactional // RuntimeException에서만 작동
    public Company add(Company company) {
        companyMapper.insert(company);
        // add company into legacy system
        if (true) {
            throw new RuntimeException("Legacy Exception");
        }
        return company;
    }
}
