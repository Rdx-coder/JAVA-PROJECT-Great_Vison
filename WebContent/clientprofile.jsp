<%
String email=(String) session.getAttribute("id");//downcasting
%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@include file="db.jsp" %>
<%int total=0; %>
<%
String qr="select * from client where email='"+email+"'";
Statement st=con.createStatement();
ResultSet rs=st.executeQuery(qr);
if(rs.next())
{
	RequestDispatcher rd=request.getRequestDispatcher("clientprofile.html");
	rd.include(request, response);
	
	do
	{
		String name=rs.getString("name");
		//String email=rs.getString("email");
		String mobile=rs.getString("mobile");
		String dob=rs.getString("dob");
		String pan=rs.getString("pan");
		String account=rs.getString("account");
		%>
		<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.card {
box-shadow: 0 2px 5px 0 rgba(173, 181, 189, 0.6) !important;
  max-width: 300px;
  margin: auto;
  text-align: center;
  background-color: #ff9a44;
  font-family-sans-serif: "Lato", sans-serif;
  
}

.title {
  color: grey;
  font-size: 18px;
}

button {
  border: none;
  outline: 0;
  display: inline-block;
  padding: 8px;
  color: white;
  background-color: #000;
  text-align: center;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

a {
  text-decoration: none;
  font-size: 22px;
  color: black;
}

button:hover, a:hover {
  opacity: 0.7;
}
</style>
</head>
<body>

<h2 style="text-align:center">Profile</h2>

<div class="card">
  <img src="rubic/public_html/assets/imgs/avatar2.jpg" alt="img" style="width:30%">
 
  <p class="title"><%=name %></p>
  <p><h3>Name : <%=name %></h3></p>
  <p><h3>EMAIL : <%=email %></h3></p>
  <p><h3>MOBILE NUMBER : <%=mobile %></h3></p>
  <p><h3>DATE OF BIRTH   :  <%=dob %></h3></p>
  <p><h3>PAN  CARD NUM. : <%=pan %></h3></p>
  <p><h3>ACCOUNT NUMBER : <%=account %></h3></p>
  
  <div style="margin: 24px 0;">
    <a href="#"><i class="fa fa-dribbble"></i></a> 
    <a href="#"><i class="fa fa-twitter"></i></a>  
    <a href="#"><i class="fa fa-linkedin"></i></a>  
    <a href="#"><i class="fa fa-facebook"></i></a> 
  </div>
  <p><button>Edit Profile</button></p>
</div>


</body>
</html>
		<%
	}while(rs.next());
}
else
{
	out.println("error found");
}
%>