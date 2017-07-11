<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ page import="java.util.*" %>
    <%@ page import="com.DAO.DisplayBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<TABLE BORDER="1">
            <TR>
                <TH>LoanID</TH>
                <TH>CardID</TH>
                <TH>ISBN</TH>
                <TH>Date_out</TH>
                <TH>Due Date</TH>
                <TH>Fine Amount</TH>
            </TR>
            <% List<DisplayBean> l=(List<DisplayBean>)request.getAttribute("CheckInBooks");
            DisplayBean b1=l.get(1);
             out.print(b1.getIsbn());
            Iterator<DisplayBean> i =l.iterator();
            while(i.hasNext()){ 
            DisplayBean b=i.next();%>
            <TR >
                <td> <% out.print(b.getLoanid());%></td>
                <td> <%out.print(b.getCardid());%></td>
                <td > <% out.print(b.getIsbn());%></td>
                <td > <%out.print(b.getDate_out()); %></td>
                <td > <% out.print(b.getDue_date()); %></td>
                  <td > <% out.print(b.getAmt()); %></td>
                 <td><form method="get" action="OldorNew.jsp"><%// set into loan and fine table %>
    <button type="submit">CheckIn</button>
</form><td>
            </TR>
            <% } %>
        </TABLE>
</body>
</html>