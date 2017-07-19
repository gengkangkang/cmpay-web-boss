<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新的IP</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="ipManageForm"  data-toggle="validate"  action="${pageContext.request.contextPath}/ipManagement/addNewIp" method="post">
    
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">IP&nbsp;&nbsp;地址：</label>
      <input type="text" value="<c:out value="${ipManageForm.ip}"/>" name="ip" style="width:60%;" data-rule="IP地址:required;" />&nbsp;
      </div>
      
      <div class="form-group" style="margin: 20px 0 20px; " data-testify="test">
      <label class="control-label x85">接入渠道：</label>
      <select data-toggle="selectpicker"  name="inchannel" data-width="120" style="width:60%;" data-rule="渠道:required;" >
	            <option value="" >请选择</option>
	            <option value="0000">中民i投</option>
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
	            <option value="0014" >小贷</option>
	            <option value="0015" >中民居家网</option>
	            <option value="9999">一账通</option>        
      </select> 
    
      </div>

      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
      <input type="text"  name="remark" style="width:60%;" />
      </div>

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" name="sub" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增</button>&nbsp;
      </div>

    </div>
  </form>

          
</script>

</body>


</html>
