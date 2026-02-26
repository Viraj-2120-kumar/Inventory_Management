package org.example.operations;

import java.sql.*;
import java.util.*;

public class ViewAllProducts {
    public void execute(Connection con){
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from products");

            int count = 0;
            System.out.println("\nID | Name | Category | Price | Qty | Rating | Manufacturer | Cr");

            while(rs.next()){
                count++;
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3) + " | " +
                                rs.getDouble(4) + " | " +
                                rs.getInt(5) + " | " +
                                rs.getDouble(6) + " | " +
                                rs.getString(7) + " | " +
                                rs.getTimestamp(8)
                );
            }

            if(count==0){
                System.out.println("No products is found");
            }
            else {
                System.out.println("Total Products: " + count);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
