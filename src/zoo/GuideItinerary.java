package zoo;

import java.io.Serializable;
import java.time.LocalTime;

public class GuideItinerary implements Serializable {
    
    private LocalTime schedule;
    private Itinerary itinerary;
    
    public GuideItinerary(LocalTime schedule, Itinerary itinerary){
        this.schedule = schedule;
        this.itinerary = itinerary;
    }

    public LocalTime getSchedule() {
        return schedule;
    }

    public void setSchedule(LocalTime schedule) {
        this.schedule = schedule;
    }

    public Itinerary getItinerary() {
        return itinerary;
    }

    public void setItinerary(Itinerary itinerary) {
        this.itinerary = itinerary;
    }
    
    public String detail() {
       return "Code: " + itinerary.getCode() + "\n" +
               "Duration: " + itinerary.getDuration() + "\n" +
               "Lenght: " + itinerary.getLenght() + " meters" + "\n" + 
               "Visitors: " + itinerary.getMaxVisitors() + "\n" + 
               "Species: " + itinerary.calculateSpecies() + "\n";
    }

}
