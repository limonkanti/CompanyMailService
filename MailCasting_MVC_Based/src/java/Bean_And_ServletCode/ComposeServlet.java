package Bean_And_ServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ComposeServlet extends HttpServlet
{

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(false);
        String sender = (String) session.getAttribute("username");
        String reciever = req.getParameter("reciever");
        String msg = req.getParameter("msg");
        int i = SendMessageDao.sendMsg(sender, reciever, msg);
        if (i > 0) 
        {
            out.println("Message Sent Sucessfully...");
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.include(req, res);
        } 
        else
        {
            out.print("Sorry,Message was not sent");
            RequestDispatcher rd = req.getRequestDispatcher("compose.jsp");
            rd.include(req, res);
        }

    }

    protected void doget(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException
    {
        doPost(req, res);

    }

}
