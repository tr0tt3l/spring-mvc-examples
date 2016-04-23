<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Home</title>
</head>
<body>
		<div class="hero-unit">
			<h1>Home</h1>
			<p>
				<spring:message code="message.welcome"/>
			</p>
		</div>
		<p><a class="btn btn-primary btn-large" href="/event_show"><spring:message code="message.home.show"/></a></p>
		<div class="row-fluid">
			<div class="span8">
			
				<div id="message" class="alert alert-info">
					<spring:message code="message.home.instructions"/>
				</div>

			</div>
		</div>
</body>
</html>