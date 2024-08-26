package com.fastcampus.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConfigTest {

    public static void main(String[] args) {
        // Spring 애플리케이션 컨텍스트를 로드합니다.
        ApplicationContext context = null;
        try {
            context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/root-context.xml");
            System.out.println("Application context loaded successfully.");
        } catch (Exception e) {
            System.out.println("Failed to load application context.");
            e.printStackTrace();
            return;
        }

        // 특정 빈이 로드되었는지 확인합니다.
        checkBean(context, "dataSource");
        checkBean(context, "sqlSessionFactory");
        checkBean(context, "transactionManager");
        checkBean(context, "postDaoImpl"); // 예를 들어 PostDaoImpl 빈 확인
    }

    private static void checkBean(ApplicationContext context, String beanName) {
        try {
            Object bean = context.getBean(beanName);
            if (bean != null) {
                System.out.println(beanName + " bean loaded successfully: " + bean.getClass().getName());
            } else {
                System.out.println(beanName + " bean is not loaded.");
            }
        } catch (Exception e) {
            System.out.println("Failed to load " + beanName + " bean: " + e.getMessage());
        }
    }
}
