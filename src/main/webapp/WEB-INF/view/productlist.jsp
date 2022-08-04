<jsp:include page="menu.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<title>product list</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <table  style="margin-top:5px ;" class="table table-striped table-dark">
        <thead>
          <tr>
            <th scope="col">ID</th>
            <th scope="col">NAME</th>
            <th scope="col">PRICE</th>
            <th scope="col">EXPIRY DATE</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
        <c:forEach items="${productlist}" var="product">
            <tr >
               <td><c:out value="${product.procudtId}"></c:out></td>
               <td><c:out value="${product.productName}"></c:out></td>
               <td><c:out value="${product.productPrice}"></c:out></td>
               <td><c:out value="${product.productExpiryDate}"></c:out></td>
            <td><a href="getProduct?procudtId=${product.procudtId}">EDIT</a>
            <a href="deleteProduct?procudtId=${product.procudtId}">DELETE</a></td>
          </tr>
          </c:forEach>
           </tbody>
      </table>

</body>
</html>