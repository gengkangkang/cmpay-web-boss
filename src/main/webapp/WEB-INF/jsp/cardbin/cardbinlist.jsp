    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>cardbin管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="cardbinForm" data-toggle="ajaxsearch"  action="${pageContext.request.contextPath}/cardManagement/getCardbinByPara" method="post">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>卡bin：</label>
            <input type="text" name="cardBin" id="cardBin" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp 
            <button type="button" class="btn-green" data-toggle="dialog"  data-id="addbutton"  data-target="#dialog-addcard" data-width="600" data-height="600" data-title="增加新卡" data-on-close="freshMer">增加新卡</button>
	        
       </div>
      </form> 
    </div>
    
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">卡bin</th>
        <th align="center">卡号长度</th>
        <th align="center">卡类型</th>
        <th align="center">银行名称</th>
        <th align="center">发卡银行ID</th>
        <th align="center">卡状态</th>
        <th align="center">卡名称</th>
        <th align="center">卡账户</th>
        <th align="center">备注</th>
        <th align="center">银行编码</th>
        <th align="center">银行名称</th>
        <th align="center">操作人</th>
        <th align="center">操作时间</th>
        <th align="center">操作类型</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${cardbinForm.pagination.list}" varStatus="status">
   
    <tr data-id="<c:out value="${record.cardBin}"/>">
        <td align="center"><c:out value="${record.cardBin}"/></td>
        <td align="center"><c:out value="${record.cardLength}"/></td>
         <td align="center"><c:out value="${record.cardType}"/></td>
         <td align="center"><c:out value="${record.bankName}"/></td>
         <td align="center"><c:out value="${record.issuerId}"/></td>
         <td align="center"><c:out value="${record.cardStat}"/></td>
        <td align="center"><c:out value="${record.cardName}"/></td>
        <td align="center"><c:out value="${record.accountno}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center"><c:out value="${record.cmpayCode}"/></td>
        <td align="center"><c:out value="${record.cmpayName}"/></td>
        <td align="center"><c:out value="${record.modifier}"/></td>
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><a href="${pageContext.request.contextPath}/cardManagement/edit?cardBin=<c:out value="${record.cardBin}"/>&cardLength=<c:out value="${record.cardLength}"/>" data-title="修改卡信息" class="btn btn-red" data-toggle="dialog" data-width="600" data-height="600" data-on-close="fresh" >修改</a></td>     
      </tr>
      
    </c:forEach>
    </tbody>
    </table>
    </div>
    <div class="bjui-pageFooter" id="pageFooter">
    <div class="pages">
        <span>每页 </span>
        <div class="selectPagesize">
        <select data-toggle="selectpicker" data-toggle-change="changepagesize">
            <option value="10">10</option>
            <option value="30">30</option>
            <option value="60">60</option>
            <option value="100">100</option>
        </select>
        </div>
        <span> 条，共 <c:out value="${cardbinForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${cardbinForm.pagination.itemCount}"/>" data-page-size="<c:out value="${cardbinForm.pageSize}"/>" data-page-current="<c:out value="${cardbinForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    
    <div id="dialog-addcard" data-noinit="true" class="hide"   >
          <form id="pagerForm1" name="cardaddForm" data-toggle="validate"  action="${pageContext.request.contextPath}/cardManagement/addNewCardbin" method="post">
			     
			  <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡bin：</label>
		      <input type="text"  name="cardBin" style="width:60%;" value="<c:out value="${cardaddForm.cardBin}"/>" data-rule="digits;cardBin:required;" />&nbsp;
		      </div>
		            
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡号长度：</label>
		      <input type="text"  name="cardLength" style="width:60%" value="<c:out value="${cardaddForm.cardLength}"/>" data-rule="digits;卡号长度:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡类别：</label>
		      <select data-toggle="selectpicker"  name="cardType" data-width="120" value="<c:out value="${cardaddForm.cardType}"/>" style="width:60%;" data-rule="渠道:required;" >
		           <option value="" >请选择</option>
		           <option value="D">D</option>
		           <option value="C">C</option>
		           <option value="P">P</option>
		           <option value="C1">C1</option>
		             
		      </select> 
		      </div>
		      			           
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行名称：&nbsp;&nbsp;&nbsp;</label>
		      <input type="text"  name="bankName" style="width:60%;" value="<c:out value="${cardaddForm.bankName}"/>" data-rule="银行名称:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">发卡银行ID：</label>
		      <input type="text"  name="issuerId" style="width:60%;" value="<c:out value="${cardaddForm.issuerId}"/>" data-rule="digits;发卡银行ID:required" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡状态：</label>
		      <input type="text"  name="cardStat" style="width:60%;" value="<c:out value="${cardaddForm.cardStat}"/>" data-rule="卡状态:required" />&nbsp;
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡名称：</label>
		      <input type="text"  name="cardName" style="width:60%;" value="<c:out value="${cardaddForm.cardName}"/>" data-rule="卡名称:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">卡账户：</label>
		      <input type="text"  name="accountno" style="width:60%;" value="<c:out value="${cardaddForm.accountno}"/>"  data-rule="digits;卡账户:required;" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">备注：</label>
		      <input type="text"  name="remark" style="width:60%;" value="<c:out value="${cardaddForm.remark}"/>" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行编码：</label>
		      <input type="text"  name="cmpayCode" style="width:60%;" value="<c:out value="${cardaddForm.cmpayCode}"/>" data-rule="digits;银行编码:required;" />
		      </div>
		      
		       <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">银行名称：</label>
		      <input type="text"  name="cmpayName" style="width:60%;" value="<c:out value="${cardaddForm.cmpayName}"/>" data-rule="银行名称:required;" />
		      </div>
		
		      <div class="form-group" style="margin: 30px auto; ">
		      <button type="submit" class="btn-green" data-icon="save" style="width:20%; margin-left: 21%;margin-top: 10px" >新&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;增</button>&nbsp;
		      <button type="reset" class="btn-green" data-icon="reset" style="width:20%; margin-left: 21%;margin-top: 10px" >重&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;置</button>&nbsp;
		      </div>
	      			    
	      </form>
       </div>

      

    
    </body>
    <script type="text/javascript">
       function fresh(){
    	   $(this).navtab('refresh')
       }
    </script>
    
    </html>
