package domains.item;

import domains.AplBase;
import domains.title.Title;
import domains.title.DaoTitles;
import java.util.Calendar;
import javax.json.JsonObject;
import support.DateUtils;

public class AplItems extends AplBase {
    private DaoTitles daoTitles;
    
    public AplItems() {
        this.dao = new DaoItems();
        this.daoTitles = new DaoTitles();
    }

    public void save(JsonObject data) throws Exception {
        String numberSerie = data.getString("numberSerie");
        String aquisitionDate = data.getString("aquisitionDate");
        Calendar dtCalendar = DateUtils.String2Calendar(aquisitionDate, "yyyy-MM-dd");
        String type = data.getString("type");
        int titleId = data.getInt("title_id");
        Title title = (Title) daoTitles.get(titleId);
        if (numberSerie.equals(""))
            throw new Exception("[numberSerie] not filled.");
        Item item = new Item(numberSerie, dtCalendar.getTime(), title, type);
        super.save(item);
    }
    
    public void delete(int id) throws Exception {
        Item item = (Item) this.get(id);
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
}
