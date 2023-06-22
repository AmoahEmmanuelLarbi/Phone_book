// A Console Application To save Contact Using Arrays

package phone;

import java.util.Scanner;

public class phonebookApp {

    public static void main(String[] args) {
        // Instance of Scanner
        Scanner input = new Scanner(System.in);

        // Instance of class phonebook
        phonebook myPhoneBook = new phonebook();

        // variable for user choice
        int user_choice;
        do {

            myPhoneBook.phoneInstruction();

            user_choice = input.nextInt();
            input.nextLine(); // Consume the newline character

            // switch case to perform an action based on user choice
            switch (user_choice) {
                case 1 -> {
                    System.out.print("Enter name : >>> ");
                    String name = input.nextLine();

                    System.out.print("Enter contact : ");
                    String contact = input.nextLine();
                    myPhoneBook.addContact(name, contact);
                }

                case 2 -> {
                    myPhoneBook.displayContact();
                    System.out.println();
                }

                case 3 -> {
                    if (myPhoneBook.getMax_contact() != 0) {
                        System.out.print("Enter name of contact you want to edit : >>> ");
                        String name = input.nextLine();

                        boolean allowContact = myPhoneBook.checkIfNameExist(name);

                        if (allowContact) {
                            System.out.print("Enter new contact : >>> ");
                            String contact = input.nextLine();
                            myPhoneBook.editContact(name, contact);
                        }
                    } else
                        System.out.println("** Your Phonebook is Empty **\n");
                }

                case 4 -> {
                    if (myPhoneBook.getMax_contact() > 0) {
                        System.out.print("Enter name : >>> ");
                        String name = input.nextLine();

                        myPhoneBook.searchContact(name);
                    } else
                        System.out.println("** No Contact Saved ** !!!\nPlease save a contact first !! \n");
                }

                case 5 -> {
                    String name = null;
                    if (myPhoneBook.getMax_contact() > 0) {
                        System.out.print("Enter the name of contact you want to delete : >>> ");
                        name = input.nextLine();
                    }


                    myPhoneBook.deleteContact(name);
                }

                case 6 -> {
                    System.out.println("EXISTING PHONEBOOK ....... ");
                    System.exit(0);
                }

                default -> System.out.println("INVALID OPTION: \n");
            }
        } while (true);
    }
}
