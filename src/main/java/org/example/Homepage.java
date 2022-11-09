package org.example;
//importing org.openqa.selenium to use method by
import org.openqa.selenium.By;
//importing org.openqa.selenium.WebDriver Package
import org.openqa.selenium.WebDriver;
//importing org.openqa.selenium.chrome.ChromeDriver Package
import org.openqa.selenium.chrome.ChromeDriver;
//importing org.openqa.selenium.support.ui.Select package to use select method
import org.openqa.selenium.support.ui.Select;
//importing org.testing.selenium.beforeMethod.afterMethod.test Package
import org.testng.annotations.*;
//importing java.text.SimpleDateFormat
import java.text.SimpleDateFormat;

public class Homepage
{   //imported selenium WebDriver interface using  Maven dependency to perform automation task
    protected static WebDriver driver;
    //imported BeforeMethod to open browser, open url and maximize window before each method
    @BeforeMethod
    public void openBrowser()
    {

        //set the driver path for Chrome browser
        System.setProperty("webdriver.chrome.driver", "src/test/java/Drivers/chromedriver.exe");
        //create driver object for Chrome browser
        driver = new ChromeDriver();
        //to maximize window interface of the driver class
        driver.manage().window().maximize();
        //get the URL of the page
        driver.get("https://demo.nopcommerce.com/");
    }
    //importing DateFormat by creating object add time
    public String addTime()
    {

        return new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
    // creating an object for click action to click on the element
    public void clickOnElement(By by)

    {
        driver.findElement(by).click();
    }
    // creating an object for sendKeys
    public void enterText(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // creating an object for get text from an element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    // Test method
    @Test
    public void verifyRegistrationPage()
    {
        //click on button register
        clickOnElement(By.className("ico-register"));
        // going to "gender"  with its locator by Xpath using the method "clickOnElement"
        clickOnElement(By.xpath("//label[@for=\"gender-female\"]"));
        // going to "FirstName" field with its locator by id using the method " enterText"
        enterText(By.id("FirstName"), "Rajesh");
        // going to "LastName" field with its locator by id using the method " enterText"
        enterText(By.id("LastName"), "Shurma");
        //going to "Date of birth" and click on Day
        Select selectDay=new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByValue("10");
        //going to "Date of birth" and click on Month
        Select selectMonth=new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByValue("11");
        //going to "Date of birth" and click on Year
        Select selectYear=new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByVisibleText("1985");
        // going to "Email" field with its locator by id using the method " enterText"
        enterText(By.id("Email"), "Rajesh03" + addTime() + "@gmail.com");
        // going to "Company" field with its locator by id using the method " enterText"
        enterText(By.id("Company"),"DEF Limited");
        //finding a location of "Newsletter" checkbox by xpath to unTick the checkbox
        clickOnElement(By.xpath("//input[@type=\"checkbox\"]"));
        //going to "Password" field with its locator by id using the method " enterText"
        enterText(By.id("Password"), "London123@");
        //going to "ConfirmPassword" field with its locator by id using the method " enterText"
        enterText(By.id("ConfirmPassword"), "London123@");
        //going to "register" button with its locator by id using the method "clickOnElement"
        clickOnElement(By.id("register-button"));
        //putting the text value of the string in variable regMsg with its locator by using method getTextFromElement
        String regMsg = getTextFromElement(By.className("result"));
        //printing the string value
        System.out.println("Result : " + regMsg);

    }
    //Test method
    @Test
    public void EmailAFriend()
    {
        //finding a location of Apple MacBook Pro 13-inch by Xpath through clicking on picture of Apple MacBook Pro 13-inch
        clickOnElement(By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]"));
        //finding a location of Email a friend by className through clicking on Email a friend button
        clickOnElement(By.className("email-a-friend"));
        //enter Friend's email,finding a location of  Friend's email through inspected text field and send value
        enterText(By.id("FriendEmail"),"ami_ash@hotmail.co.uk");
        //enter your email address finding a location of  your email address through inspected text field and send value
        enterText(By.id("YourEmailAddress"),"amna333@hotmail.co.uk");
        //enter personal message,finding a location of  personal message through inspected text field and send value
        enterText(By.id("PersonalMessage"),"Pls ensure that this is right Product");
        //click on the send email button
        clickOnElement(By.className("buttons"));
        //returns text of the element
        String errorMsg = getTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
        //print error message
        System.out.println(errorMsg);
        //closing the opened URL page
    }
    //Test method
    @Test
    public void HomePageCategories()
    {
        //returns Category 1 of the element
    String category1 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a[@href=\"/computers\"]"));
    //returns Category 2 of the element
    String category2 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[2]/a"));
    //returns Category 3 of the element
    String category3 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[3]/a"));
    //returns Category 4 of the element
    String category4 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[4]/a"));
    //returns Category 5 of the element
    String category5 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[5]/a"));
    //returns Category 6 of the element
    String category6 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[6]/a"));
    //returns Category 7 of the element
    String category7 =getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[7]/a"));
    //Print Category 1
        System.out.println(" Product 1 "+ category1);
    //Print Category 2
        System.out.println(" Product 2 " + category2);
    //Print Category 3
        System.out.println(" Product 3 " + category3);
    //Print Category 4
        System.out.println(" Product 4 " + category4);
    //Print Category 5
        System.out.println(" Product 5 " + category5);
    //Print Category 6
        System.out.println(" Product 6 " + category6);
    //Print Category 7
        System.out.println(" Product 7 " + category7);
    }
    //Test method
    @Test
    public void NewsComments()
    { //finding a location of news button by xpath click on the news button
        clickOnElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a"));
        //finding a location of Tittle Text field by id and send value
        enterText(By.id("AddNewComment_CommentTitle"),"News Products");
        //finding a location of Comment Text field  by id and send value
        enterText(By.id("AddNewComment_CommentText"),"New products will be added");
        //click on NEW COMMENT button
        clickOnElement(By.className("buttons"));
        //returns text of the element
        String newsMsg= getTextFromElement(By.className("result"));
        //Print news message
        System.out.println(newsMsg);
        //closing the opened URL page
    }
    //Test method
    @Test
    public void Products()
    {
        //finding a location of Computer by Xpath through clicking on Computer
        clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a"));
        //finding a location of Computer by Xpath through clicking on Desktops
        clickOnElement(By.xpath("//ul[@class=\"sublist\"]/li[1]/a"));
        //returns text 1 of the element
        String textMsg1=getTextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/build-your-own-computer\"]"));
        //Print Text message 1
        System.out.println(" Product 1 " + textMsg1);
        //returns text 2 of the element
        String textMsg2=getTextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));
        //Print Text message 2
        System.out.println(" Product 2 " + textMsg2);
        //returns text 3 of the element
        String textMsg3=getTextFromElement(By.xpath("//div[@class=\"details\"]/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));
        //Print Text message 3
        System.out.println(" Product 3 " + textMsg3);
        //closing the opened URL page
    }
    //imported AfterMethod to close browser after each method
    @AfterMethod
    public void closeBrowser()
    {
        //closing all the URL pages
        driver.quit();
    }
}
