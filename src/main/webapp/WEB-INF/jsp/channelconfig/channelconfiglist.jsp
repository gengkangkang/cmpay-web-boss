    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>支付渠道配置管理管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="channelConfigForm" data-toggle="ajaxsearch"  action="${pageContext.request.contextPath}/channelConfigManagement/getChannelConfigByPara" method="post">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>商户号：</label>
            <input type="text" name="merNo" id="merNo" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>渠道编号：</label>
            <input type="text" name="paychannelNo" id="paychannelNo" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>渠道名称：</label>
            <input type="text" name="paychannelName" id="paychannelName" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp 
            <button type="button" class="btn-green" data-toggle="dialog"  data-id="addbutton"  data-target="#dialog-configaddForm" data-width="600" data-height="800" data-title="增加新渠道" data-on-close="fresh">增加渠道</button>
	        
       </div>
      </form> 
    </div>
    
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="220%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">商户号</th>
        <th align="center">渠道编号</th>
        <th align="center">渠道名称</th>
        <th align="center">appid</th>
        <th align="center">appsectet</th>
        <th align="center">apptype</th>
        <th align="center">partnerkey</th>
        <th align="center">rsaprikey</th>
        <th align="center">rsapubkey</th>
        <th align="center"> deskey</th>
        <th align="center">三方商户号</th>
        <th align="center">返回链接</th>
        <th align="center">通知链接</th>
        <th align="center">创建时间</th>
        <th align="center">创建人</th>
        <th align="center">修改时间</th>
        <th align="center">修改人</th>
        <th align="center">备注</th>
        <th align="center">修改</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${channelConfigForm.pagination.list}" varStatus="status">
   
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.merNo}"/></td>
        <td align="center"><c:out value="${record.paychannelNo}"/></td>
         <td align="center"><c:out value="${record.paychannelName}"/></td>
         <td align="center"><c:out value="${record.appid}"/></td>
         <td align="center"><c:out value="${record.appsectet}"/></td>
         <td align="center"><c:out value="${record.apptype}"/></td>
        <td align="center"><c:out value="${record.partnerkey}"/></td>
        <td align="center"><c:out value="${record.rsaprikey}"/></td>
        <td align="center"><c:out value="${record.rsapubkey}"/></td>
        <td align="center"><c:out value="${record.deskey}"/></td>
        <td align="center"><c:out value="${record.thirdMerid}"/></td>
        <td align="center"><c:out value="${record.returnUrl}"/></td>
        <td align="center"><c:out value="${record.notifyUrl}"/></td>
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.creator}"/></td>
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.modifier}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        
        <td align="center"><a href="${pageContext.request.contextPath}/channelConfigManagement/edit?sid=<c:out value="${record.id}"/>" data-title="修改配置信息" class="btn btn-red" data-toggle="dialog" data-width="600" data-height="600" data-on-close="fresh" >修改</a></td>     
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
        <span> 条，共 <c:out value="${channelConfigForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${channelConfigForm.pagination.itemCount}"/>" data-page-size="<c:out value="${channelConfigForm.pageSize}"/>" data-page-current="<c:out value="${channelConfigForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    
    <div id="dialog-configaddForm" data-noinit="true" class="hide"   >
          <form id="pagerForm1" name="configaddForm" data-toggle="validate"  action="${pageContext.request.contextPath}/channelConfigManagement/addNewconfig" method="post">
			     
			  <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">商户号：</label>
		      <input type="text"  name="merNo" style="width:60%;" value="<c:out value="${configaddForm.merNo}"/>" data-rule="digits;required;" />&nbsp;
		      </div>
		            
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">渠道编号：</label>
		      <input type="text"  name="paychannelNo" style="width:60%" value="<c:out value="${configaddForm.paychannelNo}"/>" data-rule="required;" />&nbsp;
		      </div>
		      
		        <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">渠道名称：</label>
		      <input type="text"  name="paychannelName" style="width:60%" value="<c:out value="${configaddForm.paychannelName}"/>" data-rule="required;" />&nbsp;
		      </div>
		      
		          
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">appid：&nbsp;&nbsp;&nbsp;</label>
		      <input type="text"  name="appid" style="width:60%;" value="<c:out value="${configaddForm.appid}"/>"  />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">appsectet：</label>
		      <input type="text"  name="appsectet" style="width:60%;" value="<c:out value="${configaddForm.appsectet}"/>" />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">apptype：</label>
		      <input type="text"  name="apptype" style="width:60%;" value="<c:out value="${configaddForm.apptype}"/>"  />&nbsp;
		      
		          
		       <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">三方商户号：</label>
		      <input type="text"  name="thirdMerid" style="width:60%;" value="<c:out value="${configaddForm.thirdMerid}"/>"  />
		      </div>
		      
		      	      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">返回链接：</label>
		      <input type="text"  name="returnUrl" style="width:60%;" value="<c:out value="${configaddForm.returnUrl}"/>"   />&nbsp;
		      </div>
		      
		      <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">通知链接:</label>
		      <input type="text"  name="notifyUrl" style="width:60%;" value="<c:out value="${configaddForm.notifyUrl}"/>" />&nbsp;
		      </div>
      
		       <div class="form-group" style="margin: 20px 0 20px; ">
		      <label class="control-label x85">备注：</label>
		      <input type="text"  name="remark" style="width:60%;" value="<c:out value="${configaddForm.remark}"/>"  />
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
