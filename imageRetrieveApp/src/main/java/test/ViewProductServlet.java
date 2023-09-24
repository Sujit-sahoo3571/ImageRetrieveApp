package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/viewproduct")
public class ViewProductServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		ArrayList<ProductBean> pbs = new ViewProductDAO().viewProduct();
		
		if(pbs.size() == 0 ) {
			pw.print("No Product available " );
		}else {
			req.setAttribute("pblist", pbs);
			req.getRequestDispatcher("viewsuccess.jsp").forward(req, resp);
	
		}
		
	}

}
