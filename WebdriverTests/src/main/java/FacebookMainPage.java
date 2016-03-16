import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.MouseAction.Button;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class FacebookMainPage {

	public static final String PAGE_URL = "http://www.facebook.com";
	public static final String PAGE_TITLE ="Facebook - Log In or Sign Up";
	
	@FindBy(id="email") WebElement field_EmailLogin;
	@FindBy(id="pass") WebElement field_EmailPW;
	//@FindBy(how = How..VALUE, using = "submit") ;
	@FindBy(how=How.LINK_TEXT, using="Log In") WebElement email;
	
	
	
	
}
