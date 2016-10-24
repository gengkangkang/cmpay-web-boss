<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新商户</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="merForm" data-toggle="validate" novalidate="novalidate" action="${pageContext.request.contextPath}/merchantManagement/addNewMer" method="post">
    <div class="bjui-searchBar">
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">商户编号：</label>
      <input type="text"  name="merchantid" style="width:60%;" data-rule="商户号:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">商户名称：</label>
      <input type="text"  name="merchantName" style="width:60%;" data-rule="商户名称:required;" />&nbsp;
      </div>
      
            <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">企业编码：</label>
      <input type="text"  name="ecode" style="width:60%;" data-rule="企业编码:required;" />&nbsp;
      </div>
            <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">联系人：&nbsp;&nbsp;&nbsp;</label>
      <input type="text"  name="linkman" style="width:60%;" data-rule="联系人:required;" />&nbsp;
      </div>
            <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">联系电话：</label>
      <input type="text"  name="mobile" style="width:60%;" data-rule="mobile;联系电话:required" />&nbsp;
      </div>

      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
      <input type="text"  name="remark" style="width:60%;" />
      </div>

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增</button>&nbsp;
      </div>

    </div>
  </form>
</div>

</body>
</html>
