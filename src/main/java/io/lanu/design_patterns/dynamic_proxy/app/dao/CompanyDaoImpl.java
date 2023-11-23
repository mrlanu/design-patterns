package io.lanu.design_patterns.dynamic_proxy.app.dao;

import io.lanu.design_patterns.dynamic_proxy.app.models.Company;
import io.lanu.design_patterns.dynamic_proxy.app.services.CompanyServiceImpl;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Component;
import io.lanu.design_patterns.dynamic_proxy.framework.anotations.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class CompanyDaoImpl implements CompanyDao{

    private static final Logger logger = LoggerFactory.getLogger(CompanyServiceImpl.class);
    @Override
    @Transactional
    public void createCompany(Company company) {
        logger.info("DAO:   START - create company");

        logger.info("DAO:   END - create company");
    }

    @Override
    public void updateCompany(Company company) {
        logger.info("DAO:   START - update company");

        logger.info("DAO:   END - update company");
    }
}
