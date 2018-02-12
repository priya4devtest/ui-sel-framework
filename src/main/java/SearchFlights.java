import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchFlights {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit mercury website
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");

        //Find username text box by its name
        WebElement userName = driver.findElement(By.name("userName"));

        //Find password text box by its name
        WebElement password = driver.findElement(By.name("password"));

        // Enter username
        userName.sendKeys("mercury");

        // Enter password
        password.sendKeys("mercury");

        // Now submit the form. WebDriver will find the form for us from the element
        WebElement login = driver.findElement(By.name("login"));
        login.click();

        WebDriverWait wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(By.name("tripType")));

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //select one way radio button
        WebElement tripType = driver.findElement(By.cssSelector("input[value='oneway']"));
        tripType.click();

        //verify if oneway is selected
        Boolean checkSelenium = tripType.isSelected();
        if (checkSelenium == true){
            System.out.println("One way button selected");
        }else{
            System.out.println("One way button is not selected");
        }

        //Depart from dropdown
        Select fromPort = new Select(driver.findElement(By.name("fromPort")));
        fromPort.selectByValue("Sydney");

        //Arrive to dropdown
        Select toPort = new Select(driver.findElement(By.name("toPort")));
        toPort.selectByValue("London");

        //select First Class radio button
        WebElement servClass = driver.findElement(By.cssSelector("input[value='First']"));
        servClass.click();

        Boolean checkClass = servClass.isSelected();
        if (checkClass == true){
            System.out.println("First Class Selected");
        }

        //find flights
        WebElement findFlights = driver.findElement(By.name("findFlights"));
        findFlights.click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //select default flights
        WebElement reserveFlights = driver.findElement(By.name("reserveFlights"));
        reserveFlights.click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //Enter First Name
        WebElement firstName = driver.findElement(By.name("passFirst0"));
        firstName.sendKeys("Priya");

        //Enter Last Name
        WebElement lastName = driver.findElement(By.name("passLast0"));
        lastName.sendKeys("Kesapragada");

        //Enter CreditCard Number
        WebElement creditnumber = driver.findElement(By.name("creditnumber"));
        creditnumber.sendKeys("1111111111111111");

        //select ticketless checkbox
        WebElement ticketLess = driver.findElement(By.name("ticketLess"));
        ticketLess.click();

        //buy flights
        WebElement buyFlights = driver.findElement(By.name("buyFlights"));
        buyFlights.click();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}