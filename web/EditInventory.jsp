<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Book</title>
    </head>
    <body>
        <br>
        Branch #: <b>${store.storeID}</b><br>
        Branch Name: <b>${store.storeName}</b><br>
        Branch Location: <b>${store.storeAddr}</b><br>
        <a href="StoreSelection.jsp">Back to Stores</a><br><br>
        
        
    </body>
</html>
