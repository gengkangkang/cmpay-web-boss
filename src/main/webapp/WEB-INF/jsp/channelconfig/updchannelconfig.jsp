    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<title>修改渠道配置信息</title>
</head>
<body>
<div class="bjui-pageContent tableContent">
  <form id="dialog-updchannelconfig" name="channelConfigForm"  data-toggle="validate" action="${pageContext.request.contextPath}/channelConfigManagement/updateChanneConfig" method="post">
  		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">ID：</label>
		      <input type="text"  name="id" style="width:60%;" value="<c:out value="${channelConfigForm.id}"/>" readonly />&nbsp;
		      </div>  
  		       
  		       <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">商户号：</label>
		      <input type="text"  name="merNo" style="width:60%;" value="<c:out value="${channelConfigForm.merNo}"/>" data-rule="digits;required;" />&nbsp;
		      </div>
		            
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">渠道编号：</label>
		      <input type="text"  name="paychannelNo" style="width:60%" value="<c:out value="${channelConfigForm.paychannelNo}"/>" data-rule="required;" />&nbsp;
		      </div>
		      
		        <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">渠道名称：</label>
		      <input type="text"  name="paychannelName" style="width:60%" value="<c:out value="${channelConfigForm.paychannelName}"/>" data-rule="required;" />&nbsp;
		      </div>
		      
		          
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">appid：&nbsp;&nbsp;&nbsp;</label>
		      <input type="text"  name="appid" style="width:60%;" value="<c:out value="${channelConfigForm.appid}"/>"  />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">appsectet：</label>
		      <input type="text"  name="appsectet" style="width:60%;" value="<c:out value="${channelConfigForm.appsectet}"/>" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">apptype：</label>
		      <input type="text"  name="apptype" style="width:60%;" value="<c:out value="${channelConfigForm.apptype}"/>"  />&nbsp;
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">partnerkey：</label>
		      <input type="text"  name="partnerkey" style="width:60%;" value="<c:out value="${channelConfigForm.partnerkey}"/>" " />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">rsaprikey：</label>
		      <input type="text"  name="rsaprikey" style="width:60%;" value="<c:out value="${channelConfigForm.rsaprikey}"/>"  " />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">rsapubkey</label>
		      <input type="text"  name="rsapubkey" style="width:60%;" value="<c:out value="${channelConfigForm.rsapubkey}"/>" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">deskey：</label>
		      <input type="text"  name="deskey" style="width:60%;" value="<c:out value="${channelConfigForm.deskey}"/>" />
		      </div>
		      
		       <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">三方商户号：</label>
		      <input type="text"  name="thirdMerid" style="width:60%;" value="<c:out value="${channelConfigForm.thirdMerid}"/>"  />
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">返回链接：</label>
		      <input type="text"  name="returnUrl" style="width:60%;" value="<c:out value="${channelConfigForm.returnUrl}"/>"   />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">通知链接</label>
		      <input type="text"  name="notifyUrl" style="width:60%;" value="<c:out value="${channelConfigForm.notifyUrl}"/>" />&nbsp;
		      </div>
      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">备注：</label>
		      <input type="text"  name="remark" style="width:60%;" value="<c:out value="${channelConfigForm.remark}"/>"  />
		      </div>
		      
		      <div class="form-group" style="margin: 30px auto; ">
		        <button type="submit" class="btn-green" data-icon="save" style="width:20%; margin-left: 15%;margin-top: 10px" >修&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;改</button>&nbsp;
		      <button type="reset" class="btn-green" data-icon="reset" style="width:20%; margin-left: 21%;margin-top: 10px" >重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</button>&nbsp;
		      </div>
	      			    
         </form> 
     </div>  

</body>

</html>