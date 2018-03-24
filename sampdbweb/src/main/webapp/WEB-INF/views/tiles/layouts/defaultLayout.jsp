<%@ taglib uri="http://java.sun.com/jsp/jstl/core"    prefix="c"      %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="s"      %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"   prefix="t"      %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles"   prefix="tiles"  %>
<%@ taglib uri="http://www.springframework.org/tags"  prefix="spring" %>
<!DOCTYPE html>
<html lang="sp">
	<head>
		<meta charset="UTF-8">
		
	    <link rel="stylesheet" type="text/css" href="resources/css/jquery-ui.theme.min.css" >
		<link rel="stylesheet" type="text/css" href="resources/css/ui.jqgrid.css" >
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.css" >
		<link rel="stylesheet" type="text/css" href="resources/css/style.css" >

		<script src="resources/js/jquery-3.2.1.min.js"  type="text/javascript"></script>
		<script src="resources/js/bootstrap.js"         type="text/javascript"></script>
		<script src="resources/js/grid.locale-es.js"    type="text/javascript"></script>
		<script src="resources/js/jquery.jqGrid.min.js" type="text/javascript"></script>
		
		
	    <title><tiles:getAsString name="title" /></title>
	</head>

	<body>
	    <header id="header">
			<tiles:insertAttribute name="header" />
    	</header>

	    <aside  id="sidemenu">
		   <tiles:insertAttribute name="menu" />
	    </aside>
    
	    <section id="site-content" >
	        <article>
		           <tiles:insertAttribute name="body" />
	        </article>
	    </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
	</body>
</html>