
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <script src="ajax.js" type="text/javascript"></script>
    <script src="inventory.js" type="text/javascript"></script>
    <script language="javascript" type="text/javascript">
        function pageAction(userSelection)
        {   
            if(ajax && userSelection === 'view')
            {
                var sID = document.getElementById("sboxStoreID").value;
                ajax.open('get', 'ViewInventory?storeID=' + encodeURIComponent(sID));
                ajax.send(null);                
            }
            else if(ajax && userSelection === 'edit')
            {
                var sID = document.getElementById("sboxStoreID").value;
                var bID = document.getElementById("tboxBookCd").value;
                ajax.open('get', 'EditInventory?bookID=' + encodeURIComponent(bID) + '&storeID=' + encodeURIComponent(sID));
                ajax.send(null); 
            }
            else
            {
                document.selection.submit();
            }
        }
    </script>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Store Selection</title>
    </head>
    <body>
        <h1>Select Store for Inventory:</h1>
        <p>
            User: ${user.userID} - ${user.username}, ${user.adminLevel} Level
        </p>
        <form action="ViewInventory" id="selection" method="post">
            Stores:<br>
            <select id="sboxStoreID" name="storeID">
                <c:forEach var="st" items="${stores}">
                    <option ${st.storeID == user.storeID ? 'Selected' : ''} value="${st.storeID}">${st.storeName}</option>                    
                </c:forEach>
            </select>
            <input type="button" value="View Inventory" onclick="pageAction('view')">            
        </form>
        <br>Book Cd: <input type="text" id="tboxBookCd"> <button onclick="pageAction('edit')">Edit Record</button>
        
        <br>
        <div id="results"></div>
        <br>${msg}
    </body>
</html>
