
package Bean_And_ServletCode;

import java.sql.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class InboxDao 
{
    
    public ArrayList viewData(String sender)
    {
       ArrayList<ComposeBean>  list=new ArrayList<ComposeBean>();
        Connection con;
        PreparedStatement ps;
        ResultSet rs;
       
        try{
            
            
             con=ConnectionProvier.getConnection();
             ComposeBean ab=null;
          
             ps=con.prepareStatement("SELECT d,reciever,msg,dat from inbox2 where sender= '" + sender + "'");
             ps.setString(1, sender);
             rs=ps.executeQuery();
             while(rs.next())
             {
                 ab=new ComposeBean();
                 ab.setUd(rs.getString("d"));
                 ab.setUreciever(rs.getString("reciever"));
                 ab.setUmsg(rs.getString("msg"));
                 ab.setUdat(rs.getString("dat"));
               
                 list.add(ab);
                 
                 
             }
             
             
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:\n"+e.getMessage());
        }
        return list;
    }
    
}
