package domains.location;

import domains.customer.Customer;
import domains.item.Item;
import java.util.Date;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.*;

@Entity
public class Location extends domains.Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date locationDate;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date expectedReturnDate;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date returnDate;
    
    private double fine;
    
    private double valueItem;
    
    private double amount;

    public Location() {}

    public Location(int id, Customer customer, Item item, Date locationDate, 
            Date expectedReturnDate, Date returnDate, double fine, 
            double valueItem, double amount) {
        this.id = id;
        this.customer = customer;
        this.item = item;
        this.locationDate = locationDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.valueItem = valueItem;
        this.amount = amount;
    }

    public Location(Customer customer, Item item, Date locationDate, 
            Date expectedReturnDate, Date returnDate, double fine, 
            double valueItem, double amount) {
        this.customer = customer;
        this.item = item;
        this.locationDate = locationDate;
        this.expectedReturnDate = expectedReturnDate;
        this.returnDate = returnDate;
        this.fine = fine;
        this.valueItem = valueItem;
        this.amount = amount;
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

    public double getValueItem() {
        return valueItem;
    }

    public void setValueItem(double value) {
        this.valueItem = value;
    }

    public Date getExpectedReturnDate() {
        return expectedReturnDate;
    }

    public void setExpectedReturnDate(Date expectedReturnDate) {
        this.expectedReturnDate = expectedReturnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("customerId", getCustomer().getId())
                .add("customerName", getCustomer().getName())
                .add("item", getItem().toJsonObject())
                .add("locationDate", getLocationDate().toString())
                .add("expectedReturnDate", getExpectedReturnDate().toString())
                .add("returnDate", getReturnDate() != null ? getReturnDate().toString() : "")
                .add("valueItem", getValueItem())
                .add("fine", getFine())
                .add("amount", getAmount());
    }
    
}
