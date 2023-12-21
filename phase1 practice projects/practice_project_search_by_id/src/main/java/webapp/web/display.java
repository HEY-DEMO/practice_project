package webapp.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.db.DatabaseConnection;

/**
 * Servlet implementation class ListProducts
 */
@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Get all products from db and show as table.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set content type
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String productid = request.getParameter("product_id");
		DatabaseConnection db = null;
		
		try {
			// step 1: create connection
			db = new DatabaseConnection();
			db.init();
			
			// step 2: create statement and execute query 
			String query = "SELECT * from products where product_id="+productid;
			ResultSet rst = db.executeQuery(query);
			
			request.getRequestDispatcher("index.jsp").include(request, response);
			if(rst != null && rst.next()) {
				out.print("<div style='text-align:center;border:2px solid green; padding:20px;'>");
				while (rst.next()) {
					out.print("<div style='text-align:center;border:2px solid black; padding:5px; margin: auto 10%'>");
					out.print("<p>" + rst.getInt("product_id") + "  ,  "+ rst.getString("product_name") + 
							"  ,  " + rst.getString("quantity") +"  ,  "+rst.getString("product_desc"));
					out.print("</div>");
				}
			}else {
				out.print("<div style='text-align:center;border:2px solid green; padding:20px;'>");
				out.print("<p>product not found</p> ");
				out.print("</div>");
			}
			out.print("</div>");
		} catch (Exception e) {
			 e.printStackTrace();
			out.println("<h2> Exception Occured </h2>");
		} finally {
			out.close();
			db.close();
		}
	}
}