<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Show</title>
</head>

<body>
<div class="hero-unit">
    <h3>attribute passing test</h3>

</div>

<div class="row-fluid">
    <div class="span8">
        <div id="message" class="alert alert-success">
            ${arg1}
        </div>
        <div id="message1" class="alert alert-success">
            ${test_att1}
        </div>
        <div id="message2" class="alert alert-success">
            ${test_att2}
        </div>
    </div>
</div>
</body>
</html>