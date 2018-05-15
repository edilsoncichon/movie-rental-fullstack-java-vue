package domains.item;

import domains.Domain;
import domains.title.Title;
import java.util.Date;
import javax.json.Json;
import javax.persistence.*;
import javax.json.JsonObjectBuilder;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Item extends Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String numberSerie;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Date aquisitionDate;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "title_id")
    @Cascade(CascadeType.SAVE_UPDATE)
    private Title title;
    
    private String type;

    public Item() {}

    public Item(String numberSerie, Date aquisitionDate, Title title, String type) {
        this.numberSerie = numberSerie;
        this.aquisitionDate = aquisitionDate;
        this.title = title;
        this.type = type;
    }

    public Item(int id, String numberSerie, Date aquisitionDate, Title title, String type) {
        this.id = id;
        this.numberSerie = numberSerie;
        this.aquisitionDate = aquisitionDate;
        this.title = title;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public JsonObjectBuilder toJsonObject() {
        return Json.createObjectBuilder()
                .add("_id", getId())
                .add("numberSerie", getNumberSerie())
                .add("aquisitionDate", getAquisitionDate().toString())
                .add("title", getTitle().toJsonObject())
                .add("type", getType());
    }
    
}
