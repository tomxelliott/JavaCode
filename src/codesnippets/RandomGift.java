import java.util.*;

/**
 * Help me buy gifts for people, 
 * as I am very bad at it...
 */
public class RandomGift
{
    private ArrayList<String> gifts;
    private ArrayList<String> locations;
    private Random randomGenerator;
    
    /**
     * New instance of Random Gift...
     * Initialise all data structures required.
     */
    public RandomGift()
    {
        gifts = new ArrayList<>();
        locations = new ArrayList<>();
        populateGifts();
        populateLocations();
    }
    
    private void populateGifts()
    {
        gifts.add("Perfume");
        gifts.add("Chocolate");
        gifts.add("DVD boxset");
        gifts.add("Jewelry");
        gifts.add("Book");
        gifts.add("Clothes");
        gifts.add("Voucher");
        gifts.add("Make Up");
    }
    
    private void populateLocations()
    {
        locations.add("Tesco");
        locations.add("Selfridges");
        locations.add("John Lewis");
        locations.add("House of Frasier");
        locations.add("H&M");
        locations.add("TopShop");
        locations.add("Debenhams");
        locations.add("Waterstones");
    }
    
    public String helpWithGifts()
    {
        Random randomizer = new Random();
        String random = "";
        random += gifts.get(randomizer.nextInt(gifts.size())) + " from ";
        random += locations.get(randomizer.nextInt(locations.size())) + ".";
        return random;
    }
}
