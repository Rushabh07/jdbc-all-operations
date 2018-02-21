/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcopr;

import java.sql.*;
import java.util.*;

public class Jdbcopr 
{
    
    
    public static void main(String[] args) 
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/simple","rishi","welcome123");
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        
        Scanner sc = new Scanner(System.in);
        int ch;
        String id;
        String name;
        Statement st;
        
        do
        {
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Vi1ew");
            System.out.println("0. Exit");
            ch = sc.nextInt();
            
            switch(ch)
            {
                case 1:
                    
                    name = sc.next();
                    
                    try
                    {
                        PreparedStatement pr;
                        pr = con.prepareStatement("insert into simp(name) values(?)");
                        pr.setString(1, name);
                        pr.executeUpdate();
                        pr.close();
                    }
                    catch(Exception ex)
                    {
                    };
                    break;
                    
                case 2:
                    id = sc.next();
                    name = sc.next();
                    
                    try
                    {
                        PreparedStatement up = con.prepareStatement("update simp set name = ? where id = ?");
                        up.setString(1,name);
                        up.setString(2,id);
                        up.executeUpdate();
                        up.close();
                    }
                    catch(Exception ex)
                    {
                    };
                    break;
                    
                case 3:
                    id = sc.next();
                                        
                    try
                    {
                        PreparedStatement del = con.prepareStatement("delete from simp where id=?");
                        del.setString(1, id);
                        del.executeUpdate();
                        del.close();
                    }
                    catch(Exception ex)
                    {
                    };
                    break;
                
                case 4:
                    try
                    {
                        st=con.createStatement();
                        ResultSet rs = st.executeQuery("select * from simp");
                        while(rs.next())
                        {
                            System.out.println(rs.getString(1));;
                            System.out.println(rs.getString(2));;
                        }
                    }
                    catch(Exception e)
                    {
                        
                    };
                    break;
                    
                case 0:
                    break;
            }
            
            
        }while(ch != 0);
    }
    
}