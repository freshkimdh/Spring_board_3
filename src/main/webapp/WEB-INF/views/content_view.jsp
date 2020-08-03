<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!-- view 부분이다 -->
<!DOCTYPE html>


<html>
   <head>
      <meta charset="UTF-8">
      <title>Content view</title>
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
           //왜  ${pageContext.request.contextPath} 이것을 넣었는지, 이것을 넣으면 어떤 현상이 일어나는지 꼭 확인
           //동적리소스를 별도로 정한게 아니라 컨트롤러 통해 지나는 url 이니까 명시가 필요하다.
       
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
                 
  
            }
        

           });   // Ajax end
    
           
        }//end   getList()   

   
   
   
         </script>   
         
         <script type="text/javascript"> 
            //지금 하는 것은 삭제 버튼을 누르면, 해당 글을 삭제를 하는데
            //이 삭제를 Restful로 할려고 하는 것이다. (Ajax를 활용)
            $(document).ready(function (){ //이거 왜 이렇게 하는지 꼭 알기
               $('#a-delete').click(function(event){
                  //preventDefault()는 href로 연결해 주지 않고 단순히 click에 대한 처리를 하도록 해준다.
                  //기존 기능 끊을때 써야 한다.
                  //삭제를 누르면 링크로 넘어가야 하는데, event.preventDefault(); 이것을 사용해서 내가 낚아채겠다는 말
                  event.preventDefault();
                  console.log("ajax 호출 전");
                  
                  $.ajax({
                      type : "DELETE",
                      //bId 자체를 url로 넘긴다 (get, post 방식이 아닌)
                     //예전에는 ? 달고 그렇게 했는데, 그렇게 하지 말고, 뒤에 url를 붙이자
                     //이것이 restful 별거 없다. 이렇게 사용하는 것이다.
                      url : "${pageContext.request.contextPath}/rest/delete/" + "${content_view.bId}", 
                      data:{"bId":"${content_view.bId}"},//bid 변수명 = ${content_view.bId} 필요는 없지만 구분하기 위해서 넣어 줬다.
                      success: function (result) {       
                             console.log(result); 
                             getList(); //성공 하면 getList를 호출한다. 깜빡임 없이 getAjax를 가지고 와서 업데이트를 한다.        
                      },
                      error: function (e) {
                          console.log(e);
                      }
                      
                      
                  })//Ajax end
          
               });//click end
               
               
            });//ready end
         
         
         
         
         </script> 
   </head>
   
   <body>
     <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1" align="center">
      <form action="modify" method="post">      
         <input type="hidden" name="bId" value="${content_view.bId}">
         <tr>
            <td> 번호 </td>
            <td> ${content_view.bId} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${content_view.bHit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" name="bName" value="${content_view.bName}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="bTitle" value="${content_view.bTitle}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="bContent" >${content_view.bContent}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="수정"> &nbsp;&nbsp; 
            <a href="list">목록보기</a> &nbsp;&nbsp; 
            <!--ajax를 활용을 위한 쉽게 하기위해 아래와 같이 했다. 원래는 저렇게 하면 안됨  -->
            <a id="a-delete" href="{pageContext.request.contextPath}/rest/delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; 
            <a href="reply_view?bId=${content_view.bId}">답변</a></td> <!-- //몇번에 답변을 달것인가? -->
         </tr>
      </form>
   </table>
   
   </body>
</html>