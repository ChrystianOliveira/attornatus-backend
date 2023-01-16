package br.com.attornatusbackend.controller.exception;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Integer status, String msg) {
        super(status, msg);
        // TODO Auto-generated constructor stub
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldName, String messagem) {
        errors.add(new FieldMessage(fieldName, messagem));
    }

}
