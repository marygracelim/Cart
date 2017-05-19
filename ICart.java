package com.amaysin;

import java.util.List;

public interface ICart {
	
	public void add(Product item);
	
	public List<Product> getCartTotal();
	
	public List<Product> getCartItem();
		
	public List<Product> getCartProcessItem();
		
	}
