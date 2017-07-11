<%@ page import="javax.servlet.http.HttpServlet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1> Lookup</H1>
        <FORM ACTION="BookSearch.jsp" METHOD="GET">
            <BR>
            <INPUT TYPE="submit" NAME="Find a Book" value="Find a Book" >
            <BR>
             </FORM>
             <FORM ACTION="CardDetailsCheckIn.jsp" METHOD="GET">
            <INPUT TYPE="submit" value="CheckIn">
            <BR>
             </FORM>
             <FORM ACTION="CardDetailsDisplay.jsp" METHOD="POST">
            <INPUT TYPE="submit" NAME="Current Status" value="StatusCurrent">
            <BR>
        </FORM>
</body>
</html>