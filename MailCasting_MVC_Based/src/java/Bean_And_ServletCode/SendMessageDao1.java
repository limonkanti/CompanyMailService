
package Bean_And_ServletCode;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class SendMessageDao1
{
    
   // static int status=0;
   // static int d=1;
     
    public static int sendMsg(ComposeBean cb)
    {
        int status=0;
    // int d=1;
        
        Connection con=ConnectionProvier.getConnection();
        java.util.Date date=Calendar.getInstance().getTime();
        java.sql.Date dat=new java.sql.Date(date.getTime());
        java.util.Date time=new java.util.Date();
        java.sql.Time d=new java.sql.Time(time.getTime());        
        try
        {
            PreparedStatement ps=con.prepareStatement("INSERT INTO inbox3(d,reciever,sender,msg,dat) values(?,?,?,?,?)");
             
             ps.setString(3,cb.getUsender());
		ps.setString(2,cb.getUreciever());
		ps.setString(4,cb.getUmsg());
		ps.setDate(5,dat);
		ps.setTime(1,d);
                
               //ps.setInt(1, d);
            status=ps.executeUpdate();
            
        }
        catch(Exception e)
        {
            System.out.println("Error is:\t"+e.toString());
        }
        
        return status;
    }
    
    
}
