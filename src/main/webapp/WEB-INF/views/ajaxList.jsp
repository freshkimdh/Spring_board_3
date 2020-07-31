<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
   <head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   <title>Insert title here</title>
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <script type="text/javascript">
/*    $.ajax({
      url : '서비스 주소'
         , data : '서비스 처리에 필요한 인자값'
         , type : 'HTTP방식' (POST/GET 등)
         , dataType : 'return 받을 데이터 타입' (json, text 등)
         , success : function('결과값'){
         // 서비스 성공 시 처리 할 내용
         }, error : function('결과값'){
         // 서비스 실패 시 처리 할 내용
         }
      }); */

      function getList() {
         var url = "${pageContext.request.contextPath}/restful/after.json";
         //url = "http://192.168.6.10:8282/board/rest/after.json";
     
     //ajax 기본 문법
      $.ajax({
          url: url,
          type: 'GET', //무조건 대문자 넣어줘야 한다. 
          cache: false,//이걸 안쓰거나 ture하면 수정해도 값반영이 잘 안될때가 있음.
          dataType: 'json', //통신에서 내가 데이터를 받을꺼, 받는 타입이 들어감
          //data: "id:"abcd"", // 현재는 넘길 데이터가 없기 떄문에 삭제          
          success: function(result){ //배열안에 객체가 리스트 갯수만큼 쭉 있는것이다. //배열이니깐 배열로 돌린다.
             console.log(result);
           //ajax는 그냥 함수이다.
          
         /*   
           //AJAX 테이블로 출력 방법 1
                var htmls="";
               
                 $("#list-table").html("");   

               $("<tr>" , {
                  html : "<td>" + "번호" + "</td>"+  // 컬럼명들
                        "<td>" + "이름" + "</td>"+
                        "<td>" + "제목" + "</td>"+
                        "<td>" + "날짜" + "</td>"+            
                        "<td>" + "히트" + "</td>"
               }).appendTo("#list-table") // 이것을 테이블에붙임

               if(result.length < 1){
                  htmls.push("등록된 댓글이 없습니다.");
               } else {

                          $(result).each(function(){                                                          
                             htmls += '<tr>';
                             htmls += '<td>'+ this.bId + '</td>';
                             htmls += '<td>'+ this.bName + '</td>';
                             htmls += '<td>'
                           for(var i=0; i < this.bIndent; i++) { //for 문은 시작하는 숫자와 종료되는 숫자를 적고 증가되는 값을 적어요. i++ 은 1씩 증가 i+2 는 2씩 증가^^
                              htmls += '-'   
                          }
                             htmls += '<a href="${pageContext.request.contextPath}/content_view?bId=' + this.bId + '">' + this.bTitle + '</a></td>';
                              htmls += '<td>'+ this.bDate + '</td>'; 
                             htmls += '<td>'+ this.bHit + '</td>';   
                             htmls += '</tr>';                                                      
                         });   //each end

                         htmls+='<tr>';
                         htmls+='<td colspan="5"> <a href="${pageContext.request.contextPath}/write_view">글작성</a> </td>';                         
                         htmls+='</tr>';
                         
               }

               $("#list-table").append(htmls); 
               
               */
      
       
	  //AJAX 테이블로 출력 방법 2
                
 	  $.each(result, function() {
     	$('#list-table').append("<tr><td>" + this.bId + "</td>"
     			+ "<td>" + this.bName + "</td>" + 
     			"<td>" + this["bTitle"] + "</td>" + 
     			"<td>" + this["bContent"] + "</td>" + 
     			"<td>" + this["bDate"] + "</td>" + 
     			"<td>" + this["bHit"] + "</td>" + 
     			"</tr>");
     	
     });
              
               
     //AJAX 테이블로 출력 방법 3
     $.each(result, function(index, entry) {
     	$('#list-table').append("<tr><td>" + entry.bId + "</td>"            			
     			+ "<td>" + entry.bName + "</td>" +  //출력 방법은 2가지이다.
     			"<td>" + entry["bTitle"] + "</td>" + 
     			"<td>" + entry["bContent"] + "</td>" + 
     			"<td>" + entry["bDate"] + "</td>" + 
     			"<td>" + entry["bHit"] + "</td>" + 
     			"</tr>");        
     });    
       
      
      
      
          }
      

         });   // Ajax end
  
         
      }//end   getList()   
   </script>
   
   <script>
      $(document).ready(function(){
         getList();
      });
   </script>

</head>
<body>
   <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
   </table>
</body>
</html>