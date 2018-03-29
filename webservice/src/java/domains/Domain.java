package domains;

import javax.json.JsonObjectBuilder;

public abstract class Domain {
    
    public abstract JsonObjectBuilder toJsonObject();
}
