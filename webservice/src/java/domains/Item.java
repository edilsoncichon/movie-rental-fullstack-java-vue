package domains;

import java.util.Date;

public class Item {
    private String numberSerie;
    private Date aquisitionDate;
    private Title title;
    private ItemType type;

    public Item(String numberSerie, Date aquisitionDate, Title title, ItemType type) {
        this.numberSerie = numberSerie;
        this.aquisitionDate = aquisitionDate;
        this.title = title;
        this.type = type;
    }

    public String getNumberSerie() {
        return numberSerie;
    }

    public void setNumberSerie(String numberSerie) {
        this.numberSerie = numberSerie;
    }

    public Date getAquisitionDate() {
        return aquisitionDate;
    }

    public void setAquisitionDate(Date aquisitionDate) {
        this.aquisitionDate = aquisitionDate;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
    
}
