package LabTest1;

import java.util.List;

public class ShopLot {
    protected String shopName;
    protected Person contactPerson;
    protected List<Person> employees;

    public ShopLot(String shopName, Person contactPerson, List<Person> employees) {
        this.shopName = shopName;
        this.contactPerson = contactPerson;
        this.employees = employees;
    }
}
