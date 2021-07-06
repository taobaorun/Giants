
package com.jiaxy.giants.spring.plugins;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBootstrap {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        HostImpl host = context.getBean(HostImpl.class);
        host.someBusinessMethod();
        //plugin contract
        host.someBusinessPluginMethod(new Product(ProductType.SOFTWARE));
        host.someBusinessPluginMethod(new Product(ProductType.HARDWARE));

    }
}