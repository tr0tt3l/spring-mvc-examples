
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            <li class="nav-header"><spring:message code="layout.menu.event" /> </li>
            <li><a href="/event_add"><spring:message code="layout.menu.event.add" /></a></li>
            <li><a href="/event_show"><spring:message code="layout.menu.event.man" /></a></li>
        </ul>
    </div>

    <div class="well sidebar-nav">
        <ul class="nav nav-list">
            <li class="nav-header"><spring:message code="layout.lang" /> </li>
            <li><a href="?lang=fr"><spring:message code="layout.lang.french" /></a></li>
            <li><a href="?lang=en"><spring:message code="layout.lang.english" /></a></li>
        </ul>
    </div>

</body>
</html>