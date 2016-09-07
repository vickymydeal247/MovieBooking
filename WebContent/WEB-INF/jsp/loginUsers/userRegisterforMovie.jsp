<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
 
 <head>
  <meta charset="UTF-8"> 
  <title>Register For Movie</title>	
   <jsp:include page="css.jsp" />
 </head>
 
 <body>
 <!-- Navigation -->
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <%String userName =(String)session.getAttribute("userName");
                     %>
                <a class="navbar-brand" href="userHome">Home Page Of 
                       <% out.print(userName); %>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right"> 
                    <li>
                        <a href="userSearchMovies">Search For Movie</a>
                    </li> 
                    <li>
                        <a href="userProfile">Profile</a>
                    </li> 
                     <li>
                        <a href="logout">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 
  <div class="container">
   <div class="bs-example">
    <br><br><br> 
    <form method="POST" action="/MovieBooking/userRegisterforMovie">
     <!-- <div class="form-group">
       <label for="name">Name:</label>
       <input name="name" type="text" class="form-control" id="name"> 
     </div> -->
     <div class="form-group">
       <label for="email">Email:</label>
       <input name="email" type="email" class="form-control" id="email" required="required" value="${userName}" disabled="disabled"> 
     </div>
     <!-- <div class="form-group">
       <label for="password">Password:</label>
       <input name="password" type="password" class="form-control" id="password">
     </div> -->
     <div class="form-group">
       <label for="mobile">Phone Number</label>
       <input name="mobile" type="number" class="form-control" id="mobile" required="required" value="${mobile}">
     </div>
     <div class="form-group" >
       <label for="theaterId">Theater Id</label>
       <input name="theaterId" type="number" class="form-control" id="theaterId" value="${theaterMovie.theaterID}">
     </div>
     <div class="form-group" >
       <label for="movieId">Movie Id</label>
       <input name="movieId" type="text" class="form-control" id="movieId" value="${theaterMovie.movieID}"> 
     </div>
     <div class="form-group" >
       <label for="showTime">Show Time</label>
       <input name="showTime" type="number" class="form-control" id="showTime" value="${theaterMovie.showTime}"> 
     </div>
     <div class="form-group" >
       <label for="price">Price</label>
       <input name="price" type="number" class="form-control" id="price" value="${theaterMovie.price}">
     </div>
     <div class="form-group" >
       <label for="address">Address</label>
       <input name="address" type="text" class="form-control" id="address" value="${theaterMovie.address}">
     </div>
     <div class="form-group" >
       <label for="date">Date</label>
       <input name="date" type="date" class="form-control" id="date" value="${date}">
     </div>  
     <button type="submit" class="btn btn-default">Submit</button>
    </form>
   </div>
  </div>
  
  <jsp:include page="footer.jsp" />
  
  <jsp:include page="javaScript.jsp" />
  	
 </body>
</html>