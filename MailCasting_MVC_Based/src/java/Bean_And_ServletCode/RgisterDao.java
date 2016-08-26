
package Bean_And_ServletCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class RgisterDao 
{
    
     public static int register(UserBean r)
    {
        int i=0;
        try
        {
            Connection con=ConnectionProvier.getConnection();
            PreparedStatement ps=con.prepareStatement("INSERT INTO registration2(uname,ucontact,upass,urpass,uemail) values(?,?,?,?,?)");
            ps.setString(1, r.getUname());
            ps.setInt(2, r.getUcontact());
            ps.setString(3, r.getUpass());
            ps.setString(4, r.getUrpass());
            ps.setString(5, r.getUemail());
           // ps.setString(6, r.getUselect());
           // ps.setString(7, r.getUgender());
            i=ps.executeUpdate();
            
            
            
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:\n"+e.toString());
            
        }
        return i; 
    }
    }
    

