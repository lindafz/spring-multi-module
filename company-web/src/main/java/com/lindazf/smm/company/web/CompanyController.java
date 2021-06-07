package com.lindazf.smm.company.web;

import com.lindazf.smm.company.data.domain.Company;
import com.lindazf.smm.company.data.domain.CompanyUser;
import com.lindazf.smm.company.data.exception.CompanyExceptionDetails;
import com.lindazf.smm.company.data.service.CompanyService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api", produces = "application/json")
@Slf4j
public class CompanyController extends BaseController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation("Get company list")
    public List<Company> getCompanyList() {
        return companyService.getCompanyList();
    }

    @GetMapping("/company-users")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ApiOperation("Get company user list")
    public List<CompanyUser> getCompanyUserList() {
        return companyService.getCompanyUserList();
    }

    @PostMapping("/company")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Create company")
    public Company createCompany(@ApiParam(name = "Company create request", value = "The request body is a JSON value representing the company information", required = true) @RequestBody Company company)
            throws CompanyExceptionDetails {
        return companyService.createCompany(company);
    }

    @PutMapping("/company")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Update company")
    public Company updateCompany(@ApiParam(name = "Edit company", value = "The request body is a JSON value representing the company information", required = true) @RequestBody Company company)
            throws CompanyExceptionDetails {
        return companyService.updateCompany(company);
    }

    @PostMapping("/company-user")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CompanyUser createCompanyUser(CompanyUser user) throws CompanyExceptionDetails {
        return companyService.createCompanyUser(user);
    }

    @PutMapping("/company-user")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CompanyUser updateUser(CompanyUser user) throws CompanyExceptionDetails {
        return companyService.updateUser(user);
    }

    @GetMapping("/company")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Company findCompanyById(Long companyId) throws CompanyExceptionDetails {
        return companyService.findCompanyById(companyId);
    }

    @GetMapping("/company-user")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CompanyUser findCompanyUserById(Long userId) throws CompanyExceptionDetails {
        return companyService.findCompanyUserById(userId);
    }

    @GetMapping("/company-name")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Company findCompanyByName(String companyName) throws CompanyExceptionDetails {
        return companyService.findCompanyByName(companyName);
    }

}
