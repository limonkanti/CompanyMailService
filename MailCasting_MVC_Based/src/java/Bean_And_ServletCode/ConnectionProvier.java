
package Bean_And_ServletCode;

import static Bean_And_ServletCode.Provider.*;
import java.sql.*;


public class ConnectionProvier 
{
    private static Connection con=null;
    
    public static Connection getConnection()
    {
        try
        {
            
        Class.forName(driver);
        con=DriverManager.getConnection(url,name,pass);
        
        }
        catch(Exception e)
        {
            System.out.println("Error is:\n"+e.toString());
        }
        
        return con;
    }
    
}
