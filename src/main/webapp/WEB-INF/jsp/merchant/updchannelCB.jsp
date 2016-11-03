<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新渠道</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="channelBaseForm" data-toggle="validate" novalidate="novalidate" action="${pageContext.request.contextPath}/channelManagement/updateCB" method="post">
    <div class="bjui-searchBar">
     <input type="hidden" name="id"  value="${channelBaseForm.id}" />
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">渠道编号：</label>
      <input type="text"  name="code" value="${channelBaseForm.code}" style="width:60%;" data-rule="渠道编号:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">渠道名称：</label>
      <input type="text"  name="name" value="${channelBaseForm.name}" style="width:60%;" data-rule="渠道名称:required;" />&nbsp;
      </div>
        

      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
      <input type="text"  name="remark" style="width:60%;" />
      </div>

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>&nbsp;
      </div>

    </div>
  </form>
</div>

</body>
</html>
