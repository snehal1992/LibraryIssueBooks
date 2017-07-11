<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<FORM ACTION="BorrowerController" METHOD="get">
            Please enter the Borrower Details:
            <BR>
            SSN<INPUT TYPE="TEXT" NAME="SSN">
            <BR>
            <BR>
            FNAME<INPUT TYPE="TEXT" NAME="Fname">
            <BR>
            <BR>
            LNAME<INPUT TYPE="TEXT" NAME="Lname">
            <BR>
            <BR>
            ADDRESS<INPUT TYPE="Text" NAME="Address">
            <BR>
            <BR>
            PHONE<input type="text" name="phone">
            <BR>
            <INPUT TYPE="SUBMIT" value="ADD">
        </FORM>
</body>
</html>