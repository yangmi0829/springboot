package com.example.demo.validator;

import java.lang.annotation.*;

/**
 * Created by ym on 2018/4/17 0017.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
public @interface FlagValidator {
}
