package org.example.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProductPrice {

    public void execute(Connection con) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Product ID to update price: ");
            int id = sc.nextInt();

            System.out.print("Enter New Price: ");
            double newPrice = sc.nextDouble();

            String sql = "UPDATE products SET price = ? WHERE product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, newPrice);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Product price updated successfully!");
            } else {
                System.out.println(" Product not found!");
            }

        } catch (Exception e) {
            System.out.println("Error updating product price!");
            e.printStackTrace();
        }
    }
}