package model.resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import model.entities.ProductItemList;

public class ProductsFile {

	File file = new File("Products.csv");
	
	public void ReadFile() {

		Scanner sc = null;
		

		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

		}
		
		catch (IOException e) {
			System.out.println("Error " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Error " + e.getMessage());
		}

		finally {
			if (sc != null) {
				sc.close();

			}

		}

	}

	public void CreateProductFile(ProductItemList lp, boolean tests) throws IOException {

		Boolean newFile = tests;
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, newFile))) {

			bw.write(lp.toString());

		}

		catch (IOException e) {
			System.out.println("Produtos: " + e.getMessage());
		}

	}

}
