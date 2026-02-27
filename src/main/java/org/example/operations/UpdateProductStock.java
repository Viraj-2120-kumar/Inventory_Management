package org.example.operations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateProductStock {

    public void execute(Connection con) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter Product ID to update stock: ");
            int id = sc.nextInt();

            System.out.print("Enter New Quantity: ");
            int quantity = sc.nextInt();

            String sql = "UPDATE products SET quantity = ? WHERE product_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println(" Product stock updated successfully!");
            } else {
                System.out.println(" Product not found!");
            }

        } catch (Exception e) {
            System.out.println("Error updating product stock!");
            e.printStackTrace();
        }
    }
}