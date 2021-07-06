package LabTest1;

public class Item <E,T extends Number>{
    private E itemName;
    private T itemCost;

    public Item(E itemName, T itemCost) {
        this.itemName = itemName;
        this.itemCost = itemCost;
    }

    public E getItemName() {
        return itemName;
    }

    public void setItemName(E itemName) {
        this.itemName = itemName;
    }

    public T getItemCost() {
        return itemCost;
    }

    public void setItemCost(T itemCost) {
        this.itemCost = itemCost;
    }

    @Override
    public String toString(){
        return "Item{ item="+itemName+", price="+itemName+" }";
    }
}
