package zoo;

import java.io.Serializable;
import java.util.ArrayList;

public class Zone implements Serializable {
    
    private String name;
    private int extension;
    private ArrayList<Species> species;
    
    public Zone(String name, int extension){
        this.name = name;
        this.extension = extension;
        this.species = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExtension() {
        return extension;
    }
    
    public void setExtension(int extension) {
        this.extension = extension;
    }

    public ArrayList<Species> getSpecies() {
        return species;
    }

    public void setSpecies(ArrayList<Species> species) {
        this.species = species;
    }

    String mostrarSpecies() {
        String list = "";
        for(int i = 0; i < species.size(); i++) {
            Species e = species.get(i);
            list += " " + i + " - " + e.getScientificName() + "\n";
        }
        
        return list;
    }

}
