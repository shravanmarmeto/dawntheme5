package pom;

import java.util.HashMap;

import org.testng.Assert;

public class VerifyDetails {
	public static void verifyProductDetailsPDPAjaxCart(HashMap<String, String> pdpProductDetails, HashMap<String, String> ajaxcartProductDetails) throws Exception
	{
		Assert.assertTrue(pdpProductDetails.get("color").equalsIgnoreCase(ajaxcartProductDetails.get("color")));
		Assert.assertTrue(pdpProductDetails.get("title").equalsIgnoreCase(ajaxcartProductDetails.get("title")));
		
		if(pdpProductDetails.containsKey("size") && ajaxcartProductDetails.containsKey("size"))
			Assert.assertTrue(pdpProductDetails.get("size").equalsIgnoreCase(ajaxcartProductDetails.get("size")));
	}
	
	public static void verifyProductDetailsPDPCart(HashMap<String, String> pdpProductDetails, HashMap<String, String> cartProductDetails) throws Exception
	{
		Assert.assertTrue(pdpProductDetails.get("color").equalsIgnoreCase(cartProductDetails.get("color")));
		Assert.assertTrue(pdpProductDetails.get("title").equalsIgnoreCase(cartProductDetails.get("title")));
		Assert.assertTrue(pdpProductDetails.get("price").equalsIgnoreCase(cartProductDetails.get("price")));
		
		if(pdpProductDetails.containsKey("size") && cartProductDetails.containsKey("size"))
			Assert.assertTrue(pdpProductDetails.get("size").equalsIgnoreCase(cartProductDetails.get("size")));
		
		if(pdpProductDetails.containsKey("quantity") && cartProductDetails.containsKey("quantity"))
			Assert.assertTrue(pdpProductDetails.get("quantity").equalsIgnoreCase(cartProductDetails.get("quantity")));
		
	}
	
	public static void verifyProductTitle(String str1, String str2) throws Exception
	{
		Assert.assertTrue(str1.equalsIgnoreCase(str2));
	}
}