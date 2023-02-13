package steps;

import io.cucumber.java.en.Given;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestSteps {

    @Given("I can display a test property")
    public void iCanDisplayATestProperty() {
        System.out.println("I can add numbers");
        System.out.println(getPropertyFromFile("test.properties","testkey"));
    }

    public static String getPropertyFromFile(String filePathAndName, String propertyName){
        try{
            InputStream resourceAsStream = TestSteps.class.getClassLoader().getResourceAsStream(filePathAndName);
            Properties prop = new Properties();
            prop.load(resourceAsStream);
            return prop.getProperty(propertyName);
        } catch (IOException e) {
            return null;
        }
    }

}
