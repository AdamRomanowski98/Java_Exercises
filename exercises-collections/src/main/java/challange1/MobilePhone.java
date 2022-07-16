package challange1;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contactsList;

    public MobilePhone() {
        this.contactsList = new ArrayList<>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact arleady exists");
            return false;
        }
        contactsList.add(contact);
        return true;
    }

    private int findContact(Contact contact){
        return this.contactsList.indexOf(contact);
    }

    private int findContact(String contactName){
        for(int i = 0; i< this.contactsList.size(); i++){
            Contact contact = this.contactsList.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name){
        int position = findContact(name);
        if(position >= 0){
            return this.contactsList.get(position);
        }
        return null;
    }

    public boolean updateContact(Contact oldContact, Contact newContact){
        int position = findContact(oldContact);
        if(position < 0){
            System.out.println("Contact not found");
            return false;
        }

        this.contactsList.set(position, newContact);
        System.out.println("Contact has been updated");
        return true;
    }

    public boolean removeContact(Contact contact){
        int position = findContact(contact);
        if(position < 0){
            System.out.println("Contact not found");
            return false;
        }
        this.contactsList.remove(position);
        System.out.println("Contact removed");
        return true;
    }

    public void printContacts(){
        for(int i = 0; i < this.contactsList.size(); i++){
            System.out.println((i+1) + "." + this.contactsList.get(i).getName() + " " +this.contactsList.get(i).getPhoneNumber());
        }
    }


}
