package org.academiadecodigo.variachis.delta.back_end.exceptions;

import org.academiadecodigo.variachis.delta.back_end.errors.ErrorMessage;

/**
 * Thrown to indicate that an association still exists
 */
public class AssociationExistsException extends IWantToBreakFreeException {

    /**
     * @see IWantToBreakFreeException#IWantToBreakFreeException(String)
     */
    public AssociationExistsException() {
        super(ErrorMessage.ASSOCIATION_EXISTS);
    }
}
