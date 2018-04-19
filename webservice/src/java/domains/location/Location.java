package domains.location;

import domains.customer.Customer;
import domains.item.Item;
import java.util.Date;

public class Location {
    private int id;
    private Customer customer;
    private Item item;
    private Date locationDate;
    private Date returnDate;
    private double value;

    public Location(Customer customer, Item item, Date locationDate, Date returnDate, double value) {
        this.customer = customer;
        this.item = item;
        this.locationDate = locationDate;
        this.returnDate = returnDate;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getLocationDate() {
        return locationDate;
    }

    public void setLocationDate(Date locationDate) {
        this.locationDate = locationDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
}
