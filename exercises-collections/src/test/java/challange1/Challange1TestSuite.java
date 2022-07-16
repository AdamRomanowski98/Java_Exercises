package challange1;


import challange1.Contact;
import challange1.MobilePhone;
import challange1.Main;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;


public class Challange1TestSuite {
    MobilePhone mobilePhone = new MobilePhone();
    Contact contact = Contact.createContact("Adam", "123");

    @Test
    void testAddingContacts(){
        boolean add = mobilePhone.addNewContact(contact);

        assertEquals(true, add);
    }

    @Test
    void testIfContactArleadyExists(){
        mobilePhone.addNewContact(contact);

        Contact contact1 = Contact.createContact("Adam", "123");
        boolean checkIfAdded = mobilePhone.addNewContact(contact1);

        assertEquals(false, checkIfAdded);
    }

   @Test
   void testUpdateContact(){
        mobilePhone.addNewContact(contact);
        Contact newContact = Contact.createContact("Marcin", "123");
        boolean update = mobilePhone.updateContact(contact, newContact);

        assertEquals(true, update);
   }

   @Test
   void testIfProvidedContactDoesntExist(){
       Contact newContact = Contact.createContact("Marcin", "123");
       boolean update = mobilePhone.updateContact(new Contact("Agnieszka", "123"), newContact);
       assertEquals(false, update);
   }

   @Test
   void testRemoveContact(){
        mobilePhone.addNewContact(contact);
        boolean remove = mobilePhone.removeContact(contact);

        assertEquals(true, remove);
   }

}
