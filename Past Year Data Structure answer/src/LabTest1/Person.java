package LabTest1;

public class Person {
    private String name;
    private String contactNumber;

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString(){
        return "Person{ name="+name+", contactNo="+contactNumber+" }";
    }
}
