<jsp:include page="menu.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
<title>User list</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
    <table  style="margin-top:5px ;" class="table table-striped table-dark">
        <thead>
          <tr>
            <th scope="col">USERNAME</th>
            <th scope="col">PASSWORD</th>
            <th scope="col">ROLE</th>
            <th scope="col">QUESTION</th>
            <th scope="col">AnSWER</th>
            <th scope="col">GENDER</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
         <tbody>
        <c:forEach items="${userslist}" var="user">
            <tr >
               <td><c:out value="${user.username}"></c:out></td>
               <td><c:out value="${user.password}"></c:out></td>
               <td><c:out value="${user.role}"></c:out></td>
               <td><c:out value="${user.question}"></c:out></td>
               <td><c:out value="${user.answer}"></c:out></td>            
                 <td><c:out value="${user.gender}"></c:out></td> 
                 <td><a href="profile?username=${user.username}">EDIT</a><a>DELETE</a></td>        
          </tr>
          </c:forEach>
           </tbody>
      </table>

</body>
</html>
