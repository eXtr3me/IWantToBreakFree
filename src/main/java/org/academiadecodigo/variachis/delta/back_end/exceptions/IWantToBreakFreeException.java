package org.academiadecodigo.variachis.delta.back_end.exceptions;

/**
 * A generic iwanttobreakfree exception to be used as base for concrete types of exceptions
 *
 * @see Exception
 */
public class IWantToBreakFreeException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public IWantToBreakFreeException(String message) {
        super(message);
    }
}
