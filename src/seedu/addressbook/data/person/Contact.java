package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

public class Contact {

	private boolean isPrivate;
	public String value; 
	
	public Contact(String value, boolean isPrivate,String messageAddressConstrains, String AddressValidationRegex ) throws IllegalValueException{
		this.isPrivate = isPrivate;
		String trimmedAddress = value.trim();
		if (!isValidContact(trimmedAddress,AddressValidationRegex)) {
            throw new IllegalValueException(messageAddressConstrains);
		}
		this.value=value;
	}
		
	public static boolean isValidContact(String test, String AddressValidationRegex) {
	        return test.matches(AddressValidationRegex);
	  }
	@Override
    public String toString() {
        return value;
    }
	
	@Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }
}
