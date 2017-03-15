<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改IP</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="ipManageForm" data-toggle="validate" novalidate="novalidate"  action="${pageContext.request.contextPath}/ipManagement/updateIp" method="post">
      
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">IP&nbsp;&nbsp;地址：</label>
      <input type="text" value="<c:out value="${ipManageForm.ip}"/>" name="ip" style="width:60%;" data-rule="IP地址:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">接入渠道：</label> 
       <select data-toggle="selectpicker" value="<c:out value="${ipManageForm.inchannel}"/>"  name="inchannel" data-width="120" style="width:60%;" data-rule="required;" >
	            <option value=null selected = "selected" disabled="disabled" >请选择</option>
	            <option value="0000" >中民i投</option>
	            <option value="0001">核心柜面</option>
	            <option value="0002">O2O</option>
	            <option value="0003">云石</option>
	            <option value="0004">基金</option>
	            <option value="0005">保险客服</option>
	            <option value="0006">保险电销</option>
	            <option value="0007">大数据</option>
	            <option value="0008">OA</option>
	            <option value="0009">昱胜</option>
	            <option value="0010">三方支付</option>
	            <option value="0012">UMP</option>
	            <option value="0013" >CMPAY</option>
	            <option value="9999">一账通</option>        
       </select> 
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

    
  </form>
</div>

</body>
 	
</html>
