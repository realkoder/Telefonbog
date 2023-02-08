public class Contact implements Comparable<Contact> {
    private String firstname;
    private String lastName;

    public Contact(String firstname, String lastName) {
        this.firstname = firstname;
        this.lastName = lastName;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public String toString() {
        return "Name: " + firstname + " " + lastName;
    }

    @Override
    public int compareTo(Contact o) {
        return firstname.toLowerCase().compareTo(o.firstname.toLowerCase());
    }
}
