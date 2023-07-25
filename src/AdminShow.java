

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
 * Servlet implementation class Show
 */
@WebServlet("/AdminShow")
public class AdminShow extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/indore","root","123456");
			String qr="select * from client";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(qr);
			if(rs.next())
			{
				out.println("<table align='center' border='1px' >");
				do
				{
					String name=rs.getString("name");
					String email=rs.getString("email");
					String mobile=rs.getString("mobile");
					String dob=rs.getString("dob");
					String pan=rs.getString("pan");
					String account=rs.getString("account");
					String pwd=rs.getString("pwd");
					out.println("<tr>");
					out.println("<td>Mobile</td> ");
					out.println("<td>name</td> ");
					out.println("<td>email</td> ");
					out.println("<td>dob</td> ");
					out.println("<td>pan</td> ");
					out.println("<td>account</td> ");
					out.println("<td>Password</td> ");
					
					out.println("</tr>");
					
					out.println("<form action=ClientDataDelete >");
					out.println("<tr>");
					out.println("<td>");
					out.println(mobile+"<input type=hidden name=mobile value="+mobile+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=name value="+name+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=email value="+email+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=dob value="+dob+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=pan value="+pan+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=number name=account value="+account+" />");
					out.println("</td>");
					out.println("<td>");
					out.println("<input type=text name=pwd value="+pwd+" />");
					out.println("</td>");
					out.println("</form>");
					out.println("<td>");
					out.println("<a href=ClientDataDelete?mobile="+mobile+">Delete</a>");
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
