package zoo;

import java.io.Serializable;
import java.time.LocalDate;

public class KeeperSpecies implements Serializable {
    
    private LocalDate date;
    private Species species;
    
    public KeeperSpecies(LocalDate date, Species species){
        this.date = date;
        this.species = species;
    }
    
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    String detail() {
        return "English name: " + species.getEnglishName() + "\n" +
               "Scientific name: " + species.getScientificName() + "\n" +
               "Description: " + species.getDescription() + "\n";
    }
}
