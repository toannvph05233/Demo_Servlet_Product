<%@ page import="java.util.ArrayList" %>
<%@ page import="models.Product" %><%--
  Created by IntelliJ IDEA.
  User: johntoan98gmail.com
  Date: 28/07/2021
  Time: 09:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body>

<div class="container">
    <h2>Product Table</h2>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
<%
    ArrayList<Product> list = (ArrayList<Product>) request.getAttribute("listSP");
    String str ="";
    for (Product p:list) {
        str +="<tr> <td>" + p.getId() + "</td><td>" + p.getName() + "</td><td>" + p.getPrice()+ "</td></tr>";
    }
    out.println(str);
%>
        </tbody>
    </table>
</div>
<a href="/CreateProduct.jsp" class="btn btn-success">Create</a>
</body>
</html>
