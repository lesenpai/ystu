import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
import java.util.*;
import java.sql.*;

public class WelcomeServlet81 extends HttpServlet { 
private Connection con = null; // соединение с БД
private Statement s = null; // оператор
private String sql=null;
String soob;//Переменная для сохранения сообщений блоков catch
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
 HttpServletResponse response) throws ServletException, IOException
{
response.setContentType("text/html"); 
PrintWriter out = response.getWriter(); 
out.println("<HTML>");
out.println("<HEAD>");
out.println("<TITLE>Registration Page</TITLE>");
out.println("</HEAD>");
out.println("<BODY>");
out.println("<CENTER>");
out.println("<BR>");
out. println("<BR><Registration Page</H2>");
out.println("<BR>");
out.println("<BR>Please enter the countries details.");
out.println("<BR>");
out.println("<BR><FORM METHOD=POST>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TD>ID_CO:</TD>");
out. println( "<TD><INPUT TYPE=TEXT NAME=ID_CO></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD>Name country:</TD>");
out.println("<TD><INPUT TYPE=TEXT NAME=Name></TD>");
out.println("</TR>");
out.println("<TR>");
out. println( "<TD><INPUT TYPE=RESET></TD>");
out. println("<TD><INPUT TYPE=SUBMIT></TD>");
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
String id = request.getParameter("ID_CO");
String name = request.getParameter("Name"); 
out.println(soob+ "<BR>");//вывод сообщения
try
{
String url = "jdbc:mysql://localhost:3306/map";
con = DriverManager.getConnection(url, "root", "");
s= con.createStatement();
sql = "INSERT INTO COUNTRIES (ID_CO, NAME) VALUES ("+id+", '"+name+"')";
s.executeUpdate(sql);
s.close(); 
con.close();
}
catch (SQLException e) { 
soob=e.toString();
}
catch (Exception e) { 
soob=e.toString();
}
//response.sendRedirect("http://localhost:8080/myJSPApp/jsp/vvod.jsp");
RequestDispatcher rd = request.getRequestDispatcher("/jsp/vvod.jsp");
rd.forward(request, response);
}}

