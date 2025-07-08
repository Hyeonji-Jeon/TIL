<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      
         $(document).ready(function(){
              // POST 요청
              $("#btnDTO").on("click", function(){

                  //ajax 통신
                  $.ajax({
                     url:"main1",
                     method:"post",
                     dataType :'text',
                     contentType: "application/json" ,
                     data:JSON.stringify({"userid": "홍길동","passwd": "1234"}),
                     success:function(data, status , xhr){
                           console.log(data);
                        
                        }, 
                     error:function(xhr, status, error){
                        console.log("error:", error);
                     }
                  });

              }); //end btnDTO

              // POST 요청
              $("#btnList").on("click", function(){

                  //ajax 통신
                  $.ajax({
                     url:"main2",
                     method:"POST",
                     dataType :'text', 
                     contentType: "application/json" ,
                     data:JSON.stringify([{"userid": "홍길동","passwd": "1234"},{"userid": "이순신","passwd": "9999"}]),
                     success:function(responseJson, status , xhr){
                     
                        }, 
                     error:function(xhr, status, error){
                        console.log("error:", error);
                     }
                  });

              }); //end btnDTO

         });
     
    </script>
</head>
<body>
 <h1>JSON 실습</h1>
 <button id="btnDTO">DTO 요청</button>
 <button id="btnList">List 요청</button>
 <hr>
  <div id="result"></div>
</body>
</html>