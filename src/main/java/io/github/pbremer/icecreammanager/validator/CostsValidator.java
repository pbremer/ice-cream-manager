/**
 * 
 */
package io.github.pbremer.icecreammanager.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import io.github.pbremer.icecreammanager.flatfilecontents.CostsFlatFileContainer;

/**
 * @author Patrick Bremer
 */
public class CostsValidator implements Validator {

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> clazz) {
	return clazz.isInstance(CostsFlatFileContainer.class);
    }

    /*
     * (non-Javadoc)
     * @see org.springframework.validation.Validator#validate(java.lang.Object,
     * org.springframework.validation.Errors)
     */
    @Override
    public void validate(Object target, Errors errors) {
	CostsFlatFileContainer arg = (CostsFlatFileContainer) target;

    }

}
