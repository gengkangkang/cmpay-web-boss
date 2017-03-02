    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>支付渠道管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
   <form id="pagerForm" name="channelBaseForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/channelManagement/getChannelByPara" method="post">  
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>渠道编码：</label>
            <input type="text" name="code" id="code" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>渠道名称：</label>
            <input type="text" name="name" id="name" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp 
            <a href="${pageContext.request.contextPath}/channelManagement/addChannelBase" class="btn btn-green" data-toggle="dialog" data-width="400" data-height="400" data-id="dialog-normal" data-title="新增渠道" data-on-close="fresh">新增渠道</a>
    
        </div>
      </form> 
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">渠道编码</th>
        <th align="center">渠道名称</th>
        
        <th align="center">创建时间</th>
         <th align="center">创建人</th>        
        <th align="center">更新时间</th>
        <th align="center">更新人</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${channelBaseForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.code}"/></td>
         <td align="center"><c:out value="${record.name}"/></td>
                   
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>        
        <td align="center"><c:out value="${record.creator}"/></td>        
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>                
        <td align="center"><c:out value="${record.modifier}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/channelManagement/editCB?sid=<c:out value="${record.id}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息" data-on-close="fresh">修改</a>
        </td>
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
        <span> 条，共 <c:out value="${channelBaseForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${channelBaseForm.pagination.itemCount}"/>" data-page-size="<c:out value="${channelBaseForm.pageSize}"/>" data-page-current="<c:out value="${channelBaseForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    	 <script type="text/javascript">
	       function fresh(){
	    	   $(this).navtab('refresh')
	       }
	    </script>
    </html>
