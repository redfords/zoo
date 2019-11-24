package zoo;

import java.io.Serializable;
import java.util.ArrayList;

public class Species implements Serializable {
    
    private String englishName;
    private String scientificName;
    private String description;
    private ArrayList<Habitat> habitats;

    public Species(String englishName, String scientificName, String description) {
        this.englishName = englishName;
        this.scientificName = scientificName;
        this.description = description;
        this.habitats = new ArrayList<>();
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Habitat> getHabitats() {
        return habitats;
    }

    public void setHabitats(ArrayList<Habitat> habitats) {
        this.habitats = habitats;
    }

}
