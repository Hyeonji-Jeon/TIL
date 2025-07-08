<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
  <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
  <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
  <script>
  
  
  </script>
 
  <div class="TodoApp">
    <div class="container">
            <div class="Login">
            <h1>mypage화면</h1>
            <div class="signUpForm">
              <form >
                <div>
                    <label for="userid">userid:</label>
                    <input type="text" name="userid" value="${mypage.userid}"/>
                </div>
                <div>
                    <label for="password">passwd:</label>
                    <input type="passwd" name="passwd" value="${mypage.passwd}" />
                </div>
                 <div>
                    <label for="username">username:</label>
                    <input type="text" name="username" value="${mypage.username}"/>
                </div>
                <div>
                    <button name="login" class="btn btn-success m-5" >signup</button>
                </div>
               </form> 
            </div>
        </div>
        </div>
    </div>