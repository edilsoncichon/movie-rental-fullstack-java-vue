package applications;

import dao.DaoTitlesCategories;

public class AplTitlesCategories extends AplBase {

    public AplTitlesCategories() {
        this.dao = new DaoTitlesCategories();
    }
    
}
