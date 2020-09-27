import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*;
import java.sql.*;

public class LoginServ1 extends HttpServlet {
String soob;//Переменная для сохранения сообщений блоков catch
int i;
private Connection con = null; // соединение с БД
private Statement s = null; // оператор
private String sql=null;
// Загрузка драйвера JDBC
 public void init() { 
try {
Class.forName("com.mysql.jdbc.Driver").newInstance();
}
catch (ClassNotFoundException e) {   
soob=e.toString();
}
catch (Exception e) { 
soob=e.toString();
}
}
public void doGet(HttpServletRequest request, 
HttpServletResponse response) 
throws ServletException, IOException { 
sendLoginForm(response, false);
}
private void sendLoginForm(HttpServletResponse response, 
boolean withErrorMessage) throws ServletException, IOException {

response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD>");
out.println("<TITLE>Login</TITLE>");
out.println("</HEAD>");
out.println("<BODY>");
out.println("<CENTER>");

if (withErrorMessage) out.println("Login failed. Please try again.<BR>");
out.println("<BR>");
out. println("<BR><H2>Login Page</H2>");
out.println("<BR>");
out.println("<BR>Please enter your user name and password.");
out.println("<BR>");
out.println("<BR><FORM METHOD=POST>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TD>User Name:</TD>");
out. println( "<TD><INPUT TYPE=TEXT NAME=userName></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD>Password:</TD>");
out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<BR>Please enter number:");
out.println("<BR>1 - Displaying All Countries, 2 - Insert country, 3 - Delete ountry, 4 - Quit.");
out.println("<TD>Nomer:</TD>");
out. println( "<TD><INPUT TYPE=TEXT NAME=nomer></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD ALIGN=RIGHT COLSPAN=2>");
out.println("<INPUT TYPE=SUBMIT VALUE=Login></TD>");
out.println("</TR>");
out. println( "</TABLE>");
out.println("</FORM>");
out.println("</CENTER>");
out.println("</BODY>");
out.println("</HTML>");
}

public void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String us= request.getParameter("userName");
String pass = request.getParameter("password"); 
String nom = request.getParameter("nomer"); 
out.println(soob+ "<BR>");//вывод сообщения
i=Integer.parseInt(nom);
if (login(us, pass))
 {
if (i==1)
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet7");
else
if (i==2)
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet8");
else
if (i==3)
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet9");
else
if (i==4){
RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet6");
rd.forward(request, response);}
}
else {
sendLoginForm(response, true);
}
}

boolean login(String userName, String password) { 
try
{
String url = "jdbc:mysql://localhost:3306/map";
con = DriverManager.getConnection(url, "root", "");
s= con.createStatement();
sql = "SELECT userName FROM Users WHERE UserName="+"'"+userName+"'"+" AND Password="+"'"+password+"'"; 
ResultSet rs = s.executeQuery(sql); 
if (rs.next()){ 
rs.close();
s.close();
con.close(); 
return true;
} 
rs.close();
s.close();
con.close();
return false;
}
catch (SQLException e) { 
soob=e.toString();
}
catch (Exception e) { 
soob=e.toString();
}
return false;
}}


