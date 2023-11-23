package io.lanu.design_patterns.dynamic_proxy.app.dao;

import io.lanu.design_patterns.dynamic_proxy.app.models.Company;

public interface CompanyDao {
    void createCompany(Company company);
    void updateCompany(Company company);
}
