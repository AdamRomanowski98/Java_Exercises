package challange1;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();

    public static void main(String[] args) {

        boolean end = false;
        while(!end){
            printOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 0:
                    end = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    printOptions();
                    break;
            }

        }

    }

    private static void printOptions(){
        System.out.println("Press \n" +
                "0 - to shutdown\n" +
                "1 - to check contacts\n" +
                "2 - to add contact\n" +
                "3 - to update contact\n" +
                "4 - to remove contact\n" +
                "5 - to print list of options");
        System.out.println("Choose option: ");
    }

    private static void addContact(){
        System.out.println("Enter a name");
        String name = scanner.nextLine();
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        Contact contact = Contact.createContact(name, phoneNumber);
        if(mobilePhone.addNewContact(contact)){
            System.out.println("New contact added succesfully");
        }
    }

    private static void updateContact(){
        System.out.println("Enter a name to be searched");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact not found");
            return;
        }
        System.out.println("Enter new contact name");
        String newName = scanner.nextLine();
        System.out.println("Enter new phoneNumber");
        String newPhoneNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newPhoneNumber);
        mobilePhone.updateContact(contact, newContact);
    }

    private static void removeContact(){
        System.out.println("Enter a name to be searched");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if(contact == null){
            System.out.println("Contact not found");
            return;
        }else{
            mobilePhone.removeContact(contact);
        }
    }


}
