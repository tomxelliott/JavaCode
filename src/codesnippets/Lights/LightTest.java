import static org.junit.Assert.*;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

/**
 * Some basic test cases to check certain values have been initialised correctly.
 *
 * @author (Tom Elliott)
 * @ 1.0 (24/07/17)
 */
public class LightTest
{
    /**
     * Default constructor for test class LightTest
     */
    public LightTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp() {}

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown() {}


    @Test
    public void TestColours() {
        LightColours lightCol1 = new LightColours();
        assertEquals(10, lightCol1.colourSize());
        assertEquals("Red", lightCol1.getColour(0));
        assertEquals("Violet", lightCol1.getColour(9));
    }


    @Test
    public void LightControllerTest() {
        LightController lightCon1 = new LightController(25);
        LightColours lightCol1 = new LightColours(25);
        assertEquals("Red", lightCol1.getColour(0));
        assertEquals(false, lightCon1.getLightStatus());
    }
}

