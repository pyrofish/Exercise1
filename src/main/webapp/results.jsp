<%@include file="head.jsp"%>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">
    <h2>Search Results: </h2>

    <table>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>ID</th>
        </tr>

             <tr>
                 <td>${users.getFirstName()}</td>
                 <td>${users.getLastName()}</td>
                <td>${users.getUserid()}</td>
             </tr>


    </table>
    ${users}


</div>

</body>
</html>
