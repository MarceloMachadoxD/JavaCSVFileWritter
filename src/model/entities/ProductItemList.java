package model.entities;

import java.util.ArrayList;
import java.util.List;

public class ProductItemList {
	List<Products> lp = new ArrayList<Products>();

	public ProductItemList() {
	}

	public ProductItemList(List<Products> lp) {
		this.lp = lp;
	}

	public void addItem(Products p) {
		lp.add(p);
	}


	
	
	@Override
	public String toString() {
		String produtos = "";

		for (Products lp : lp) {
			produtos += lp;
		}
		return produtos;
	}
	

}
