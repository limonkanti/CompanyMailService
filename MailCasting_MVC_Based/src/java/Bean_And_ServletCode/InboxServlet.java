package Bean_And_ServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class InboxServlet extends HttpServlet 
{

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession();
        String sender = (String) session.getAttribute("username");
        out.println(sender);
      
            InboxDao in = new InboxDao();
            //session.setAttribute("username", in.viewData(sender));
            req.setAttribute("user", in.viewData(sender));

            RequestDispatcher rd = req.getRequestDispatcher("view_inbox.jsp");
            rd.forward(req, res);
      

    }

}
