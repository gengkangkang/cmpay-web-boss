<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改银行</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="suppBankForm" data-toggle="validate" novalidate="novalidate" action="${pageContext.request.contextPath}/channelManagement/updateSuppBank" method="post">
    <div class="bjui-searchBar">
          <input type="hidden" name="id"  value="${suppBankForm.id}" />&nbsp;    
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">pcBankCode：</label>
      <input type="text"  name="pcBankCode" value="${suppBankForm.pcBankCode}" style="width:60%;" data-rule="pcBankCode:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">pcBankName：</label>
      <input type="text"  name="pcBankName" value="${suppBankForm.pcBankName}" style="width:60%;" data-rule="pcBankName:required;" />&nbsp;
      </div>
      
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">银行编码：</label>
      <input type="text"  name="payBankCode" value="${suppBankForm.payBankCode}" style="width:60%;" data-rule="银行编码:required;" />&nbsp;
    </div>
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单笔最大限额：</label>
      <input type="text"  name="singleMaxAmount" value="${suppBankForm.singleMaxAmount}" style="width:60%;" data-rule="单笔最大限额:required;number" />&nbsp;
    </div>      
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单笔最小限额：</label>
      <input type="text"  name="singleMinAmount" value="${suppBankForm.singleMinAmount}" style="width:60%;" data-rule="单笔最小限额:required;number" />&nbsp;
    </div>  
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单日限额：</label>
      <input type="text"  name="dayMaxAmount" value="${suppBankForm.dayMaxAmount}" style="width:60%;" data-rule="单日限额:required;number" />&nbsp;
    </div>     
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单日限次：</label>
      <input type="text"  name="dayMaxTimes" value="${suppBankForm.dayMaxTimes}" style="width:60%;" data-rule="单日限次:required;digits" />&nbsp;
    </div>   
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单月限额：</label>
      <input type="text"  name="monthMaxAmount" value="${suppBankForm.monthMaxAmount}" style="width:60%;" data-rule="单月限额:required;number" />&nbsp;
    </div>     
    <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">单月限次：</label>
      <input type="text"  name="monthMaxTimes" value="${suppBankForm.monthMaxTimes}" style="width:60%;" data-rule="单月限次:required;digits" />&nbsp;
    </div>       
  
    
   <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">状态：</label>       
       <select name="status" data-toggle="selectpicker" data-rule="required">   
        <option value="OFF" selected>关闭</option>   
        <option value="ON">开启</option>                                                                                     
      </select>       
    </div>  
          
      
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</label>
      <input type="text"  name="remark" value="${suppBankForm.remark}" style="width:60%;" />
      </div>

      <div class="form-group" style="margin: 30px auto; ">
      <button type="submit" class="btn-green" data-icon="save" style="width:50%; margin-left: 21%;margin-top: 30px">修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>&nbsp;
      </div>

    </div>
  </form>
</div>

</body>
</html>
