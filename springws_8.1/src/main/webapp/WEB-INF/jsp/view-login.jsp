<%@ taglib prefix="c" uri="https://jakarta.ee/jsp/jstl/core" %>
<!DOCTYPE html>
<html><body>
<h2>Login</h2>
<c:if test="${not empty message}">
  <p style="color:red;">${message}</p>
</c:if>
<form method="post" action="login">
  User: <input name="username"/><br/>
  Pass: <input type="password" name="passwd"/><br/>
  DoB : <input name="dob" placeholder="yyyy-mm-dd"/><br/>
  <input type="submit" value="Login"/>
</form>
</body></html>
