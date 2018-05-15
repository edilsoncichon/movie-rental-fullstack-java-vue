package domains.location;

import domains.AplBase;
import domains.customer.CustomerPartner;
import domains.customer.DaoCustomersPartner;
import domains.item.DaoItems;
import domains.item.Item;
import java.util.Calendar;
import java.util.Date;
import javax.json.JsonObject;
import support.DateUtils;

public class AplLocations extends AplBase {
    private DaoItems daoItems;
    private DaoCustomersPartner daoCustomers;
    
    public AplLocations() {
        this.dao = new DaoLocations();
        this.daoItems = new DaoItems();
        this.daoCustomers = new DaoCustomersPartner();
    }

    /**
     * Registra uma Location.
     * 
     * @param data
     * @throws Exception 
     */
    public void save(JsonObject data) throws Exception {
        String expectedDateDevolution = data.getString("expectedDateDevolution");
        Calendar dtCalendar = DateUtils.String2Calendar(expectedDateDevolution, "yyyy-MM-dd");
        double valueItem = data.getJsonNumber("valueItem").doubleValue();
        
        int itemId = data.getInt("item_id");
        int customerId = data.getInt("customer_id");
        Item item = (Item) daoItems.get(itemId);
        CustomerPartner customer = (CustomerPartner) daoCustomers.get(customerId);
        if (valueItem == 0)
            throw new Exception("[value] not filled.");
        Location location = new Location(customer, item, new Date(), dtCalendar.getTime(), null, 0, valueItem, 0);
        super.save(location);
    }
    
    public void delete(int id) throws Exception {
        Location item = (Location) this.get(id);
        this.delete(item);
    }
    
    public void update(int id, JsonObject data) throws Exception {
//        String name = data.getString("name");
//        double value = data.getJsonNumber("value").doubleValue();
//        int maximumRentalTime = data.getInt("maximumRentalTime");
//        if (name.equals(""))
//            throw new Exception("[name] not filled.");
//        Title title = (Title) this.get(id);
//        title.setName(name);
//        title.setValue(value);
//        title.setMaximumRentalTime(maximumRentalTime);
//        this.update(title);
    }
    
    /**
     * Efetua a devolução de uma dada Location.
     * 
     * @param id
     * @param data
     * @throws Exception 
     */
    public void makeReturn(int id, JsonObject data) throws Exception {
        String returnDateText = data.getString("returnDate");
        Date returnDate = DateUtils.String2Calendar(returnDateText, "yyyy-mm-dd").getTime();        
        double fine = data.getInt("fine");
        double amount = Double.valueOf(data.getString("amount"));
        if (returnDateText.equals(""))
            throw new Exception("[returnDate] not filled.");
        if (amount == 0)
            throw new Exception("[amount] not filled.");
        Location location = (Location) this.get(id);
        location.setReturnDate(returnDate);
        location.setFine(fine);
        location.setAmount(amount);
        this.update(location);
    }
}
