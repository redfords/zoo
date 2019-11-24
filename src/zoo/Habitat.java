package zoo;

import java.io.Serializable;

public class Habitat implements Serializable {

    private String name;
    private String climate  ;
    private String vegetation;
    private String continent;
    
    public Habitat(String name, String climate, String vegetation, String continent){
        this.name = name;
        this.climate = climate;
        this.vegetation = vegetation;
        this.continent = continent;
    } 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getVegetation() {
        return vegetation;
    }

    public void setVegetation(String vegetation) {
        this.vegetation = vegetation;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return continent;
    }

}
