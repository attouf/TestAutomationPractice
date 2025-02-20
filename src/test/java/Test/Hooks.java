package Test;

import base.BasicTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends BasicTest {
    private BasicTest basicTest= new BasicTest();
    @Before
    public void Avant() {
        basicTest.setUp(); 
    }

    @After
    public void LaFin() {
        basicTest.tearDown(); 
    }
}
