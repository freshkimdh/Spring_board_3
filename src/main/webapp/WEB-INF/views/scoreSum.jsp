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
    	            'kor'  : $('input[name=kor]').val(),
    	            'eng' : $('input[name=eng]').val(),
    	            'math' : $('input[name=math]').val()
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
    	            error :  function(xhr, status) {
    	            	alert( '빈칸을 입력하세요.');
    	            	
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

<h1>3과목 총점 Ajax</h1>

<form action="${pageContext.request.contextPath}/restful/scoreSum.json">
  <label for="fname">kor</label>
  <input type="text" id="kor" name="kor"><br><br>
  <label for="lname">eng</label>
  <input type="text" id="eng" name="eng"><br><br>
  <label for="lname">math</label>
  <input type="text" id="math" name="math"><br><br>
  <input type="submit" value="submit">
</form>

</body>
</html>