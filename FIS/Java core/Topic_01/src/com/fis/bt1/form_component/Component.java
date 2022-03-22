package com.fis.bt1.form_component;

import com.fis.bt1.validation.IValidation;

public class Component {
    private IValidation validation;
    private String data;

    public void setData(String data){}
    public void display(){}

    public void setValidation(IValidation validation){}
    public boolean validate(){return true;}
}
