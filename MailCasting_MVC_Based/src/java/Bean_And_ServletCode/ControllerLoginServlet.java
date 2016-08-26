

package Bean_And_ServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ControllerLoginServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        res.setContentType("text/html");
        PrintWriter pw=res.getWriter();
        String uemail=req.getParameter("uemail");
        String upass=req.getParameter("upass");
        UserBean ub=new UserBean();
        ub.setUemail(uemail);
        ub.setUpass(upass);
        req.setAttribute("ub",ub);
        boolean status=LoginDao.validate(ub);
        if(status==true)
        {
           
            HttpSession session=req.getSession();
            session.setAttribute("username", uemail);
            RequestDispatcher rd=req.getRequestDispatcher("home.jsp");
            rd.forward(req, res);
        }
        else
        {
           
            pw.println("Please enter correct E-mail and Password.");
            RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
            rd.include(req, res);
        }
        
        
        
    }
    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
    {
        doPost(req,res);
        
    }

}
