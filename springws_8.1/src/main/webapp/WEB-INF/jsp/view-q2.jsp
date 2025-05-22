<%@ taglib prefix="c" uri="https://jakarta.ee/jsp/jstl/core" %>
<!DOCTYPE html>
<html><body>
<h2>Question 2 – Subtraction (−)</h2>
<c:if test="${not empty message}">
  <p style="color:red;">${message}</p>
</c:if>
<form method="post" action="q2">
  Number 1: <input name="number1"/><br/>
  Number 2: <input name="number2"/><br/>
  Your answer: <input name="result"/><br/>
  <input type="submit" value="Submit"/>
</form>
</body></html>
