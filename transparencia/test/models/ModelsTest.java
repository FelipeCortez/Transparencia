package models;

import models.*;
import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createAndRetrieveParlamentar() {
        new models.Parlamentar("Bob", "07-15-2014", "PT", "Engenheiro", "Natal", "13", 2580.50, "sfafjaoijsofj").save();
        models.Parlamentar bob = models.Parlamentar.find.where().eq("nome", "Bob").findUnique();
        assertNotNull(bob);
        assertEquals("Bob", bob.name);
    }

    @Test
    public void tryAuthenticateParlamentar() {
        new models.Parlamentar("Bob", "07-15-2014", "PT", "Engenheiro", "Natal", "13", 2580.50, "sfafjaoijsofj").save();
        
        assertNotNull(models.Parlamentar.authenticate("Bob", "13"));
        assertNull(models.Parlamentar.authenticate("Graco", "7"));
        assertNull(models.Parlamentar.authenticate("Victor", "9"));
    }
}