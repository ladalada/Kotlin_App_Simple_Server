import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet
import javax.servlet.http.*;

@WebServlet(name="Main", value= ["/main"])
open class Main: HttpServlet(){
    override fun doGet(req:HttpServletRequest, res:HttpServletResponse){
        val path = "/pages/page.jsp"
        val servletContext = servletContext
        val dispacher = servletContext.getRequestDispatcher(path)
        dispacher.forward(req,res)
    }
}