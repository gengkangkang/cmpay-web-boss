    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>商户管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="merForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/merchantManagement/getMerByPara" method="post">
        <input type="hidden" name="pageSize" value="${merForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${merForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <input type="text" name="merchantid" id="merchantid"   size="30">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a href="${pageContext.request.contextPath}/merchantManagement/addMer" class="btn btn-green" data-toggle="dialog" data-width="400" data-height="400" data-id="dialog-normal" data-title="新增商户">新增商户</a>
    
        </div>
    </form>
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">商户号</th>
        <th align="center">商户名称</th>
        <th align="center">企业代码</th>
        <th align="center">联系人</th>
        <th align="center">联系电话</th>
        <th align="center">状态</th>
        <th align="center">创建时间</th>
        <th align="center">更新时间</th>
        <th align="center">操作人</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${merForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.merchantid}"/></td>
         <td align="center"><c:out value="${record.merchantName}"/></td>
         <td align="center"><c:out value="${record.ecode}"/></td>
         <td align="center"><c:out value="${record.linkman}"/></td>
         <td align="center"><c:out value="${record.mobile}"/></td>
         

        <c:choose>
            <c:when test="${record.status=='ON'}">
                   <td align="center" style="color:green">启用</td>
         </c:when>
         <c:when test="${record.status=='OFF'}">
                    <td align="center" style="color:red">禁用</td>            
        </c:when>
         <c:otherwise>
                 <td align="center"><c:out value="${record.status}"/></td>
         </c:otherwise>
       </c:choose>
        
        <td align="center"><c:out value="${record.createtime}"/></td>
        <td align="center"><c:out value="${record.updatetime}"/></td>
        <td align="center"><c:out value="${record.operator}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/merchantManagement/edit?sid=<c:out value="${record.id}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息">修改</a>
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
        <span> 条，共 <c:out value="${merForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${merForm.pagination.itemCount}"/>" data-page-size="<c:out value="${merForm.pageSize}"/>" data-page-current="<c:out value="${merForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    </html>
