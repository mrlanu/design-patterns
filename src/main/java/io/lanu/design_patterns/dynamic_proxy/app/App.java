package io.lanu.design_patterns.dynamic_proxy.app;

import io.lanu.design_patterns.dynamic_proxy.app.models.Company;
import io.lanu.design_patterns.dynamic_proxy.app.services.CompanyService;
import io.lanu.design_patterns.dynamic_proxy.framework.AppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        final AppContext applicationContext = new AppContext(App.class);
        final CompanyService companyServiceProxy = applicationContext.getBean(CompanyService.class);

        logger.info("======== Transactional ========");
        companyServiceProxy.createCompany(new Company());
        logger.info("===============================");


        logger.info("========== Cacheable ==========");
        final Company company1 = new Company();
        logger.info(companyServiceProxy.generateToken(company1));
        logger.info(companyServiceProxy.generateToken(company1));

        final Company company2 = new Company();
        logger.info(companyServiceProxy.generateToken(company2));
        logger.info("===============================");


        logger.info("============= Scope ===========");
        final CompanyService companyServiceProxy1 = applicationContext.getBean(CompanyService.class);
        final CompanyService companyServiceProxy2 = applicationContext.getBean(CompanyService.class);

        logger.info(String.valueOf(companyServiceProxy1 == companyServiceProxy2));
        logger.info("===============================");
    }
}
