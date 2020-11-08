package application;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.ProductItemList;
import model.entities.Products;
import model.resource.ProductsFile;
import model.resource.SubtotalFile;

public class Program {

	public static void main(String[] args) throws Exception {
		Locale setLocale = Locale.US;
		Scanner sc = null;
		boolean tests, novoProduto = true;

		try {
			sc = new Scanner(System.in);

			ProductsFile pf = new ProductsFile();

			System.out.println("Deseja utilizar os produtos já cadastrados?(true)"
					+ "\nCadastrar novos produtos?(false)" + "\n Digite (true/false)");

			tests = Boolean.parseBoolean(sc.nextLine());

			ProductItemList i = new ProductItemList();

			while (novoProduto == true) {

				System.out.println("Nome do produto:");
				String prod = sc.nextLine();
				System.out.println("Marca do produto:");
				String b = sc.nextLine();
				System.out.println("Preço do produto:");
				Double pr = Double.parseDouble(sc.nextLine());
				System.out.println("Quantidade do produto:");
				int q = Integer.parseInt(sc.nextLine());

				Products p = new Products(prod, b, pr, q);

				i.addItem(p);

				System.out.println("Deseja cadastrar mais um produto? (true/false)");
				novoProduto = Boolean.parseBoolean(sc.nextLine());

			}

			pf.CreateProductFile(i, tests);

			System.out.println("Arquivo Products salvo com sucesso");

			System.out.println("\n \nLeitura do arquivo Products.csv :");
			pf.ReadFile();

			System.out.println("Fim do arquivo Products");

			SubtotalFile sb = new SubtotalFile();

			sb.CreateProductFile();

			sb.ReadFileSub();

		}

		catch (InputMismatchException e) {
			System.out.println("Input Missmatch: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		finally {
			sc.close();
		}
	}

}
