package zoo;

import java.io.Serializable;
import java.util.ArrayList;

public class Itinerary implements Serializable {    
    
    private int code;
    private int duration;
    private int lenght;
    private int maxVisitors;
    private ArrayList<Zone> zones;
    
    public Itinerary(int code, int duration, int lenght, int maxVisitors) {
        this.code = code;
        this.duration = duration;
        this.lenght = lenght;
        this.maxVisitors = maxVisitors;
        this.zones = new ArrayList<>();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    public int getMaxVisitors() {
        return maxVisitors;
    }

    public void setMaxVisitors(int maxVisitors) {
        this.maxVisitors = maxVisitors;
    }
    
    public ArrayList<Zone> getZones() {
        return zones;
    }
    
    public void setZones(ArrayList<Zone> zones) {
        this.zones = zones;
    }

    public int calculateSpecies() {
        int cont = 0;
        
        for (int i = 0; i < zones.size(); i++) {
            Zone zone = zones.get(i);
            cont += zone.getSpecies().size();
        }
        
        return cont;
    }

}
