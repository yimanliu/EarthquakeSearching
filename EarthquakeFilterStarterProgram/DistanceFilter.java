
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
    private Location loc;
    private double maxDis;
    private String name;
    
    DistanceFilter(Location place, double max, String filterName) {
        loc = place;
        maxDis = max;
        name = filterName;
    }
    
    public boolean satisfies(QuakeEntry qe) {
        Location currLoc = qe.getLocation();
        if (currLoc.distanceTo(loc) < maxDis) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getName() {
        return name;
    }    
}
