package com.integrallis.ec.service;

import javax.ejb.Local;

/**
 * Interface for the hello world display.
 * 
 * @author Joseph F Nusairat
 *
 */
@Local
public interface HelloWorld {

    String createHello();
    
    void destroy();
}
