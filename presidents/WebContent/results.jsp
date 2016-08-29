<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>President Info</title>
</head>
<body>
	<p><em>Image will go here</em></p>
	<br>
	<p>${president.quote}</p>
	<br>
<p>${president.displayInfo}</p>
<p></p>
<form action="RunMe" method="post">

<c:if test="${term <= 0 }" >
<input type="submit" value="Previous" name="button" disabled>
</c:if>
<c:if test="${term > 0 }" >
<input type="submit" value="Previous" name="button">
</c:if>

<c:if test="${term >= 43 }" >
<input type="submit" value="Next" name="button" disabled>
</c:if>
<c:if test="${term < 43 }" >
<input type="submit" value="Next" name="button">
</c:if>

</form>

<!--  Look good -->
 <form action="RunMe" method="post">
 <c:if test="${term <= 0 }">
 <input class="left carousel-control" type="submit" value="Previous" href="#myCarousel" data-slide="prev"
				name="button" disabled>
            <span class="icon-prev"></span>
        
</c:if>
<c:if test="${term > 0 }">
 <input class="left carousel-control" type="submit" value="Previous" href="#myCarousel" data-slide="prev"
				name="button">
            <span class="icon-prev"></span>
       
</c:if>

<c:if test="${term >= 43 }">
 <input class="right carousel-control" type="submit" value="Next" href="#myCarousel" data-slide="next"
				name="button" disabled>
            <span class="icon-next"></span>

</c:if>
<c:if test="${term < 43 }">
<input class="right carousel-control" type="submit" value="Next" href="#myCarousel" data-slide="next"
				name="button">
            <span class="icon-next"></span>

		</c:if>
</form>
</body>
</html>