<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.JobBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<JobBean> listaTrabajdos = (ArrayList<JobBean>) request.getAttribute("listaTrabajdos");
%>
<html>
<head>
    <title>Lista de trabajos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <h1>Lista de trabajos</h1>
        <a href="<%=request.getContextPath()%>/JobServlet?accion=crear">crear trabajo</a>
        <table class="table">
            <tr>
                <th>Job ID</th>
                <th>Job title</th>
                <th>Min Salary</th>
                <th>Max Salary</th>
                <th></th>
                <th></th>
            </tr>
            <% for(JobBean job : listaTrabajdos){ %>
            <tr>
                <td><%=job.getJobId()%></td>
                <td><%=job.getJobTitle()%></td>
                <td><%=job.getMinSalary()%></td>
                <td><%=job.getMaxSalary()%></td>
                <td><a href="<%=request.getContextPath()%>/JobServlet?accion=editar&id=<%=job.getJobId()%>">Editar</a></td>
                <td><a href="<%=request.getContextPath()%>/JobServlet?accion=eliminar&id=<%=job.getJobId()%>">borrar</a></td>
            </tr>
            <% } %>
        </table>
    </div>
</body>
</html>
