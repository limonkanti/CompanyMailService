
package Bean_And_ServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.classfmt.ClassFileConstants;

public class ControllerRegServlet extends HttpServlet
{
    
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String uname=req.getParameter("uname");
        String contact=req.getParameter("ucontact");
        int ucontact=Integer.valueOf(contact);
       // int urcontact=req.getIntHeader("urcontact");
        String upass=req.getParameter("upass");
        String urpass=req.getParameter("urpass");
        String uemail=req.getParameter("uemail");
        //String sud=req.getParameter("sud");
       // String ugender=req.getParameter("ugender");
       
        UserBean ub=new UserBean();
        ub.setUname(uname);
        ub.setUcontact(ucontact);
        ub.setUpass(upass);
        ub.setUrpass(urpass);
        ub.setUemail(uemail);
       // ub.setUselect(sud);
        //ub.setUgender(ugender);
        req.setAttribute("ub",ub);
        int i=RgisterDao.register(ub);
        if(i>0)
        {
           // pw.println("You have successfully registered.");
            String register="You have successfully registered.";
            req.setAttribute("register", register);
            RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
            rd.forward(req, res);
        }
        else
        {
            String regfalse="Sorry!!! Registration failed. Please try later";
            req.setAttribute("regfalse", regfalse);
            RequestDispatcher rd=req.getRequestDispatcher("register.jsp");
            rd.include(req, res);
        }
        
        
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        doPost(req,res);
        
    }


}
