package com.amaysin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amaysin.Product;

public class PromoRule {
		
	private static Map<String, Integer> productPromoMap;
	static{
		productPromoMap = new HashMap<String, Integer>();
		productPromoMap.put("ult_small", 1);
		productPromoMap.put("ult_medium", 2);
		productPromoMap.put("ult_large", 3);
		productPromoMap.put("1gb", 4);
	}
	
	public List<Product> applyPromo(List<Product> productList){
		//System.out.println("------apply promo start =");
		List<Product> pList = new ArrayList<Product>();
		
		for(Product prodItem: productList){
//			System.out.println("------PRODUCT CODE ="+ prodItem.getProductCode());
//			System.out.println("------PRODUCT NAME ="+ prodItem.getProductName());
			
			switch (productPromoMap.get(prodItem.getProductCode())){
				case 1: 
						applyPromo1GB(prodItem, pList);
						break;
				case 2:
						applyPromo2GB(prodItem, pList);
						break;
				case 3:
						applyPromo5GB(prodItem, pList);
						break;
				default:
					applyProduct(prodItem, pList);
					break;
			}
			
		}
		//System.out.println("------apply promo end =");
		return pList;
	}
	
	public List<Product> applyPromo1GB(Product product, List<Product> pList){
		
		if(product.getQty() % 3 == 0){
			product.setProductPrice(2 * (product.getQty()/3) * product.getProductPrice()/product.getQty());
			applyPromoCode(product);
			pList.add(product);
		}else{
			applyPromoCode(product);
			pList.add(product);
		}
		
		return pList;
	}
	
	public List<Product> applyPromo2GB(Product product, List<Product> pList) {
		
		applyPromoCode(product);
		pList.add(product);
		
		if(product.getQty()>0){
			Product p = new Product();
			p.setProductCode("1GB");
			p.setProductName("1 GB Data-pack");
			p.setQty(product.getQty());
			
			pList.add(p);
		}
		
		return pList;
	}
	
	public List<Product> applyPromo5GB(Product product, List<Product> pList){
		
		if(product.getQty()>3){
			product.setProductPrice(product.getQty() * 39.90);
			applyPromoCode(product);
			pList.add(product);
		}else{
			applyPromoCode(product);
			pList.add(product);
		}
		
		return pList;
	}
	
	public List<Product> applyProduct(Product product, List<Product> pList){
		
		applyPromoCode(product);
		pList.add(product);

		return pList;
	}
	public void applyPromoCode(Product product){
		String pCode = "I<3AMAYSIM";
		double discountPrice = product.getProductPrice() - (product.getProductPrice() * .1);
		
		if(pCode.equals(product.getPromoCode())){
			product.setProductPrice(discountPrice);
			
		}
	}
}
