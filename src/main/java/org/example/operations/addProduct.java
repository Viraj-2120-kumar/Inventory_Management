package org.example.operations;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class addProduct {

    public void execute(Connection con) {

        try {
            Scanner sc = new Scanner(System.in);
            Statement stmt = con.createStatement();

            System.out.print("Product ID: ");
            int id = sc.nextInt();

            System.out.print("Product Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            System.out.print("Quantity: ");
            int quantity = sc.nextInt();

            System.out.print("Rating (1-5): ");
            double rating = sc.nextDouble();

            sc.nextLine();
            System.out.print("Manufacturer: ");
            String manufacturer = sc.nextLine();

            String query = "INSERT INTO products VALUES(" +
                    id + "," + name + "," + category + "," +
                    price + "," + quantity + "," +
                    rating + "," + manufacturer + "NOW())";

            int rows = stmt.executeUpdate(query);

            if (rows > 0)
                System.out.println("Product Added Successfully!");
            else
                System.out.println(" Failed to Add Product!");

        } catch (Exception e) {
            System.out.println("Error Adding Product!");
            e.printStackTrace();
        }
    }
}