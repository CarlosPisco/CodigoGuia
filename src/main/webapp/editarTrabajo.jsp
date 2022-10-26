<%@ page import="Beans.JobBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    JobBean job = (JobBean) request.getAttribute("trabajo");
%>
<html>
<head>
    <title>Crear trabajo:</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <h1>Editar trabajo:</h1>
    <form method="POST" action="<%=request.getContextPath()%>/JobServlet?accion=editar">
        <input type="text" class="form-control" name="jobId" value="<%=job.getJobId()%>" hidden>
        <div class="mb-3">
            <label class="form-label">Job title:</label>
            <input type="text" class="form-control" name="jobTitle" value="<%=job.getJobTitle()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Min Salary:</label>
            <input type="text" class="form-control" name="minSalary" value="<%=job.getMinSalary()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Max Salary:</label>
            <input type="text" class="form-control" name="maxSalary" value="<%=job.getMaxSalary()%>">
        </div>
        <button type="submit" class="btn btn-primary">Editar</button>
    </form>
</div>
</body>
</html>
