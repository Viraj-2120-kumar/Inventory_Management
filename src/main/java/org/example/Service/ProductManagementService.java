package org.example.Service;

import org.example.operations.addProduct;
import org.example.operations.ViewAllProducts;
import org.example.util.DBConnection;

import java.sql.Connection;
import java.util.Scanner;

public class ProductManagementService {

    public static void main(String[] args) {

        try (Connection con = DBConnection.getConnection()) {

            Scanner sc = new Scanner(System.in);

            addProduct addProductt = new addProduct();
            ViewAllProducts viewAllProducts = new ViewAllProducts();

            while (true) {

                System.out.println("\n===== PRODUCT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Product");
                System.out.println("2. View All Products");
                System.out.println("3. Exit");
                System.out.print("Choose Option: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        addProductt.execute(con);
                        break;

                    case 2:
                        viewAllProducts.execute(con);
                        break;

                    case 3:
                        System.out.println("Exiting Application...");
                        return;

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}