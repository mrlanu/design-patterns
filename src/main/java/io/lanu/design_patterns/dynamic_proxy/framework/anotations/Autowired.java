package io.lanu.design_patterns.dynamic_proxy.framework.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
}
