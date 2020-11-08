package model.resource;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.entities.ProductItemList;
import model.entities.Products;

public class SubtotalFile {

	private String n, b;
	private Double price;
	private Integer qty;
	private Double subtotal;

	File prod = new File("Products.csv");
	File sub = new File("Subtotal.csv");

	List<Products> pl = new ArrayList();

	public void ReadFileSub() {

		Scanner sc = null;

		try {
			sc = new Scanner(sub);

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

	public void CreateProductFile() throws Exception {

		Scanner sc = new Scanner(prod);

		while (sc.hasNextLine()) {
			String[] vect = sc.nextLine().split(",");
			n = vect[0];
			b = vect[1];
			subtotal = price = Double.parseDouble(vect[2]) * Integer.parseInt(vect[3]);

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(sub, true))) {

				bw.write(n + "," + b + "," + subtotal);
				bw.newLine();

			}

			catch (Exception e) {
				System.out.println("Subtotal: " + e.getMessage());

			} finally {

			}

		}
		sc.close();

	}

}
