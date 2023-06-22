// A Console Application To save Contact Using Arrays

package phone;

public class phonebook {

    // instance variables
    private final String[] user_name;
    private final String[] user_contact;
    //
    private static final int MAXI_SLOT = 10;

    private int max_contact; // variable for number of contact saved

    // constructor
    public phonebook() {
        user_name = new String[MAXI_SLOT]; // size of array user_name is MAXI_SLOT
        user_contact = new String[MAXI_SLOT]; // size of array user_contact is MAXI_SLOT
        max_contact = 0;
    }

    // methods
    public void addContact(String name, String contact) {
        // check if phonebook is not full
        if (max_contact < MAXI_SLOT) {
            // insert name and contact
            user_name[max_contact] = name;
            user_contact[max_contact] = contact;
            // increase max_contact counter
            max_contact++;

            // display message if successful
            System.out.println("\n***** CONTACT ADDED SUCCESSFULLY *****\n");
        } else {
            System.out.printf("%s, %d/ %d SLOTS USED%n", "!!! Phonebook is full", getMax_contact(), getMax_contact());
            System.out.println("Try delete some contact some more space !!! \n");
        }
    }

    public void displayContact() {
        // check if phonebook is empty
        if (max_contact == 0) {
            System.out.println(" ** No Contact Found **");
        } else {
            System.out.println("\n**** SAVED CONTACTS *****");
            // display name and contact
            for (int i = 0; i < max_contact; i++) {
                System.out.printf("Name : %s%nContact : %s%n", user_name[i], user_contact[i]);
                System.out.println("********************");
            }
            System.out.println();
        }
    }

    public void editContact(String name, String contact) {

        for (int i = 0; i < max_contact; i++) {
            // search for the name within the array
            if (user_name[i].equalsIgnoreCase(name)) {
                user_contact[i] = contact;

                System.out.println("*** Contact Updated Successfully ***\n");
                break;
            }
        }

    }

    public boolean checkIfNameExist(String name) {
        boolean nameExist = false;

        if (max_contact != 0) {
            // check if name exist in array
            for (int i = 0; i < max_contact; i++) {
                if (user_name[i].equalsIgnoreCase(name)) {
                    nameExist = true;
                    break;
                }
            }
        }
        if (!nameExist) {
            System.out.println("** Contact Not Found **\n");
        }
        return nameExist;
    }

    // method to delete contact if user chose delete option
    public void deleteContact(String name) {
        boolean contactFound = false;
        int contactIndex = -1;

        // first check if array is empty
        if (getMax_contact() < 1) {
            System.out.println("** No Contact Found !!! **\n");
        } else {
            for (int i = 0; i < max_contact; i++) {
                if (user_name[i].equalsIgnoreCase(name)) {
                    contactIndex = i;
                    contactFound = true;
                    break;
                }
            }


            if (contactFound) {
                for (int i = contactIndex; i < max_contact - 1; i++) {
                    user_name[i] = user_name[i + 1];
                    user_contact[i] = user_contact[i + 1];
                }
                // decrease variable maxContact
                max_contact--;
                System.out.printf("\"%s\" contact has been deleted successfully %n%n", name);
            } else
                checkIfNameExist(name);
        }

    }

    public void searchContact(String name) {
        if (getMax_contact() > 0) {
            for (int i = 0; i < max_contact; i++) {
                if (user_name[i].equalsIgnoreCase(name)) {
                    System.out.printf("\"%s's\" contact found%n", name);
                    System.out.println(" *** DETAILS ***");
                    System.out.printf("Name : %s%n", user_name[i]);
                    System.out.printf("Phone Number : %s%n%n", user_contact[i]);

                    break;
                }
            }

            // calling method checkIfNameExist
            checkIfNameExist(name);

        } else
            System.out.println("** No Contact Found !! **\n");
    }


    public void phoneInstruction() {
        System.out.println("Phonebook Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. Display All Contacts");
        System.out.println("3. Edit Contact");
        System.out.println("4. Search For a Contact");
        System.out.println("5. Delete Contact");
        System.out.println("6. Exit\n");
        System.out.print("Enter your choice: >>>> ");
    }

    public int getMax_contact() {
        return max_contact;
    }

}
