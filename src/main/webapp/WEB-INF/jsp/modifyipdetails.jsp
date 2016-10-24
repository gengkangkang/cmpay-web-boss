<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改IP</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="ipManageForm" data-toggle="validate" novalidate="novalidate" action="${pageContext.request.contextPath}/ipManagement/updateIp" method="post">
    <div class="bjui-searchBar">
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">IP&nbsp;&nbsp;地址：</label>
      <input type="text" value="<c:out value="${ipManageForm.ip}"/>" name="ip" style="width:60%;" data-rule="IP地址:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">接入渠道：</label>
      <input type="text" value="<c:out value="${ipManageForm.inchannel}"/>" name="inchannel" style="width:60%;" data-rule="接入渠道:required;" />&nbsp;
      </div>
      
       <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">接入状态：</label>       
       <select name="status" data-toggle="selectpicker" data-rule="required">   
        <option value="OFF" selected>禁用</option>   
        <option value="ON">启用</option>    
            
      </select>
       
      </div>
      
      <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">创建时间：</label>
       <input type="text" value="<c:out value="${ipManageForm.createtime}"/>" name="createtime" style="width:60%;" readonly />&nbsp;
      </div>
      
             <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">创建人&nbsp;&nbsp;&nbsp;：</label>
       <input type="text" value="<c:out value="${ipManageForm.operator}"/>" name="operator" style="width:60%;" readonly />&nbsp;
      </div>

      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
      <input type="text" value="<c:out value="${ipManageForm.remark}"/>" name="remark" style="width:60%;" />
      </div>

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增</button>&nbsp;
      </div>

    </div>
  </form>
</div>

</body>
</html>
