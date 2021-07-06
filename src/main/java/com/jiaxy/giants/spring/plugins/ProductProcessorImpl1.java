package com.jiaxy.giants.spring.plugins;

import org.springframework.stereotype.Component;

/**
 *
 * @version : ProductProcessorImpl1.java, v 0.1 2021年07月06日 10:42 wutaoyuanxuan Exp $
 */
@Component
public class ProductProcessorImpl1 implements ProductProcessor {

    @Override
    public void process(Product product) {
        System.out.println(product.getType());
    }

    @Override
    public boolean supports(ProductType delimiter) {
        return delimiter == ProductType.SOFTWARE;
    }
}