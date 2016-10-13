<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改IP</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="userForm" data-toggle="validate" novalidate="novalidate"  action="${pageContext.request.contextPath}/userManagement/changepwd" method="post">
    <div class="bjui-searchBar">
          <div class="form-group" style="margin: 20px 0 20px;display:none; ">
      <input type="text" value="<c:out value="${userForm.userid}"/>" name="userid" style="width:60%;" />
      </div>
    
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">用户名&nbsp;&nbsp;&nbsp;：</label>
      <input type="text" value="<c:out value="${userForm.username}"/>" name="username" style="width:60%;" readonly />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">旧密码&nbsp;&nbsp;&nbsp;：</label>
      <input type="text"  name="oldpassword" style="width:60%;" data-rule="旧密码:required;" />&nbsp;
      </div>
      
       <div class="form-group" style="margin: 20px 0 20px; ">
         <label class="control-label x85">新密码&nbsp;&nbsp;&nbsp;：</label>
         <input type="text"  name="pass" style="width:60%;" data-rule="新密码:required;" />&nbsp;
      </div>
           

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">确认修改</button>&nbsp;
      </div>

    </div>
  </form>
</div>

</div>

</body>
</html>
