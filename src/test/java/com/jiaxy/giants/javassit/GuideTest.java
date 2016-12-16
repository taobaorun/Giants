package com.jiaxy.giants.javassit;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description: <br/>
 * <p/>
 *
 * @Date: 2016/12/16 11:07
 */
public class GuideTest {
    @Test
    public void createClass() throws Exception {
        Guide.createClass();
    }

    @Test
    public void frozen() throws Exception {
        Guide.frozen();
    }

    @Test
    public void defrost() throws Exception {
        Guide.defrost();
    }

    @Test
    public void changeName() throws Exception {
        Guide.changeName("com.jiaxy.javassit.TestSetName");
    }

    @Test
    public void copyClass() throws Exception {
        Guide.copyClass();
    }
}