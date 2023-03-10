package top.hopestation.springframework.beans.factory.support;

import top.hopestation.springframework.beans.BeansException;
import top.hopestation.springframework.beans.factory.BeanFactory;
import top.hopestation.springframework.beans.factory.config.BeanDefinition;

/***
 * 抽象Bean工厂
 * - 继承 DefaultSingletonBeanRegistry ：具备了注册Bean的能力，存放在singletonObjects中
 * - 实现 BeanFactory ：有了获取bean的接口
 * - getBeanDefinition ：获取Bean定义
 * - createBean ：创造Bean
 *
 * 抽象类 AbstractBeanFactory 负责生产Bean
 * 继承的 普通类 DefaultSingletonBeanRegistry 负责管理单例Bean注册表
 * 这样分层的好处在于按功能解耦，一个类负责生产、一个类负责管理Bean实例
 *
 *
 */
public abstract class AbstractBeanFactory extends  DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) {
        return doGetBean(beanName,null);
    }

    @Override
    public Object getBean(String beanName,Object... args) {
        return doGetBean(beanName,args);
    }

    protected <T> T doGetBean(final String name,final Object[] args){
        Object bean = getSingleton(name);
        if(bean!=null){
            return (T)bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return (T)createBean(name,beanDefinition,args);
    }


    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args) throws BeansException;


}
