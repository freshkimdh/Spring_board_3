<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    function areaAjax(){
    	
    	  $('form').submit(function(event) { 
    		  
    		   event.preventDefault();
    		  
    	        var formData= {
    	            'width'  : $('input[name=width]').val(),
    	            'height' : $('input[name=height]').val()
    	        };
    	 
    	        $.ajax({
    	            type        : 'POST',
    	            url         : $('form').attr('action'),
    	            data        : formData,
    	            dataType    : 'json',
    	            success : function(data) {
    	                var jsonObj = JSON.parse(data);
    	                $('body').html("");
    	                $('body').append(jsonObj);   	                
    	                
    	            }, // success    
    	            error : function(xhr, status) {
    	                alert(xhr + " : " + status);
    	            }
    	        });
    	 
    	      
    	    
        }); // $.ajax 
    }
</script>

<script type="text/javascript">
	$(document).ready(function() {
		areaAjax();
	});
</script>
</head>

<body>

<h1>사각형 넓이 Ajax</h1>

<form action="${pageContext.request.contextPath}/restful/recAjax.json">
  <label for="fname">width</label>
  <input type="text" id="width" name="width"><br><br>
  <label for="lname">height</label>
  <input type="text" id="height" name="height"><br><br>
  <input type="submit" value="submit">
</form>

</body>
</html>