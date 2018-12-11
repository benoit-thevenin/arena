package fr.phoenyx.arena.exceptions;


public class BadRequestException extends Exception {

    private static final long serialVersionUID = 1349521763775811908L;

    public BadRequestException(String message) {
        super(message);
    }
}
