import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(name="LastDate", value= ["/last-date"])
open class LastDate: HttpServlet(){
    override fun doGet(req: HttpServletRequest, res: HttpServletResponse){
        val path = "/pages/date.jsp"
        val servletContext = servletContext
        val dispacher = servletContext.getRequestDispatcher(path)
        dispacher.forward(req,res)
    }
}