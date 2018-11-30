package org.academiadecodigo.variachis.delta.back_end.exceptions;

import org.academiadecodigo.variachis.delta.back_end.errors.ErrorMessage;

/**
 * Thrown to indicate that the customer was not found
 */
public class CustomerNotFoundException extends IWantToBreakFreeException {

    /**
     * @see IWantToBreakFreeException#IWantToBreakFreeException(String)
     */
    public CustomerNotFoundException() {
        super(ErrorMessage.CUSTOMER_NOT_FOUND);
    }
}
