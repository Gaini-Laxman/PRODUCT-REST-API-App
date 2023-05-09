package com.klinnovations.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.klinnovations.request.Product;


@Service
public class ProductServiceImpl implements ProductService {

	private Map<Integer, Product> productMap = new HashMap<Integer, Product>();
	private Integer pid = 1;
	
	
	@Override
	public Product RequestProduct(Product product) {
		
		Product p = new Product();
		BeanUtils.copyProperties(product, p);
		
		productMap.put(pid, p);
		
		pid++;
		
		return p;
	}

	@Override
	public Product getProductByNum(Integer pid) {

		if(productMap.containsKey(pid)){
			
			return productMap.get(pid);
		}
		
		
		return null;
	}

}
