package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PostAdPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='AdTitleForm']")
    private WebElement adTitle;

    @FindBy(xpath = "//*[text() ='Next']")
    private WebElement nextBtn;

    @FindBy (id = "AdTitleForm")
    private WebElement adTitlefield;

    @FindBy(xpath = "//span[@class='maxCharCountdown-2996436710']")
    WebElement spnCountChar;

    @FindBy(xpath = "//a[@title='Post ad']")
    WebElement btnPostAd;


    @FindBy (xpath = "//div//li[5]")
    WebElement services;

    @FindBy(xpath = "//div//li[12]")
    WebElement tutorLanguage;

    @FindBy(xpath = "//div/h3[@class='categoryListsHeader-2557181585']")
    WebElement selectCategory;

    @FindBy(xpath = "//*[text() = 'Services']")
    private WebElement servicesLink;

    @FindBy(xpath = "//*[text() = 'Tutors & Languages']")
    private WebElement tutorAndLanguageLink;

    @FindBy(id = "AdTitleForm")
    private WebElement descriptionField;

    @FindBy(id = "pstad-map-address")
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='postAdForm.phoneNumber']")
    private WebElement phoneField;

    @FindBy(xpath = "//button[@data-qa-id='package-0-bottom-select']")
    private WebElement basicPackageBtn;

    @FindBy(xpath = "//*[text()='Preview']")
    private WebElement previewBtn;


//    @FindBy(xpath = "//div[@class='allCategoriesContainer-1722591519']")
//    private List<WebElement> selectCatgories;


    @FindBy (xpath = "//*[text()='Services']")
     private WebElement selectServices;


    @FindBy (xpath = "//*[text ()= 'Tutors & Languages']")
    public WebElement selectTutorNLanguage;

    @FindBy(xpath="//*[text()='Services']/parent::button")
    private WebElement _services;

    @FindBy(xpath = "//*[text()='Tutors & Languages']/parent::button")
    private WebElement _tutorLanguage;

    @FindBy(xpath="//ul[@class='categoryList-1515474558']")
    private WebElement subCategorySection;

    @FindBy(xpath="//li[@class='categoryListItem-3123839590']")
    private List<WebElement> allCategories;


    //    WebElements by Geetha

    @FindBy (xpath = "//div//ul[2]//li[12]")
    private WebElement TutorsAndLanguages;




    public PostAdPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ValidateAddTitle(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.afterClickingPostAdBtn();
        WebDriverWait wait=new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(this.adTitle));
        this.editAdTitleFiled("QA Automation").clickNextBtn();
    }

    public PostAdPage enterDescription(String descriptionDetails){
        this.descriptionField.sendKeys(descriptionDetails);
        return this;
    }


    public PostAdPage enterAddress(String addressDetails){
        this.addressField.sendKeys(addressDetails);
        return this;
    }

    public PostAdPage enterPhoneNumber(String phonenumber){
        this.phoneField.sendKeys(phonenumber);
        return this;
    }

    public PostAdPage selectBasicPackage(){
        this.basicPackageBtn.click();
        return this;
    }


    public PostAdPage clickPreviewBtn(){
        this.previewBtn.click();
        return this;
    }


    public PostAdPage clickTutorAndLanguageLink(){
        this.tutorAndLanguageLink.click();
        return this;
    }

    public PostAdPage clickServicesLink(){
        this.servicesLink.click();
        return this;
    }


    public PostAdPage editAdTitleFiled(String titleOfChoice){
        this.adTitle.sendKeys(titleOfChoice);
        return this;
    }

    public PostAdPage enterInvalidAdTitle(String title){
        try {
            btnPostAd.click();
            Thread.sleep(2000);
            adTitle.sendKeys(title);
        }
        catch (Exception e) {
        }
        return this;
    }

    public PostAdPage clickNextBtn(){
        this.nextBtn.click();
        return this;
    }
    public void clickServices(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.services));
        this.services.click();
    }

    public void clickTutorLanguage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.services));
        this.tutorLanguage.click();

    }

    public PostAdPage enterDiscription (String description) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.descriptionField));
        this.descriptionField.sendKeys(description);
        return this;
    }

    public PostAdPage selectServices(){
      this.selectServices .click();
     return this;
   }

    public PostAdPage selectTutorNLanguage (){
      this. selectTutorNLanguage.click();
     return this;
    }
    public WebElement getServices(){

        return this._services;
    }

    public WebElement getAdTitle(){
        return this.adTitle;
    }

    public WebElement getSelectCategory(){

        return this.selectCategory;
    }

    public PostAdPage ClickServices(){
        this._services.click();
        return this;
    }
    public WebElement getSubCategorySection(){
        return this.subCategorySection;
    }
    public List <WebElement> getAllCategories(){
        return this.allCategories;
    }

    public  WebElement getTutorLanguage(){
        return this._tutorLanguage;
    }

//    public AddDetailsPage ClickTutorLanguage(){
//        this._tutorLanguage.click();
//        return new AddDetailsPage(driver);
//    }


//    Method to click Tutors and Languages

    public PostAdPage clickTandL() {

        Actions actions = new Actions(driver);
        actions.moveToElement(TutorsAndLanguages).build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.TutorsAndLanguages));
        this.TutorsAndLanguages.click();
        return this;
    }



}
