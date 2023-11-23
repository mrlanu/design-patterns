package io.lanu.design_patterns.dynamic_proxy.app.services;

import io.lanu.design_patterns.dynamic_proxy.app.dao.CompanyDao;
import io.lanu.design_patterns.dynamic_proxy.app.models.Company;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Autowired;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Cacheable;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Component;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

@Component
public class CompanyServiceImpl implements CompanyService{

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
    private final CompanyDao companyDao;

    @Autowired
    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void createCompany(Company company) {
        logger.info("SERVICE:   START - create company");
//         companyDao.createCompany(company);
        createWithTransaction(company);
        logger.info("SERVICE:   END - create company");
    }

    @Transactional
    public void createWithTransaction(Company company) {
        logger.info("SERVICE:   START - createWithTransaction");
        companyDao.createCompany(company);
        logger.info("SERVICE:   END - createWithTransaction");
    }

    @Override
    @Transactional
    public void updateCompany(Company company) {
        logger.info("SERVICE:   START - update company");
        companyDao.createCompany(company);
        logger.info("SERVICE:   END - update company");
    }

    @Override
    @Cacheable
    public String generateToken(Company company) {
        return UUID.randomUUID().toString();
    }
}
