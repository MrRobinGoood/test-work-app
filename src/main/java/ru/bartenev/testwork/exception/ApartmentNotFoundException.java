package ru.bartenev.testwork.exception;

public class ApartmentNotFoundException extends ApartmentException{
    public ApartmentNotFoundException(String message) {
        super(message);
    }
}
