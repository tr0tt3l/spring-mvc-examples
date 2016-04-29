<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<body>
    <form:form id="form" method="post" modelAttribute="Event">
        <spring:message code="form.event.name" var="eventNameDummy" />

        <c:if test="${not empty eventName}">
            <div id="message" class="alert alert-success">
                Name: ${eventName}
            </div>
        </c:if>
        <c:if test="${empty eventName}">
            <div id="message" class="alert alert-error">
                Name: ${eventName}
            </div>
        </c:if>
        <form:input cssClass="input-block-level" path="name" placeholder="${eventName}" autocomplete="off" />
        <br>
        <c:if test="${not empty eventStart}">
            <div id="message" class="alert alert-success">
                Startzeitpunkt: ${eventStart}
            </div>
        </c:if>
        <c:if test="${empty eventStart}">
            <div id="message" class="alert alert-error">
                fehlende Startzeit: ${eventStart}
            </div>
        </c:if>
        <form:input cssClass="input-block-level" type="date" path="start" placeholder="${eventStart}" autocomplete="off" />
        <br>
        <c:if test="${not empty eventEnd}">
            <div id="message" class="alert alert-success">
                Endzeitpunkt: ${eventEnd}
            </div>
        </c:if>
        <c:if test="${empty eventEnd}">
            <div id="message" class="alert alert-error">
                fehlender Endzeitpunkt: ${eventEnd}
            </div>
        </c:if>
        <form:input cssClass="input-block-level" type="date" path="end" placeholder="${eventEnd}" autocomplete="off" />
        <br>
        <div id="message" class="alert alert-success">
            Privat: <c:out value="${eventStatus[1]}"/>
        </div>
        <div class="radio inline">
            <form:radiobuttons cssClass="radio.inline" path="privat" items="${eventStatus}"></form:radiobuttons>
        </div>
        <div>
            <button type="submit" class="btn">Save Object</button>
        </div>
    </form:form>

</body>