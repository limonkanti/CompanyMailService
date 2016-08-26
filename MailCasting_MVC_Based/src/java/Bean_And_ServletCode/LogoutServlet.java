package Bean_And_ServletCode;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet 
{

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        HttpSession session = req.getSession(false);
        session.invalidate();
        out.println("You have been sucessfully logged out");
        RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
        rd.include(req, res);
    }

}
