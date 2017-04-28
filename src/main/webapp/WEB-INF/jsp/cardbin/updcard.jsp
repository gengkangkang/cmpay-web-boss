    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>修改卡信息</title>
</head>
<body>
<div class="bjui-pageContent tableContent">
  <form id="dialog-updatecard" name="cardupdForm"  data-toggle="validate" action="${pageContext.request.contextPath}/cardManagement/updatecard" method="post">
  		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡bin：</label>
		      <input type="text"  name="cardBin" style="width:60%;" value="<c:out value="${cardupdForm.cardBin}"/>"  readonly />&nbsp;
		      </div>
		             
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡号长度：</label>
		      <input type="text"  name="cardLength" style="width:60%;" value="<c:out value="${cardupdForm.cardLength}"/>" data-rule="digits;卡号长度:required;"  readonly/>&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡类别：</label>
		      <select data-toggle="selectpicker" id="select_type" name="cardType" value="<c:out value="${cardupdForm.cardType}"/>" >&nbsp;
		           <option value="${cardupdForm.cardType}">${cardupdForm.cardType}</option>
		           <option value="D">D</option>
		           <option value="C">C</option>
		           <option value="P">P</option>
		           <option value="C1">C1</option>
		             
		        </select> 
		      </div>
		      			           
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行名称：&nbsp;&nbsp;&nbsp;</label>
		      <input type="text"  name="bankName" style="width:60%;" value="<c:out value="${cardupdForm.bankName}"/>" data-rule="银行名称:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">发卡银行ID：</label>
		      <input type="text"  name="issuerId" style="width:60%;" value="<c:out value="${cardupdForm.issuerId}"/>" data-rule="发卡银行ID:required" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡状态：</label>
		      <input type="text"  name="cardStat" style="width:60%;" value="<c:out value="${cardupdForm.cardStat}"/>" data-rule="卡状态:required" />&nbsp;
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡名称：</label>
		      <input type="text"  name="cardName" style="width:60%;" value="<c:out value="${cardupdForm.cardName}"/>" data-rule="卡名称:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡账户：</label>
		      <input type="text"  name="accountno" style="width:60%;" value="<c:out value="${cardupdForm.accountno}"/>"  data-rule="卡账户:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">备注：</label>
		      <input type="text"  name="remark" style="width:60%;" value="<c:out value="${cardupdForm.remark}"/>" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行编码：</label>
		      <input type="text"  name="cmpayCode" style="width:60%;" value="<c:out value="${cardupdForm.cmpayCode}"/>" data-rule="digits;银行编码:required;" />
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行名称：</label>
		      <input type="text"  name="cmpayName" style="width:60%;" value="<c:out value="${cardupdForm.cmpayName}"/>" data-rule="银行名称:required;" />
		      </div>
		
		      <div class="form-group" style="margin: 30px auto; ">
		         <button type="submit" class="btn-green" data-icon="save" style="width:20%; margin-left: 15%;margin-top: 10px" >修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>&nbsp;
		      <button type="reset" class="btn-green" data-icon="reset" style="width:20%; margin-left: 21%;margin-top: 10px" >重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</button>&nbsp;
		      </div>  
		      
         </form> 
     </div>  

</body>

</html>