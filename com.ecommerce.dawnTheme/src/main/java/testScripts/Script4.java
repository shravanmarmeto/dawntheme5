package testScripts;

import java.util.HashMap;

import org.testng.annotations.Test;

import genericScripts.OpenCloseApplication;
import pom.AjaxCart;
import pom.CartPage;
import pom.CollectionsPage;
import pom.HomePage;
import pom.PDP;
import pom.VerifyDetails;

public class Script4 extends OpenCloseApplication {
	
	@Test
	public void testApp() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.switchToIframe();

		homePage.clickShoesOption();
		homePage.hoverAndClickShopAll();

		CollectionsPage collectionsPage = new CollectionsPage(driver);
		collectionsPage.verifyCollectionsPage();
		collectionsPage.clickOnAnyProduct();

		PDP pdp = new PDP(driver);
		if(pdp.verifySoldOut())
		{
			pdp.scrollToYouMayAlsoLikeSectionAndClickProduct();
			pdp = new PDP(driver);
		}
		
		/*
		pdp.changeColorVariant();
		pdp.changeSizeVariant();

		int quantity = 4;
		pdp.changeQuantity(quantity);
		
		HashMap<String, String> pdpProductDetails = pdp.captureProductDetailsWithQuantity(quantity);
		*/
		
		int quantity = 4;
		HashMap<String, String> pdpProductDetails = pdp.changeColorSizeQuantityVariantAndCaptureDetails(quantity);
		
		pdp.clickAddToCartButton();

		AjaxCart ajaxCart = new AjaxCart(driver);
		ajaxCart.verifyCartNotification();

		HashMap<String, String> ajaxcartProductDetails = ajaxCart.captureProductDetailsFromAjaxCart();

		VerifyDetails.verifyProductDetailsPDPAjaxCart(pdpProductDetails, ajaxcartProductDetails);

		ajaxCart.clickViewCartButton();

		CartPage cart = new CartPage(driver);
		HashMap<String, String> cartProductDetails = cart.captureProductDetailsWithQuantity();

		VerifyDetails.verifyProductDetailsPDPCart(pdpProductDetails, cartProductDetails);
		
		cart.verifyProductImage();
		cart.verifyProductDetails();
		cart.increaseAndDecreaseQuantity(quantity);
//		cart.clickProductTitleAndVerify();
		String cartTitle = cart.captureAndClickProductTitle();
		
		pdp = new PDP(driver);
		String pdpTitle = pdp.captureProductTitle();
		
		VerifyDetails.verifyProductTitle(cartTitle, pdpTitle);
		
		pdp.clickCart();
		
		cart.clickCheckoutButton();
		
		homePage = new HomePage(driver);
		homePage.clickCart();
		
		cart = new CartPage(driver);
		cart.clickRemoveButton();
		cart.verifyEmptyCart();
	}
}