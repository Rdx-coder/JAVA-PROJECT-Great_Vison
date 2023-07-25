

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminTradeShow
 */
@WebServlet("/AdminTradeShow")
public class AdminTradeShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indore","root","123456");
			String qr="select * from clienttradedata";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align='center' border='1px' >");
				do
				{
					int id=rs.getInt("id");
					String email=rs.getString("email");
					String date=rs.getString("date");
					String stockname=rs.getString("stockname");
					int buyprice=rs.getInt("buyprice");
					int buyquantity=rs.getInt("buyquantity");
					int sellprice=rs.getInt("sellprice");
					int sellquantity=rs.getInt("sellquantity");
					int profit=rs.getInt("profit");
					int loss=rs.getInt("loss");
					out.println("<tr>");
					out.println("<td>Id</td> ");
					out.println("<td>Email</td> ");
					out.println("<td>Date</td>");
					out.println("<td>Stock Name</td>");
					out.println("<td>Buy Price</td>");
					out.println("<td>Buy Quantity</td>");
					out.println("<td>Sell Price</td>");
					out.println("<td>Sell Quantity</td> ");
					out.println("<td>Profit</td> ");
					out.println("<td>Loss</td> ");
					out.println("</tr>");
					out.println("<form action=AdminTradeShowUpdate >");
					out.println("<tr>");
					out.println("<td>");
					out.println(id+"<input type=hidden name=id value="+id+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=date value="+email+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=date value="+date+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=stockname value="+stockname+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=buyprice value="+buyprice+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=buyquantity value="+buyquantity+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=sellprice value="+sellprice+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=sellquantity value="+sellquantity+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=profit value="+profit+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=loss value="+loss+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=submit value=Update />");
					out.println("</td>");
					out.println("</form>");
					out.println("<td>");
					out.println("<a href=AdminTradeShowDelete?id="+id+">Delete</a>");
					out.println("</td>");
					out.println("</tr>");
					
				}while(rs.next());
				out.println("</table>");
			}
			else
			{
				out.println("no records found");
			}
			con.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			out.println(e);
		}

	}

}
