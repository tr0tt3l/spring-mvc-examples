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
            <h1>Kalender</h1>

        </div>

        <div class="row-fluid">
            <div class="span8">

                <div id="message" class="alert alert-info">
                    <spring:message code="message.home.instructions"/>
                </div>

                <form:form id="formCal" modelAttribute="calendar">
                    <form:input cssClass="input-block-level" path="showName" placeholder="${typeMessage}" autocomplete="off" type="hidden"/>

                        <button type="submit" class="btn">Submit</button>
                </form:form>

            </div>
        </div>
    </body>
</html>