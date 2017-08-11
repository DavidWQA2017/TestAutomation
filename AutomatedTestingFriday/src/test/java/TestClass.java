import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.jcp.xml.dsig.internal.dom.ApacheTransform;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.fail;

/**
 * Created by Administrator on 11/08/2017.
 */
public class TestClass
{
    private WebDriver webDriver;
    private Wait<WebDriver> wait;

    private static String reportFilePath = "C:\\Users\\Administrator\\IdeaProjects\\AutomatedTestingFriday\\report.html";
    private AutomatedTrader AT;
    private AuotTHomeBuying ATHomeBuying;
    private static ExtentReports report;
    private static ExtentTest test;
    private static ExtentTest test2;
    private static ExtentTest test3;
    private static ExtentTest test4;
    private static ExtentTest test5;
    private static ExtentTest test6;
    private static ExtentTest test7;
    private static ExtentTest test8;
    private static ExtentTest test9;
    private static ExtentTest test10;

    public String[] getTestInfo(int testNum)
    {
        String[] spreadsheetInfo = new String[5];
        int i = 0;

        SpreedSheet sheetReader = new SpreedSheet(System.getProperty("user.dir") + "/src/main/resources/TestInfo.xlsx");
        List<String> row = sheetReader.readRow(testNum, "TestData");

        for (String cell : row)
        {
            spreadsheetInfo[i] = cell;
            i++;
        }
        return spreadsheetInfo;
    }


    @BeforeClass
    public static void init()
    {
        report = new ExtentReports();
        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(reportFilePath);
        extentHtmlReporter.config().setReportName("Automotivetests");
        extentHtmlReporter.config().setDocumentTitle("DocumentTitle");
        report.attachReporter(extentHtmlReporter);
        test = report.createTest("TestName");
        test2 = report.createTest("TestName");
        test3 = report.createTest("TestName");
        test4 = report.createTest("TestName");
        test5 = report.createTest("TestName");
        test6 = report.createTest("TestName");
        test7 = report.createTest("TestName");
        test8 = report.createTest("TestName");
        test9 = report.createTest("TestName");
        test10 = report.createTest("TestName");
    }

    @Before
    public void before()
    {
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://www.autotrader.co.uk/");
        wait = new FluentWait<WebDriver>(webDriver).withTimeout(10, SECONDS).pollingEvery(5, SECONDS).ignoring(NoSuchElementException.class);
        AT =  PageFactory.initElements(webDriver, AutomatedTrader.class);
        ATHomeBuying =  PageFactory.initElements(webDriver, AuotTHomeBuying.class);
        webDriver.manage().window().maximize();
    }

    @Test
    public void Test1()
    {
        int testNum = 1;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];
        Actions builder = new Actions(webDriver);

        AT.clickcarButton();
        AT.clickBuyNewAndUsedButton();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"js-header-nav\"]/ul/li[1]/a/span"))).moveByOffset(0, 50).click().build().perform();
        ATHomeBuying.enterPostcode(testInput1);
        test.log(Status.INFO, "postcode has been entered");
        test.log(Status.DEBUG, "the post code entered is " + testInput1 );

        ATHomeBuying.enterKeyWord(testInput2);
        test.log(Status.INFO, "a key word has been added");
        test.log(Status.DEBUG, "the keyword entered is " + testInput2 );

        ATHomeBuying.clickSearchCarsButton();
        test.log(Status.INFO, "search has been clicked");

        String carsFound = ATHomeBuying.getCarsFoundFrDisplay();
        test.log(Status.DEBUG, "the string obtained is  " + carsFound );

        Assert.assertEquals(carsFound, "0 cars found");
        test.log(Status.PASS, "the correct amount of cars have been found");



    }


    @Test
    public void Test2()
    {
        int testNum = 2;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];
        Actions builder = new Actions(webDriver);

        AT.clickcarButton();
        AT.clickBuyNewAndUsedButton();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"js-header-nav\"]/ul/li[1]/a/span"))).moveByOffset(0, 50).click().build().perform();
        ATHomeBuying.enterPostcode(testInput1);


        ATHomeBuying.enterKeyWord(testInput2);
        ATHomeBuying.clickSearchCarsButton();


        String carsFound = ATHomeBuying.getPostcodeRequirementText();


        Assert.assertEquals("Please enter a valid UK postcode" ,carsFound );

    }

    @Test
    public void Test3()
    {
        int testNum = 3;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];
        Actions builder = new Actions(webDriver);

        AT.clickcarButton();
        AT.clickBuyNewAndUsedButton();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"js-header-nav\"]/ul/li[1]/a/span"))).moveByOffset(0, 50).click().build().perform();

        ATHomeBuying.enterPostcode(testInput1);
        test3.log(Status.INFO, "postcode has been entered");
        test3.log(Status.DEBUG, "the post code entered is " + testInput1 );

        ATHomeBuying.enterKeyWord(testInput2);
        test3.log(Status.INFO, "a key word has been added");
        test3.log(Status.DEBUG, "the keyword entered is " + testInput2 );

        ATHomeBuying.clickSearchCarsButton();
        test3.log(Status.INFO, "search has been clicked");

        String carsFound = ATHomeBuying.getCarsFoundFrDisplay();
        test3.log(Status.DEBUG, "the string obtained is  " + carsFound );


        Assert.assertEquals("8,549 cars found" ,carsFound );
        test3.log(Status.PASS, "the correct amount of cars have been found");
    }

    @Test
    public void Test4()
    {
        int testNum = 4;
        String[] testInfo = getTestInfo(testNum);

        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];
        //String testInput3 = testInfo[4];
        //String testInput4 = testInfo[5];
        Actions builder = new Actions(webDriver);

        AT.clickcarButton();
        AT.clickBuyNewAndUsedButton();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"js-header-nav\"]/ul/li[1]/a/span"))).moveByOffset(0, 50).click().build().perform();
        ATHomeBuying.enterPostcode(testInput1);
        ATHomeBuying.enterKeyWord(testInput2);
        ATHomeBuying.clickSearchCarsButton();
        builder.moveToElement(webDriver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/header/div/label/div/div/select"))).click().moveByOffset(0, 20).click().build().perform();
        ATHomeBuying.clickFilterByPrice();
        builder.moveToElement(webDriver.findElement(By.xpath("/html/body/main/section[1]/div[1]/form/ul/li[6]/div/div/div/div[1]/select"))).click().moveByOffset(0, -20).click().build().perform();
        int maxCarAMount = Integer.parseInt(ATHomeBuying.getCarAmountDisplay());


        boolean maxPriceCheck = false;
        if ( maxCarAMount <= 6000 )
        {
           maxPriceCheck = true;
        }
        Assert.assertTrue(maxPriceCheck);
    }

    @Test
    public void Test5()
    {
        int testNum = 5;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @Test
    public void Test6()
    {
        int testNum = 6;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @Test
    public void Test7()
    {
        int testNum = 7;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @Test
    public void Test8()
    {
        int testNum = 8;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @Test
    public void Test9()
    {
        int testNum = 9;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @Test
    public void Test10()
    {
        int testNum = 10;
        String[] testInfo = getTestInfo(testNum);
        String testID  = testInfo[0];
        String testDescrip = testInfo[1];
        String testInput1 = testInfo[2];
        String testInput2 = testInfo[3];

        Assert.fail();
        test3.log(Status.FAIL, "test incomplete");
    }

    @After
    public void after()
    {
        System.out.println("after");
        //webDriver.quit();
    }

    @AfterClass
    public static void finishedTests() {
        report.flush();
    }
}
