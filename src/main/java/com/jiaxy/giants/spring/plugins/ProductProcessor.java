package com.jiaxy.giants.spring.plugins;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.plugin.core.Plugin;

/**
 *
 * @version : ProductProcessor.java, v 0.1 2021年07月06日 10:20 wutaoyuanxuan Exp $
 */
@Qualifier("productProcessor")
public interface ProductProcessor extends Plugin<ProductType> {

    void process(Product product);

}