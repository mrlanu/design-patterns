package io.lanu.design_patterns.dynamic_proxy.app.services;

import io.lanu.design_patterns.dynamic_proxy.app.models.Company;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Cacheable;

public interface CompanyService {

    void createCompany(Company company);
    void updateCompany(Company company);

    @Cacheable
    String generateToken(Company company);
}
