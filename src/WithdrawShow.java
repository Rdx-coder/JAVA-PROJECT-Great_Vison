

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
 * Servlet implementation class WithdrawShow
 */
@WebServlet("/WithdrawShow")
public class WithdrawShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indore","root","123456");
			String qr="select * from withdraw";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align='center' border='1px' >");
				do
				{
					String refrence_id=rs.getString("refrence_id");
					String m_pin=rs.getString("m_pin");
					String account_no=rs.getString("account_no");
					String account_holder_name=rs.getString("account_holder_name");
					String upi_id=rs.getString("upi_id");
					String amount=rs.getString("amount");					
					
					out.println("<form action=WithdrawShowUpdate method=post >");
					out.println("<tr>");
					out.println("<td>");
					out.println(account_no+"<input type=hidden name=refrence_id value="+account_no+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=number name=m_pin value="+m_pin+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=number name=account_holder_name value="+account_no+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=account_holder_name value="+account_holder_name+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=upi_id value="+upi_id+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=number name=amount value="+amount+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=submit value=Update />");
					out.println("</td>");
					out.println("</form>");
					out.println("<td>");
					out.println("<a href=WithdrawShowDelete?account_no="+account_no+">Delete</a>");
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
