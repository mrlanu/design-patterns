package io.lanu.design_patterns.dynamic_proxy.framework.handlers;

import io.lanu.design_patterns.dynamic_proxy.framework.exceptions.FrameworkException;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {

    private final Object objectToHandle;
    private final CacheableHandler cacheHandler;
    private final TransactionalHandler transactionHandler;

    public ProxyHandler(final Object objectToHandle) {
        this.objectToHandle = objectToHandle;
        this.cacheHandler = new CacheableHandler(objectToHandle);
        this.transactionHandler = new TransactionalHandler(objectToHandle);
    }

    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) {
        if (cacheHandler.isSupported(method)) {
            return cacheHandler.takeResultOrCalculate(method, args, () -> calculateResult(method, args));
        }
        return calculateResult(method, args);
    }

    private Object calculateResult(final Method method, final Object[] args) {
        if (transactionHandler.isSupported(method)) {
            return transactionHandler.executeWithTransaction(() -> invokeMethod(method, args));
        }
        return invokeMethod(method, args);
    }

    private Object invokeMethod(final Method method, final Object[] args) {
        try {
            return method.invoke(objectToHandle, args);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new FrameworkException(e);
        }
    }

}
