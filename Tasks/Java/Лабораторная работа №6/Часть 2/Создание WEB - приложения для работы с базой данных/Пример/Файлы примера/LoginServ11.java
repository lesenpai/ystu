import javax.servlet.*; 
import javax.servlet.http.*; 
import java.io.*; 
import java.util.*;
import java.sql.*;

public class LoginServ11 extends HttpServlet {
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
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet71");
else
if (i==2)
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet81");
else
if (i==3)
response.sendRedirect("http://localhost:8080/myApp/WelcomeServlet91");
else
if (i==4){
RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet6");
rd.forward(request, response);}
}
else {
response.sendRedirect("http://localhost:8080/myJSPApp/jsp/vvod.jsp");
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


