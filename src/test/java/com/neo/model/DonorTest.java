package com.neo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class DonorTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Donor#Donor()}
     *   <li>{@link Donor#setAddress(Address)}
     *   <li>{@link Donor#setDonorAmount(Long)}
     *   <li>{@link Donor#setDonorContact(String)}
     *   <li>{@link Donor#setDonorDOB(String)}
     *   <li>{@link Donor#setDonorGender(String)}
     *   <li>{@link Donor#setDonorId(Long)}
     *   <li>{@link Donor#setDonorName(String)}
     *   <li>{@link Donor#setDonorPAN(String)}
     *   <li>{@link Donor#setLogin(Login)}
     *   <li>{@link Donor#getAddress()}
     *   <li>{@link Donor#getDonorAmount()}
     *   <li>{@link Donor#getDonorContact()}
     *   <li>{@link Donor#getDonorDOB()}
     *   <li>{@link Donor#getDonorGender()}
     *   <li>{@link Donor#getDonorId()}
     *   <li>{@link Donor#getDonorName()}
     *   <li>{@link Donor#getDonorPAN()}
     *   <li>{@link Donor#getLogin()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Donor actualDonor = new Donor();
        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");
        actualDonor.setAddress(address);
        actualDonor.setDonorAmount(1L);
        actualDonor.setDonorContact("Donor Contact");
        actualDonor.setDonorDOB("Donor DOB");
        actualDonor.setDonorGender("Donor Gender");
        actualDonor.setDonorId(123L);
        actualDonor.setDonorName("Donor Name");
        actualDonor.setDonorPAN("Donor PAN");
        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");
        actualDonor.setLogin(login);
        assertSame(address, actualDonor.getAddress());
        assertEquals(1L, actualDonor.getDonorAmount().longValue());
        assertEquals("Donor Contact", actualDonor.getDonorContact());
        assertEquals("Donor DOB", actualDonor.getDonorDOB());
        assertEquals("Donor Gender", actualDonor.getDonorGender());
        assertEquals(123L, actualDonor.getDonorId().longValue());
        assertEquals("Donor Name", actualDonor.getDonorName());
        assertEquals("Donor PAN", actualDonor.getDonorPAN());
        assertSame(login, actualDonor.getLogin());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Donor#Donor(Long, String, String, String, String, String, Long, Login, Address)}
     *   <li>{@link Donor#setAddress(Address)}
     *   <li>{@link Donor#setDonorAmount(Long)}
     *   <li>{@link Donor#setDonorContact(String)}
     *   <li>{@link Donor#setDonorDOB(String)}
     *   <li>{@link Donor#setDonorGender(String)}
     *   <li>{@link Donor#setDonorId(Long)}
     *   <li>{@link Donor#setDonorName(String)}
     *   <li>{@link Donor#setDonorPAN(String)}
     *   <li>{@link Donor#setLogin(Login)}
     *   <li>{@link Donor#getAddress()}
     *   <li>{@link Donor#getDonorAmount()}
     *   <li>{@link Donor#getDonorContact()}
     *   <li>{@link Donor#getDonorDOB()}
     *   <li>{@link Donor#getDonorGender()}
     *   <li>{@link Donor#getDonorId()}
     *   <li>{@link Donor#getDonorName()}
     *   <li>{@link Donor#getDonorPAN()}
     *   <li>{@link Donor#getLogin()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Login login = new Login();
        login.setLoginId(123L);
        login.setLoginPassword("iloveyou");
        login.setLoginType("Login Type");
        login.setLoginUsername("janedoe");

        Address address = new Address();
        address.setArea("Area");
        address.setCity("Oxford");
        address.setCountry("GB");
        address.setPincode("Pincode");
        address.setState("MD");
        Donor actualDonor = new Donor(123L, "Donor Name", "Donor Contact", "Donor PAN", "Donor Gender", "Donor DOB", 1L,
                login, address);
        Address address1 = new Address();
        address1.setArea("Area");
        address1.setCity("Oxford");
        address1.setCountry("GB");
        address1.setPincode("Pincode");
        address1.setState("MD");
        actualDonor.setAddress(address1);
        actualDonor.setDonorAmount(1L);
        actualDonor.setDonorContact("Donor Contact");
        actualDonor.setDonorDOB("Donor DOB");
        actualDonor.setDonorGender("Donor Gender");
        actualDonor.setDonorId(123L);
        actualDonor.setDonorName("Donor Name");
        actualDonor.setDonorPAN("Donor PAN");
        Login login1 = new Login();
        login1.setLoginId(123L);
        login1.setLoginPassword("iloveyou");
        login1.setLoginType("Login Type");
        login1.setLoginUsername("janedoe");
        actualDonor.setLogin(login1);
        assertSame(address1, actualDonor.getAddress());
        assertEquals(1L, actualDonor.getDonorAmount().longValue());
        assertEquals("Donor Contact", actualDonor.getDonorContact());
        assertEquals("Donor DOB", actualDonor.getDonorDOB());
        assertEquals("Donor Gender", actualDonor.getDonorGender());
        assertEquals(123L, actualDonor.getDonorId().longValue());
        assertEquals("Donor Name", actualDonor.getDonorName());
        assertEquals("Donor PAN", actualDonor.getDonorPAN());
        assertSame(login1, actualDonor.getLogin());
    }
}

