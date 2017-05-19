package com.amaysin;

import java.util.ArrayList;
import java.util.List;

public class Cart implements ICart {
	PromoRule rule;
	List<Product> productList;
	List<Product> productProcessList;
	Product product;
	
	public Cart(PromoRule rule){
		this.rule = rule;
		this.productList = new ArrayList<Product>();
		this.productProcessList = new ArrayList<Product>();
	}

	@Override
	public void add(Product product){
		productList.add(product);
	}

	@Override
	public List<Product> getCartItem(){
		return productList;
	}
	
	@Override
	public List<Product> getCartTotal(){
		
		productProcessList = rule.applyPromo(productList);
		//System.out.println("*****CART.getCartTotal*****");
//		for(Product p: productProcessList){
//			System.out.print(p.getQty() + " X ");
//			System.out.println(p.getProductName());
//		}
		
		return productProcessList;
	}
	
	@Override
	public List<Product> getCartProcessItem(){
		
		System.out.println("*****CART.getCartProcessItem*****");
		for(Product p: productProcessList){
			System.out.print(p.getQty() + " X ");
			System.out.println(p.getProductName());
		}
		return productProcessList;
	}
}
