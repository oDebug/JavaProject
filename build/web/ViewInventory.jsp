<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory</title>
    </head>
    <body>
        <br>
        Branch #: <b>${store.storeID}</b><br>
        Branch Name: <b>${store.storeName}</b><br>
        Branch Location: <b>${store.storeAddr}</b><br>
        <a href="StoreSelection.jsp">Back to Stores</a><br><br>
        
        <table>
            <tr>
               <th>Store</th>
               <th>Book Cd</th>
               <th>Title</th>
               <th>Retail Price</th>
               <th>Quantity</th>
            </tr>
            <c:forEach var="bk" items="${bookRows}">
                <tr>
                    <td>${bk.storeID}</td>
                    <td>${bk.bookID}</td>
                    <td>${bk.title}</td>
                    <td>${bk.price}</td>
                    <td>${bk.onHand}</td>
                </tr>
                
            </c:forEach>

            
        </table>
        
    </body>
</html>
