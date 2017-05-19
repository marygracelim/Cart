package com.amaysin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class CartTest {
	ICart cart;
	PromoRule rule = new PromoRule();
	List<Product> productList;
	Product product1;
	Product product2;
	
	final static String SMALL = "ult_small";
	final static String MEDIUM = "ult_medium";
	final static String LARGE = "ult_large";
	final static String ONE_GB = "1gb";
	
	Map<String, Double> productPriceMap;

	@Before
	public void setUp() throws Exception {
		cart = new Cart(rule);
		productList = new ArrayList<Product>();
		
		productPriceMap = new HashMap<String, Double>();
		productPriceMap.put(SMALL, 24.90);
		productPriceMap.put(MEDIUM, 29.90);
		productPriceMap.put(LARGE, 44.90);
		productPriceMap.put(ONE_GB, 9.90);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void scenarioTest1() {
		
		System.out.println("*************** SCENARIO 1*************** ");
		
		int qty1 = 3;
		product1 = new Product();
		product1.setProductCode(SMALL);
		product1.setProductName("Unlimited 1GB");
		product1.setQty(qty1);
		product1.setProductPrice(qty1*productPriceMap.get(SMALL));
		cart.add(product1);

		product2 = new Product();
		product2.setProductCode(LARGE);
		product2.setProductName("Unlimited 5GB");
		product2.setQty(1);
		product2.setProductPrice(1*productPriceMap.get(LARGE));
		cart.add(product2);

		showCartDetails(cart.getCartItem());
		
		productList = cart.getCartTotal();
		
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartProcessDetails(productList);
		
		showCartTotal(productList);
		
		
	}
	
	@Test
	public void scenarioTest2(){
		System.out.println("*************** SCENARIO 2*************** ");
		int qty1 = 2;
		product1 = new Product();
		product1.setProductCode(SMALL);
		product1.setProductName("Unlimited 1GB");
		product1.setQty(qty1);
		product1.setProductPrice(qty1*productPriceMap.get(SMALL));
		cart.add(product1);
		
		int qty2 = 4;
		product2 = new Product();
		product2.setProductCode(LARGE);
		product2.setProductName("Unlimited 5GB");
		product2.setQty(qty2);
		product2.setProductPrice(qty2*productPriceMap.get(LARGE));
		cart.add(product2);
		
		showCartDetails(cart.getCartItem());
		
		productList = cart.getCartTotal();
		
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartProcessDetails(productList);
		
		showCartTotal(productList);
	}
	
	@Test
	public void scenarioTest3(){
		System.out.println("***************SCENARIO 3***************");
		int qty1 = 1;
		product1 = new Product();
		product1.setProductCode(SMALL);
		product1.setProductName("Unlimited 1GB");
		product1.setQty(qty1);
		product1.setProductPrice(qty1*productPriceMap.get(SMALL));
		cart.add(product1);
		
		int qty2 = 2;
		product2 = new Product();
		product2.setProductCode(MEDIUM);
		product2.setProductName("Unlimited 2GB");
		product2.setQty(qty2);
		product2.setProductPrice(qty2*productPriceMap.get(MEDIUM));
		cart.add(product2);
		
		showCartDetails(cart.getCartItem());
		
		productList = cart.getCartTotal();
		
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartProcessDetails(productList);
		
		showCartTotal(productList);
	}
	
	@Test
	public void scenarioTest4(){
		System.out.println("*************** SCENARIO 4*************** ");
		String promoCode = "I<3AMAYSIM";
				
		int qty1 = 1;
		product1 = new Product();
		product1.setProductCode(SMALL);
		product1.setProductName("Unlimited 1GB");
		product1.setQty(qty1);
		product1.setProductPrice(qty1*productPriceMap.get(SMALL));
		product1.setPromoCode(promoCode);
		cart.add(product1);
		
		int qty2 = 1;
		product2 = new Product();
		product2.setProductCode(ONE_GB);
		product2.setProductName("1 GB Data-pack");
		product2.setQty(qty2);
		product2.setProductPrice(qty2*productPriceMap.get(ONE_GB));
		product2.setPromoCode(promoCode);
		cart.add(product2);
				
		showCartDetails(cart.getCartItem());
		
		productList = cart.getCartTotal();
		
		Assert.assertTrue("ProductList Empty.", productList.size()>0);
		
		showCartProcessDetails(productList);
		
		showCartTotal(productList);
		
	}
	
	private void showCartDetails(List<Product> pList){
		System.out.println("*****CART ITEMS*****");
		for(Product p: pList){
			System.out.print(p.getQty() + " X ");
			System.out.println(p.getProductName());
		}
	}
	
	private void showCartProcessDetails(List<Product> processList){
		System.out.println("*****CART PROCESS ITEMS*****");
		for(Product p: processList){
			System.out.print(p.getQty() + " X ");
			System.out.println(p.getProductName());
		}
	}
	
	private void showCartTotal(List<Product> pList){
		double price = 0.00d;
		for(Product p: pList){
			price += p.getProductPrice();
		}
		price = Math.round(price* 100.00) / 100.00;
		System.out.println("TOTAL : " + price);
	}

}
