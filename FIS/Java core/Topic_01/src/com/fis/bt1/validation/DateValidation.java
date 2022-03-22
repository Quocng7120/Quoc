package com.fis.bt1.validation;

public class DateValidation implements IValidation {
    private String format = new String("dd-mm-yyyy");

    @Override
    public boolean validate(String data) {
        return false;
    }
}
