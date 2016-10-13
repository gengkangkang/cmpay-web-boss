<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: APPLE
  Date: 15/12/18
  Time: 上午11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>角色资源你设置</title>
</head>
<body>
<div class="bjui-pageHeader">
    <input type="hidden" name="pageSize" value="${roleFuncForm.pageSize}">
    <input type="hidden" name="pageCurrent" value="${roleFuncForm.pageCurrent}">
    <div class="bjui-searchBar">
      <label>角 色：</label>
      <label><c:out value="${roleFuncForm.roleName}"/></label>&nbsp;
      <label>角色状态：</label>
      <label><c:out value="${roleFuncForm.roleDisableTag}"/></label>&nbsp;
      <a href="${pageContext.request.contextPath}/roleManagement/roleenable?id=${roleFuncForm.roleId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定启用吗？" >启用</a>&nbsp;
      <a href="${pageContext.request.contextPath}/roleManagement/roledisable?id=${roleFuncForm.roleId}" class="btn btn-red" data-toggle="doajax" data-confirm-msg="确定禁用吗？" >禁用</a>&nbsp;

      <!-- <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;-->
    </div>
</div>
<div class="bjui-pageContent tableContent">
  <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="100%" data-nowrap="true">
    <thead>
    <tr>
      <th align="center">资源组</th>
      <th align="center">授权状态</th>
      <th align="center">操作</th>
    </tr>
    </thead>
    <tbody>
<c:forEach var="record" items="${roleFuncForm.pagination.list}" varStatus="status">
<tr data-id="<c:out value="${record.funcId}"/>">
      <td align="center"><c:out value="${record.funcName}"/></td>
      <td align="center"><c:out value="${record.checked}"/></td>
      <td align="center">
         <a href="${pageContext.request.contextPath}/roleManagement/addauthority?sid=<c:out value="${record.funcId}"/>&rid=${roleFuncForm.roleId}" class="btn btn-red" data-toggle="doajax" >授权</a>&nbsp;
         <a href="${pageContext.request.contextPath}/roleManagement/cancelauthority?sid=<c:out value="${record.funcId}"/>&rid=${roleFuncForm.roleId}" class="btn btn-red" data-toggle="doajax" >禁止</a>&nbsp;
      </td>
</tr>
  </c:forEach>
    </tbody>
  </table>

</div>
<div class="bjui-pageFooter" id="pageFooter">

</div>

</div>

</body>
</html>
