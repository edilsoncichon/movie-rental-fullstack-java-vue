package domains.item;

import domains.AplBase;
import domains.title.Title;
import domains.title.DaoTitles;
import java.util.Calendar;
import java.util.Date;
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
        String numberSerie = data.getString("numberSerie");
        String aquisitionDateStr = data.getString("aquisitionDate");
        Date aquisitionDate = DateUtils.String2Calendar(aquisitionDateStr, "yyyy-MM-dd").getTime();
        String type = data.getString("type");
        int titleId = data.getInt("title_id");
        Title title = (Title) daoTitles.get(titleId);
        if (numberSerie.equals(""))
            throw new Exception("[numberSerie] not filled.");
        Item item = (Item) this.get(id);
        item.setNumberSerie(numberSerie);
        item.setAquisitionDate(aquisitionDate);
        item.setType(type);
        item.setTitle(title);
        super.update(item);
    }
}
