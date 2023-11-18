package com.qnode.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailAddressField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement passwordConfirmField;
	
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement yesNewsletterOption;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	// Actions
	
	public void enterFirstNameText(String firtsNameText) {
		
		firstNameField.sendKeys(firtsNameText);
	}
	
	public void enterLastNameText(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
		
	}
	
    public void emailAddressText(String emailText) {
    	
    	emailAddressField.sendKeys(emailText);
    	
    }
    
    public void telephoneText(String telephoneText) {
    	
    	telephoneField.sendKeys(telephoneText);
    }
    
    public void passwordText(String passwordText) {
    	
    	passwordField.sendKeys(passwordText);
    	
    }
    public void passwordConfirmText(String passwordconfirmText) {
    	
    	passwordConfirmField.sendKeys(passwordconfirmText);
    	
    }
    
    public void clickOnPrivacyPolicy() {
    	
    	privacyPolicyCheckBox.click();
    }
    
public void selectYesNewsletterOption() {
		
		yesNewsletterOption.click();
	}
    
    public void clickOnContinueButton() {
    	
    	continueButton.click();
    	
    	
    }
    
public String retrivePrivacyPolicyWarning() {
		
		String privacyPolicyWarningText=privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
		
	}
	
	public String retriveFirstNameWarning() {
		
		String firstNameWarningText=firstNameWarning.getText();
		return firstNameWarningText;
		
	}
	public String retriveLastNameWarning() {
		
		String lastNameWarningText=lastNameWarning.getText();
		return lastNameWarningText;
		
	}
	public String retriveTelephoneWarning() {
		
		String telephoneWarningText=telephoneWarning.getText();
		return telephoneWarningText;
		
	}
	public String retrivePasswordWarning() {
		
		String passwordWarningText=passwordWarning.getText();
		return passwordWarningText;
		
	}
	
public String retriveDuplicateEmailAddressWarning() {
		
		String duplicateEmailWarningText=duplicateEmailAddressWarning.getText();
		return duplicateEmailWarningText;
		
	}
    
    
	

}
