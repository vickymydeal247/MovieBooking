     function preferedBrowser() {
       var a = new String(document.getElementById("editCust").value);   
	    document.getElementById("d1").style.display = 'block';      
    }
     function sendInfo()
     {
     	var city = document.getElementById("city").value;
        var language = document.getElementById("language");
        
         var url="MovieBooking\searchMovie?city=" + city +"&language=" + language;

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
      var val=request.responseText;
       //document.write(val); 
	   var a=val.split("!");
	   
	   //("#customerType").val(a[1]);
       //document.getElementById('customerType').value = a[0]; 
       document.getElementById("customerName").value = a[2];
       document.getElementById('Occupation').value = a[3]; 
       document.getElementById("age").value = a[4];
       document.getElementById('gender').value = a[5]; 
       document.getElementById("address").value = a[6];
       document.getElementById('city').value = a[7]; 
       document.getElementById("state").value = a[8];
       document.getElementById('zipCode').value = a[9]; 
       document.getElementById('mobileNumber').value = a[10];
     //document.write("3");
     }
     }
