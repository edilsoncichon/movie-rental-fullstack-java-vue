package domains;

import java.io.Serializable;
import javax.json.JsonObjectBuilder;

public abstract class Domain implements Serializable {
    
    public abstract JsonObjectBuilder toJsonObject();
}
