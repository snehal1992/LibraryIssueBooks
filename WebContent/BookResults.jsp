<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.DAO.SearchBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href = "SmartLibrary.jsp " >Homepage</a>
<table>
<TABLE BORDER="1">
            <TR>
                <TH>ISBN</TH>
                <TH>Title</TH>
                <TH>Fname</TH>
                <TH>Lname</TH>
                <TH>Availability</TH>
            </TR>
            <% List<SearchBean> l=(List<SearchBean>)request.getAttribute("BookResults");
            SearchBean b1=l.get(1);
             out.print(b1.getIsbn());
            Iterator<SearchBean> i =l.iterator();
            while(i.hasNext()){ 
            SearchBean b=i.next();%>
            <TR >
                <td> <% out.print(b.getIsbn());%></td>
                <td> <%out.print(b.getTitle());%></td>
                <td > <% out.print(b.getFname());%></td>
                <td > <%out.print(b.getLname()); %></td>
                <td > <% out.print(b.getAvailable()); %></td>
                <% if (b.getAvailable()==true){ %>
                 <td><form method="get" action="OldorNew.jsp">
    <button type="submit">Book</button>
</form><td>
                 <% session.setAttribute("Book", b.getIsbn());
                 } else {%>
                 <td></td>
              <%} %>
            </TR>
            <% } %>
        </TABLE>
        <%  %>
</body>
</html>