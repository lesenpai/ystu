<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html; charset=windows-1251" %>

<HTML>
<HEAD>
<TITLE>Login</TITLE>
</HEAD>
<BODY>
<CENTER>

<BR>
<BR><H2>Login Page</H2>
<BR>
<BR>Please enter your user name and password.
<BR>
<BR><FORM METHOD=POST>
<TABLE>
<TR>
<TD>User Name:</TD>
<TD><INPUT TYPE=TEXT NAME=userName></TD>
</TR>
<TR>
<TD>Password:</TD>
<TD><INPUT TYPE=PASSWORD NAME=password></TD>
</TR>
<TR>
<BR>Please enter number:
<BR>1 - Displaying All Countries, 2 - Insert country, 3 - Delete ountry, 4 - Quit.");
<TD>Nomer:</TD>
<TD><INPUT TYPE="TEXT" NAME=nomer></TD>
</TR>
<TR>
<TD ALIGN=RIGHT COLSPAN=2>
<INPUT TYPE=SUBMIT name=submit VALUE=Login></TD>
</TR>
</TABLE>
</FORM>
</CENTER>
</BODY>
</HTML>
<%! String nom=null;%>
<%
nom = request.getParameter("nomer"); 
if (nom!=null) {
RequestDispatcher rd = request.getRequestDispatcher("/LoginServ11");
rd.forward(request, response);
}
%>
