<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
  
  <head> 
    <meta charset="UTF-8"> 
    <title>Search For Examination</title>	
    
    <jsp:include page="css.jsp"/>
     
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
                <a class="navbar-brand" href="index">Home Page</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">  
                    <li>
                        <a href="login">Login</a>
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
    <form method="POST" action="/ExamScheduler/searchResult">
        <div class="form-group">
            <label for="city">City</label> 
			<select name="city" class="form-control" id="city" required>
               <option >Select City For Your Examination Center</option>
             <option value="Chennai">Chennai</option>
             <option value="Delhi">Delhi</option>
             <option value="Bangalore">Bangalore</option>
             <option value="Mumbai">Mumbai</option>
             <option value="Varanasi">Varanasi</option>
            </select>
         </div>
         <div class="form-group">
            <label for="city">Language</label> 
			<select name="city" class="form-control" id="language" required>
               <option >Select Language</option>
             <option value="Chennai">Hindi</option>
             <option value="Delhi">English</option>
             <option value="Bangalore">Tamil</option>
             <option value="Mumbai">Telgu</option>
             <option value="Varanasi">Kannad</option>
            </select>
         </div>
         <div class="form-group">
           <label for="date">Date</label>
           <input name="date" type="date" class="form-control" id="date">
         </div>
         <div class="form-group">
            <label for="movie">Movie</label> 
			<select name="movie" class="form-control" id="movie" required>
               <option>Select Movie</option>
               <c:forEach var="course" items="${movieList}" varStatus="status">
               <option value=${movie.ID}>${movie.name}</option>
               </c:forEach> 
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Search For Theaters</button> 
    </form>
   </div>
  </div>	
 </body>
</html>