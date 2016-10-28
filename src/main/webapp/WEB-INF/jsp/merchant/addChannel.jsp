<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加新渠道</title>
</head>
<body>

<div class="bjui-pageContent tableContent">
 <form id="pagerForm" name="payChannelForm" data-toggle="validate" novalidate="novalidate" action="${pageContext.request.contextPath}/channelManagement/addNewChannel" method="post">
    <div class="bjui-searchBar">
          <input type="hidden" name="merchNo"  value="${payChannelForm.merchNo}" />&nbsp;    
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">渠道编号：</label>
      <input type="text"  name="code" style="width:60%;" data-rule="渠道编号:required;" />&nbsp;
      </div>
      <div class="form-group" style="margin: 20px 0 20px; ">
      <label class="control-label x85">渠道名称：</label>
      <input type="text"  name="name" style="width:60%;" data-rule="渠道名称:required;" />&nbsp;
      </div>
      
     <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">是否强指：</label>       
       <select name="flag" data-toggle="selectpicker" data-rule="required">   
        <option value="0" selected>否</option>   
        <option value="1">是</option>                
      </select>       
    </div>
    
    <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">优先级：&nbsp;&nbsp;&nbsp;</label>       
       <select name="priority" data-toggle="selectpicker" data-rule="required">   
        <option value="0" selected>0</option>   
        <option value="1">1</option> 
        <option value="2">2</option>                
        <option value="3">3</option>                
        <option value="4">4</option>                
        <option value="5">5</option>                
        <option value="6">6</option>                
        <option value="7">7</option>                
        <option value="8">8</option>                
        <option value="9">9</option>                                       
      </select>       
    </div>
      
     <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">出入金支持：</label>       
       <select name="inOutSupport" data-toggle="selectpicker" data-rule="required">   
        <option value="in" selected>入金</option>   
        <option value="out">出金</option> 
        <option value="all">都支持</option>                                       
      </select>       
    </div> 
    
     <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">卡类型支持：</label>       
       <select name="cardTypeSupport" data-toggle="selectpicker" data-rule="required">   
        <option value="Debit" selected>借记卡</option>   
        <option value="Credit">贷记卡</option> 
        <option value="Prepaid">预付卡</option> 
        <option value="all">都支持</option>                                                                                     
      </select>       
    </div>  
    
   <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">AUTH开启状态：</label>       
       <select name="cardAuthOpenStatus" data-toggle="selectpicker" data-rule="required">   
        <option value="OFF" selected>关闭</option>   
        <option value="ON">开启</option>                                                                                     
      </select>       
    </div>  
    
    <div class="form-group" style="margin: 20px 0 20px; ">
       <label class="control-label x85">入金方式：</label>       
       <select name="inMethod" data-toggle="selectpicker" data-rule="required">   
        <option value="Back" selected>快捷支付</option>   
        <option value="GateWay">网关支付</option> 
        <option value="all">all</option>                                                                                                                                                                                                 
      </select>       
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
