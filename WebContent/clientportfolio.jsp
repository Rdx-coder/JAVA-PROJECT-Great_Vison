<%
String email=(String) session.getAttribute("id");//downcasting
%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@include file="db.jsp" %>
<%int total=0; %>
<div>
<%
String qr="select * from clienttradedata where email='"+email+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
if(rs.next())
{	%>
	
<div style="height: 150px;width: 100%;float: left; box-shadow: 0 2px 5px 0 rgba(173, 181, 189, 0.6) !important;background-color: #ff9a44;color: white;text-align: center;margin: 5px  ">

<table align="center"   border="5px" >
		<tr style="width:auto;">
		<td>Date</td>
		<td>Stock Name</td>
		<td>Buy Price</td>
		<td>Buy Quantity</td>
		<td>Sell Price</td>
		<td>Sell Quantity</td> 
		<td>Profit</td> 
		<td>Loss</td> 
 		</tr>
 		
 	<% 
	do
	{
		
			String date=rs.getString("date");
			String stockname=rs.getString("stockname");
			int buyprice=rs.getInt("buyprice");
			int buyquantity=rs.getInt("buyquantity");
			int sellprice=rs.getInt("sellprice");
			int sellquantity=rs.getInt("sellquantity");
			int profit=rs.getInt("profit");
			int loss=rs.getInt("loss");
			total=total+buyprice;
		%>
			<tr>
			<td><%=date %></td>
			<td><%=stockname %></td>	
			<td><%=buyprice %></td>
			<td><%=buyquantity %></td>
			<td><%=sellprice %></td>
			<td><%=sellquantity %></td>	
			<td><%=profit %></td>	
			<td><%=loss %></td>	
					
			</tr>
			<%
	}
	while(rs.next());
 	%>
	</table>
	</div>
	<%
}
else
{
	out.println("no records found");
}
%>
