package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/addproduct")
public class AddProductServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		int k  = new AddProductDAO().insert(req);
		if(k > 0 ) {
			req.setAttribute("msg", "Product added successfully " );
			req.getRequestDispatcher("addsuccess.jsp").forward(req, resp);
		}
		else {
			pw.print("some thing went wrong unable to add product now  " );
		}
	
	}
	
	
	
}



