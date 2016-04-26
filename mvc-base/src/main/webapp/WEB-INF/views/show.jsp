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
            <h3>Event List</h3>
        </div>

        <div class="row-fluid">
            <c:if test="${not empty list}">
                <table class="table">
                    <thead>
                    <tr>
                        <th>name</th>
                        <th>start</th>
                        <th>end</th>
                        <th>privat</th>
                        <th>id</th>
                    </tr>
                <c:forEach var="listValue" items="${list}">
                    <tr>
                        <c:forEach var="attribute" items="${listValue}">
                            <td>${attribute}</td>
                        </c:forEach>
                        <td><a class="btn btn-primary btn-small" href="/event_add?id=${listValue.get(4)}&act=upd"><spring:message code="message.update.show"/></a></td>
                        <td><a class="btn btn-primary btn-small" href="/event_add?act=del&id=1"><spring:message code="message.delete.show"/></a></td>
                    </tr>
                </c:forEach>
                </table>
            </c:if>
        </div>

    </body>
</html>