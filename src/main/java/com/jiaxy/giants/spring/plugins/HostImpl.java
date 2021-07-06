package com.jiaxy.giants.spring.plugins;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.util.Assert;

import java.util.List;

public class HostImpl {

    private List<MyPluginInterface> plugins;

    @Autowired
    @Qualifier("productProcessor")
    public PluginRegistry<ProductProcessor, ProductType> productProcessors;

    public HostImpl(List<MyPluginInterface> plugins) {
        Assert.notNull(plugins);
        this.plugins = plugins;
    }

    public HostImpl() {
    }

    /**
     * Some business method actually working with the given plugins.
     */
    public void someBusinessMethod() {
        for (MyPluginInterface plugin : plugins) {
            plugin.bar();
        }
    }

    public void someBusinessPluginMethod(Product product) {
        for (ProductProcessor productProcessor : productProcessors.getPluginsFor(product.getType())) {
            productProcessor.process(product);
        }

    }

    public List<MyPluginInterface> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<MyPluginInterface> plugins) {
        this.plugins = plugins;
    }
}