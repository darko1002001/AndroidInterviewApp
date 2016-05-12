package termine24.secondinterviewtest.app.model;


import android.os.Parcel;
import android.support.annotation.NonNull;

/**
 * Created by shanemurphy on 23/12/2015.
 * Copyright (c) 2015 Shore. All rights reserved.
 */
public class ContactTest extends ParcelableTest {

    public static final String PHONE_NUMBER = "+32123432";
    public static final String EMAIL = "hello@email.com";
    public static final String NAME = "dummyName";

    @NonNull
    private Contact getFullContact() {
        return new Contact(NAME, EMAIL, PHONE_NUMBER);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testItSpecifiesARequestCodeConstant() {
        assertEquals(Contact.REQUEST_EDIT_CONTACT, 10001);
    }

    public void testItSpecifiesTheCorrectExtraKey() {
        assertEquals(Contact.EXTRA_CONTACT, "Extra_Contact");
    }

    public void testItHasAnEmptyConstructor() {
        Contact c = new Contact(); // this will throw an error in compile if it doesn't exit but good enough
        assertNotNull(c);
    }

    public void testIfContactCreationWorksWithParametersInConstructor() {
        Contact contact = getFullContact();
        assertEquals(contact.getName(), NAME);
        assertEquals(contact.getEmail(), EMAIL);
        assertEquals(contact.getMobile(), PHONE_NUMBER);
    }

    public void testNameSetterAndGetter() {
        Contact c = new Contact();
        c.setName(NAME);
        assertEquals(c.getName(), NAME);
    }

    public void testEmailGetterAndSetter() {
        Contact c = new Contact();
        c.setEmail(EMAIL);
        assertEquals(c.getEmail(), EMAIL);
    }

    public void testMobileSetterAndGetter() {
        Contact c = new Contact();
        c.setMobile(PHONE_NUMBER);
        assertEquals(c.getMobile(), PHONE_NUMBER);
    }

    public void testItCannotMakeAPhoneCallIfMobileIsNotSet() {
        Contact c = new Contact();
        assertFalse("Cannot make a call if mobile is not set", c.canMakePhoneCall());
    }

    public void testItCannotMakAPhoneCallIfMobileIsBlank() {
        Contact c = new Contact();
        c.setMobile("");
        assertFalse("Cannot make a call if mobile is blank",c.canMakePhoneCall());
    }

    public void testItCanMakeAPhoneCallIfMobileIsSet() {
        Contact c = new Contact();
        c.setMobile(PHONE_NUMBER);
        assertTrue("Can make a phone call if mobile is set", c.canMakePhoneCall());
    }

    public void testItCannotMessageIfEmailIsNotSet() {
        Contact c = new Contact();
        assertFalse("Cannot message if email is not set", c.canMessage());
    }

    public void testItCannotMessageIfEmailIsBlank() {
        Contact c = new Contact();
        c.setEmail("");
        assertFalse("Cannot message with a blank email", c.canMessage());
    }

    public void testItCanMessageIfEmailIsSet() {
        Contact c = new Contact();
        c.setEmail(EMAIL);
        assertTrue("Can message with a set email", c.canMessage());
    }

    public void testParcelable() {
        Contact originalContact = getFullContact();
        Parcel p = createParcel(originalContact);
        Contact fromParcel = Contact.CREATOR.createFromParcel(p);
        assertNotNull("Returned object exists", fromParcel);
        assertEquals("Name is read properly", fromParcel.getName(), NAME);
        assertEquals("Email is read properly", fromParcel.getEmail(), EMAIL);
        assertEquals("Mobile is read properly", fromParcel.getMobile(), PHONE_NUMBER);
    }


}
