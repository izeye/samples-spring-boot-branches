<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <sitemesh:write property="head" />
</head>
<body>
<c:set var="messageInDecorator" value="I'm a SiteMesh decorator." />
${messageInDecorator}
<br>

<sitemesh:write property="body" />
</body>
</html>