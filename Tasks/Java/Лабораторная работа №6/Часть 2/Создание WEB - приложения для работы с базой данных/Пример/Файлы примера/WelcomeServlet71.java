import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*;
import java.util.*;
import java.sql.*;

public class WelcomeServlet71 extends HttpServlet { 
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
out.println("<TITLE>Display All Countries</TITLE>");
 out.println("</HEAD>"); 
out.println("<BODY>"); 
out.println("<CENTER>");
out.println("<BR><H2>Displaying All Countries</H2>");
out.println("<BR>");
out.println("<BR>");
out.println("<BR><FORM METHOD=POST>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TH>ID_CO</TH>");
out.println("<TH>NAME</TH>");
out.println("</TR>");

try
{
String url = "jdbc:mysql://localhost:3306/map";
con = DriverManager.getConnection(url, "root", "");
s= con.createStatement();
sql = "SELECT ID_CO, NAME FROM COUNTRIES";
ResultSet rs = s.executeQuery(sql);
while (rs.next()) { 
out.println("<TR>");
out.println("<TD>" + rs.getString(1) + "</TD>");
 out.println("<TD>" + rs.getString(2) + "</TD>");
 out.println("</TR>");
}
rs.close();
s.close(); 
con.close();
}
catch (SQLException e) { 
soob=e.toString();
}
catch (Exception e) { 
soob=e.toString();
}
out.println("<TR>");
out.println("<TD ALIGN=RIGHT COLSPAN=2>");
out.println("<INPUT TYPE=SUBMIT VALUE=exit></TD>");
out.println("</TR>");
out.println("</TABLE>");
 out.println("</CENTER>"); 
out.println("</BODY>");
 out.println("</HTML>");
}

public void doPost(HttpServletRequest request, 
HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println(soob+ "<BR>");//вывод сообщения
//response.sendRedirect("http://localhost:8080/myJSPApp/jsp/vvod.jsp");
RequestDispatcher rd = request.getRequestDispatcher("/jsp/vvod.jsp");
rd.forward(request, response);
}}

