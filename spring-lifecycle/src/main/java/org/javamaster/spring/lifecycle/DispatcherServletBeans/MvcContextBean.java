package org.javamaster.spring.lifecycle.DispatcherServletBeans;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import javax.annotation.PostConstruct;

/**
 * bean的生命周期, 各个接口方法的执行顺序从上到下
 *
 * @author yudong
 * @date 2020/3/31
 */
@Slf4j
public class MvcContextBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware,
        InitializingBean, DisposableBean, ApplicationContextAware {

    @Override
    public void setBeanName(String name) {
        log.info("setBeanName invoke:{}", name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("setBeanClassLoader invoke:{}", classLoader.getClass().getName());
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("setBeanFactory invoke:{}", beanFactory.getClass().getName());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("setApplicationContext invoke:{},{}", applicationContext.getClass().getName(), applicationContext.getId());
    }

    @PostConstruct
    public void postConstruct() {
        log.info("postConstruct invoke");
    }

    @Override
    public void afterPropertiesSet() {
        log.info("afterPropertiesSet invoke");
    }

    public void initMethod() {
        log.info("initMethod invoke");
    }

    @Override
    public void destroy() {
        log.info("destroy invoke");
    }


    public void destroyMethod() {
        log.info("destroyMethod invoke");
    }

}
