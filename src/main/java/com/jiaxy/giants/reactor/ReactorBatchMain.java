/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2024 All Rights Reserved.
 */
package com.jiaxy.giants.reactor;

import reactor.core.publisher.Flux;

/**
 * @version : ReactorBatchMain.java, v 0.1 2024年11月26日 08:45  Exp $
 */
public class ReactorBatchMain {

    public static void main(String[] args) {
        Flux.concat(Flux.range(1, 3), Flux.range(4, 2), Flux.range(6, 5)).subscribe(e -> System.out.println(e));
    }
}
