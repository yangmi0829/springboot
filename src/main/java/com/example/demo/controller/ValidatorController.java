package com.example.demo.controller;

import com.example.demo.entity.ValidatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * Created by ym on 2018/4/17 0017.
 */
@Controller
public class ValidatorController {
    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/validator")
    @ResponseBody
    public String validator( @Valid ValidatorEntity validatorEntity,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuffer sb = new StringBuffer();
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Locale locale = LocaleContextHolder.getLocale();
            for (FieldError fieldError:fieldErrors) {
                String errorMsg = messageSource.getMessage(fieldError, locale);
                sb.append(fieldError.getField()+":"+errorMsg).append(System.lineSeparator());
            }
            return sb.toString();
        }
        return "验证通过";
    }
}
