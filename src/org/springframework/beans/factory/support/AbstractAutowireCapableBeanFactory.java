package org.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();

    @Override
    protected Object createBean(String name, BeanDefinition beanDefinition) throws BeansException {
        return doCreateBean(name, beanDefinition);
    }

    protected Object doCreateBean(String name, BeanDefinition beanDefinition){
        Object bean = null;
        try{
            bean = createBeanInstance(beanDefinition);
            applyPropertyValues(name, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }

        addSingleton(name, bean);
        return bean;
    }

    protected Object createBeanInstance(BeanDefinition beanDefinition){
        return getInstantiationStrategy().instantiate(beanDefinition);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition){
        try{
            for(PropertyValue propertyValue : beanDefinition.getPropertyValues().getPropertyValues()){
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception ex) {
            throw new BeansException("Error setting property values for bean: " + beanName, ex);
        }
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy = instantiationStrategy;
    }

}
