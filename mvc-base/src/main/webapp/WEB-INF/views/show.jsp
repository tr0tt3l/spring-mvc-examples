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
            <h3>${test_cal}</h3>

        </div>

        <div class="row-fluid">
            <div class="span8">
                <div id="message" class="alert alert-success">
                    ${test_cal2}
                </div>
                <div id="message1" class="alert alert-success">
                    ${year}
                </div>
                <div id="message2" class="alert alert-success">
                    ${test_event}
                </div>
            </div>
        </div>
        <p><a class="btn btn-primary btn-large" href="/test"><spring:message code="message.test.show"/></a></p>
        <p><a class="btn btn-primary btn-large" href="/test1?arg1=hallo"><spring:message code="message.test1.show"/></a></p>
    </body>
</html>