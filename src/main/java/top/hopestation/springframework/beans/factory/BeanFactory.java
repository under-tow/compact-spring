package top.hopestation.springframework.beans.factory;

import top.hopestation.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args) throws BeansException;

}
