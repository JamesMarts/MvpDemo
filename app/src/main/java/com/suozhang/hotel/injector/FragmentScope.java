package com.suozhang.hotel.injector;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by LIJUWEN on 2017/3/20.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface FragmentScope {

}
