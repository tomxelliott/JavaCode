import java.util.ArrayList;
import java.util.Iterator;
import java.util.Comparator;

/**
 * Monitor counts of different types of animal.
 * Sightings are recorded by spotters.
 */
public class AnimalMonitor 
{
    // Records of all the sightings of animals.
    private ArrayList<Sighting> sightings;
    
    /**
     * Create an AnimalMonitor.
     */
    public AnimalMonitor()
    {
        this.sightings = new ArrayList<>();
    }
    
    /**
     * Add the sightings recorded in the given filename to the current list.
     * @param filename A CSV file of Sighting records.
     */
    public void addSightings(String filename)
    {
        SightingReader reader = new SightingReader();
        sightings.addAll(reader.getSightings(filename));
    }
    
    /**
     * Print details of all the sightings.
     */
    public void printList()
    {
        sightings.forEach(record -> System.out.println(record.getDetails()));
    }
    
    /**
     * Print the details of all the sightings of the given animal.
     * @param animal The type of animal.
     */
    public void printSightingsOf(String animal)
    {
        sightings.stream()
                 .filter(s -> animal.equals(s.getAnimal()))
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print the details of all the sightings from a given day.
     * @param dayID The ID for the day you want sightings from.
     */
    public void printSightingsFromDay(int dayID)
    {
        sightings.stream()
                 .filter(s -> dayID == s.getPeriod())
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print the details of all sightings of a given animal on a given day.
     * @param animal The type of animal.
     * @param dayID The ID for the day you want sightings from.
     */
    public void printSightingsOfFromDay(String animal, int dayID)
    {
        sightings.stream()
                 .filter(s -> animal.equals(s.getAnimal()))
                 .filter(s -> dayID == s.getPeriod())
                 .forEach(s -> System.out.println(s.getDetails()));
    }
    
    /**
     * Print all the sightings by the given spotter.
     * @param spotterID The ID of the spotter.
     */
    public void printSightingsBy(int spotterID)
    {
        sightings.stream()
                 .filter(sighting -> sighting.getSpotter() == spotterID)
                 .map(sighting -> sighting.getCount())
                 .forEach(System.out::println);
    }
    
    /**
     * Print the number of sightings of a particular animal.
     * @param animal The type of animal.
     */
    public void printSightingsQuantity(String animal)
    {
        sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .map(sighting -> sighting.getCount())
                 .forEach(details -> System.out.println(details));
    }
    
    /**
     * Print all sightings of a given animal by a particular spotter on a particular day.
     * @param animal The type of animal.
     * @param spotterID The ID of the spotter.
     * @param dayID The ID of the day required.
     */
    public void sightingsBySpotter(String animal, int spotterID, int dayID)
    {
        sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .filter(sighting -> sighting.getSpotter() == spotterID)
                 .filter(sighting -> dayID == sighting.getPeriod())
                 .map(sighting -> sighting.getCount())
                 .forEach(details -> System.out.println(details));
    }
    
    /**
     * Returns the number of sightings by a particular spotter.
     * @param spotterID The spotter that you wish to view the sightings count for.
     */
    public int sightingsBySpotterID(int spotterID)
    {
        return sightings.stream()
            .filter(sighting -> sighting.getSpotter() == spotterID)
            .map(sighting -> sighting.getCount())
            .reduce(0, (total, count) -> total + count);
    }
    
    /**
     * Returns names of animals seen by particular spotter on a particular day.
     * @param spotterID The spotter you wish to view data from.
     * @param dayID The day you wish to view data from.
     */
    public String printNamesOfAnimals(int spotterID, int dayID)
    {
        return sightings.stream()
                 .filter(sighting -> sighting.getCount() > 0)
                 .filter(sighting -> sighting.getSpotter() == spotterID)
                 .filter(sighting -> dayID == sighting.getPeriod())
                 .map(sighting -> sighting.getAnimal())
                 .reduce("", (list, animal) -> list + animal + ", ");
    }
    
    /**
     * Print a list of the types of animal considered to be endangered.
     * @param animalNames A list of animals names.
     * @param dangerThreshold Counts less-than or equal-to to this level
     *                        are considered to be dangerous.
     */
    public void printEndangered(ArrayList<String> animalNames, 
                                int dangerThreshold)
    {
        sightings.stream()
                 .filter(sighting -> sighting.getCount() <= dangerThreshold)
                 .map(sighting -> sighting.getDetails())
                 .forEach(details -> System.out.println(details));
        }
    
    /**
     * Return a count of the number of sightings of the given animal.
     * @param animal The type of animal.
     * @return The count of sightings of the given animal.
     */
    public int getCount(String animal)
    {
        return sightings.stream()
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            .map(sighting -> sighting.getCount())
            .reduce(0, (total, count) -> total + count);
    }
    
    /**
     * Returns the largest view count of a particular animal.
     * @param animal The animal you wish to have the largest count for.
     */
    public int largestCount(String animal)
    {
        return sightings.stream()
            .filter(sighting -> animal.equals(sighting.getAnimal()))
            .map(sighting -> sighting.getCount())
            .max(Integer::compare)
            .get();
    }

    /**
     * Returns the first sighting of a particular animal by a particular spotter.
     * @param animal The animal you wish to have the first sighting for.
     * @param spotterID The ID of the spotter we wish to see the first sighting by.
     */
    public void firstSighting(String animal, int spotterID)
    {
        String firstObj = sightings.stream()
                 .filter(sighting -> animal.equals(sighting.getAnimal()))
                 .filter(sighting -> sighting.getSpotter() == spotterID)
                 .map(sighting -> sighting.getDetails())
                 .findFirst()
                 .orElse("");
                 
        System.out.println(firstObj);
    }
    
    /**
     * Remove from the sightings list all of those records with
     * a count of zero.
     */
    public void removeZeroCounts()
    {
        sightings.removeIf(sighting -> sighting.getCount() == 0);
    }
    
    /**
     * Remove from the sightings record all the records for spotter with ID used in parameter.
     * @param spotterID The ID for the spotter whos records you wish to remove.
     */
    public void removeSpotterRecords(int spotterID)
    {
        sightings.removeIf(sighting -> sighting.getSpotter() == spotterID);
    }
    
    /**
     * Return a list of all sightings of the given type of animal
     * in a particular area.
     * @param animal The type of animal.
     * @param area The ID of the area.
     * @return A list of sightings.
     */
    public ArrayList<Sighting> getSightingsInArea(String animal, int area)
    {
        ArrayList<Sighting> records = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                if(record.getArea() == area) {
                    records.add(record);
                }
            }
        }
        return records;
    }
    
    /**
     * Return a list of all the sightings of the given animal.
     * @param animal The type of animal.
     * @return A list of all sightings of the given animal.
     */
    public ArrayList<Sighting> getSightingsOf(String animal)
    {
        ArrayList<Sighting> filtered = new ArrayList<>();
        for(Sighting record : sightings) {
            if(animal.equals(record.getAnimal())) {
                filtered.add(record);
            }
        }
        return filtered;
    }
}
