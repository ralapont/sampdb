<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>

<spring:url value="/"                var="rootUrl"      />
<spring:url value="/president"       var="presidentUrl" />

<nav>
    <a href="${rootUrl}" ><img class="logo" src="resources/img/th.png"></a>
    <ul id="menu">
       <li><a href="${rootUrl}">Home</a></li>
       <li><a href="${presidentUrl}">Presidentes</a></li>
    </ul>
</nav>