<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns:mso="urn:schemas-microsoft-com:office:office" xmlns:msdt="uuid:C2F41010-65B3-11d1-A29F-00AA00C14882">
  
  <head> 
    <meta charset="UTF-8"> 
    <title>Search For Movie</title>	
    
    <script type="text/javascript">
       function findMovies()
       {
        	var city = document.getElementById("city").value;
        	var language = document.getElementById("language").value;
        	var url="searchMovie?city="+city+"&language="+language;

            if(window.XMLHttpRequest){
             request=new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                 request=new ActiveXObject("Microsoft.XMLHTTP");
                 }

                     try
                     {
                        request.onreadystatechange=getInfo;
                          request.open("GET",url,true);
                           request.send();
                     }
                     catch(e)
                      {
                             alert("Unable to connect to server");
                      }
          }
          
          function getInfo(){
    	     if(request.readyState==4){ 	
    	      var result=request.responseText;
    	       //document.write(val); 
    		   var movie=result.split("!");
    		   
    		   var length = movie.length;
    		   
    		   for(var i=3;i<length-1;i=i+2)
    			   {
    			      var x = document.getElementById("movie");
    			      var c = document.createElement("option");
    			          c.text = movie[i]
    			          x.options.add(c, 1);
    			   }
    		   
    		  
    		   //("#customerType").val(a[1]);
    	       //document.getElementById('customerType').value = a[0]; 
    	       /* document.getElementById("customerName").value = a[2];
    	       document.getElementById('Occupation').value = a[3]; 
    	       document.getElementById("age").value = a[4];
    	       document.getElementById('gender').value = a[5]; 
    	       document.getElementById("address").value = a[6];
    	       document.getElementById('city').value = a[7]; 
    	       document.getElementById("state").value = a[8];
    	       document.getElementById('zipCode').value = a[9]; 
    	       document.getElementById('mobileNumber').value = a[10]; */
    	     //document.write("3");
    	     }
    	     }
    </script>
    
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
             <option >Select City For Your Movie</option>
             <option value="Chennai">Chennai</option>
             <option value="Delhi">Delhi</option>
             <option value="Bangalore">Bangalore</option>
             <option value="Mumbai">Mumbai</option>
             <option value="Varanasi">Varanasi</option>
            </select>
         </div>
         <div class="form-group">
            <label for="language">Language</label> 
			<select name="language" class="form-control" id="language" required onchange="findMovies()">
             <option >Select Language</option>
             <option value="Hindi">Hindi</option>
             <option value="English">English</option>
             <option value="Tamil">Tamil</option>
             <option value="Telgu">Telgu</option>
             <option value="Kannad">Kannad</option>
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
               <%-- <c:forEach var="course" items="${movieList}" varStatus="status">
               <option value=${movie.ID}>${movie.name}</option>
               </c:forEach> --%>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Search For Theaters</button> 
    </form>
   </div>
  </div>	
 </body>
</html>