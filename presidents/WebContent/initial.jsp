<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>President Full Slider Template</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/full-slider.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">President Database</a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#">Term Number:</a></li>
					<li>
						<form action="RunMe">
							<input type="text" placeholder="Enter term number" name="input">
							<input id="button" type="submit" value="Find">
						</form>
					</li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Full Page Image Background Carousel Header -->
	<header id="myCarousel" class="carousel slide">
		<!-- Indicators -->

		<!-- Wrapper for Slides -->
		<div class="carousel-inner">
			<div class="item active">
				<!-- Set the first background image using inline CSS below. -->
				<div class="fill"
					style="background-image: url('PresImages/bg1.jpeg');"></div>
				<div class="carousel-caption">
					<img align="left" class="img-circle" alt="President"
						src="PresImages/${president.termNumber-1}.jpg" width="35%"><br>
					<br>
					<br>
					<h1>${president.termNumber},
						${president.displayName}</h1><br>
						<br>
					<h3>${president.displayInfo}</h3>
					<br><br><br>
                    <h4>${president.quote}</h4>
					<br>
                    <br><br><br>
                </div>
            </div>
        </div>



        <!-- Controls -->
 <header>
<form action="RunMe" method="post">

<c:if test="${term <= 0 }" >
<input class="left carousel-control" type="submit" value="Previous" name="button" disabled>
</c:if>
<c:if test="${term > 0 }" >
<input class="left carousel-control" type="submit" value="Previous" name="button">
</c:if>

<c:if test="${term >= 43 }" >
<input class="right carousel-control" type="submit" value="Next" name="button" disabled>
</c:if>
<c:if test="${term < 43 }" >
<input class="right carousel-control" type="submit" value="Next" name="button">
</c:if>

</form>
    </header>

    <!-- Page Content -->
    <div class="container">

        <div class="row">
            <div class="col-lg-12">
                <h1>Presidential Database</h1>
                <p>Above is a database of the U.S. presidents in order of term, displaying: <b>Name, Party, Start year, End year, and a quote</b>.
                  <br>You can search by term number or just scroll through the slider.</p>
            </div>
        </div>

        <hr>

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Steven Zuber & Patrick Gaston</p>
                </div>
            </div>
            <!-- /.row -->
        </footer>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Script to Activate the Carousel -->
    <script>
					$('.carousel').carousel({
						interval : 5000
					//changes the speed
					})
				</script>

</body>

</html>