
package Bean_And_ServletCode;

import java.sql.*;

public class LoginDao
{
    public static boolean validate(UserBean login)
    {
        boolean status=false;
        try
        {
            Connection con=ConnectionProvier.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT uemail,upass from registration2 where uemail=? and upass=?");
            ps.setString(1, login.getUemail());
            ps.setString(2, login.getUpass());
            ResultSet rs=ps.executeQuery();
            status=rs.next();
            
            
        }
        catch(Exception e)
        {
            System.out.println("Error is :\t"+e.toString());
        }
        return status; 
    }
    
}
