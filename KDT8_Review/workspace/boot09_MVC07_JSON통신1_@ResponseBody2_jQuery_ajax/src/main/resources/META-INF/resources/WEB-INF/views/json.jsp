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
              // GET 요청
              $("#btnDTO").on("click", function(){

                  //ajax 통신
                  $.ajax({
                     url:"main",
                     method:"get",
                     dataType :'json', 
                     success:function(responseJson, status , xhr){
                         console.log(responseJson, status);
                         var userid = responseJson.userid;
                         var passwd = responseJson.passwd;
                         $("#result").text(userid+"\t"+passwd);
                        
                        }, 
                     error:function(xhr, status, error){
                        console.log("error:", error);
                     }
                  });

              }); //end btnDTO

              // GET 요청
              $("#btnList").on("click", function(){

                  //ajax 통신
                  $.ajax({
                     url:"main2",
                     method:"get",
                     dataType :'json', 
                     success:function(responseJson, status , xhr){
                         console.log(responseJson, status);
                       	 
                          var tag = `<table border="1">`;
                            
                              tag += `<tr>
                                        <th>아이디</th>
                                        <th>비번</th>                              
                                      </tr> `;

                           $.each(responseJson, function(idx,data){
                        	   console.log(data);
                        	   tag += `<tr>
                                        <td>\${data.userid}</td>
                                        <td>\${data.passwd}</td>                              
                                       </tr> `;
                        	   
                           });            
                           tag += `</table>`;
                           
                           $("#result").html(tag);
                                      
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