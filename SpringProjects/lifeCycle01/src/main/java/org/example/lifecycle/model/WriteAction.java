package org.example.lifecycle.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WriteAction implements Action, InitializingBean, DisposableBean, ApplicationContextAware, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
    private String writer;

    public WriteAction() {
        System.out.println("1. 빈의 생성자 실행");
    }

    public void setWriter(String writer) {
        System.out.println("2. setWriter(String writer) 실행");
        this.writer = writer;
    }

    @Override
    public void execute() {
        System.out.println("*. execute() 실행");
        System.out.println("writer : " + writer);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("4. setBeanClassLoader(ClassLoader classLoader) 호출");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("5. setBeanFactory(BeanFactory beanFactory) 호출 : 빈 팩토리 설정");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("3. setBeanName(String name) 호출 : 빈 이름 설정");

        System.out.println("name : " + name);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("11. destroy() 호출 : 종료처리");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("8. afterPropertiesSet() 호출");
        System.out.println("writer : " + writer);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("6. setApplicationContext(ApplicationContext applicationContext) 호출");
    }

    public void init_method(){
        System.out.println("9. 빈의 사용자 초기화 메서드 호출");

    }

    public void destroy_method(){
        System.out.println("12. 빈의 사용자 소멸 메서드 호출");
    }
}
