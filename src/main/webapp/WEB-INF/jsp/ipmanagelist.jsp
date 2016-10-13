    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--
    Created by IntelliJ IDEA.
    User: APPLE
    Date: 15/12/18
    Time: 上午11:22
    To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>IP管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="ipManageForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/ipManagement/query_a_ip" method="post">
        <input type="hidden" name="pageSize" value="${ipManageForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${ipManageForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <input type="text" name="ip" id="ip"   size="30">&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a href="${pageContext.request.contextPath}/ipManagement/addIp" class="btn btn-green" data-toggle="dialog" data-width="400" data-height="400" data-id="dialog-normal" data-title="新增IP配置">新增IP</a>
    
        </div>
    </form>
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="100%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">IP地址</th>
        <th align="center">接入渠道</th>
        <th align="center">接入状态</th>
        <th align="center">创建时间</th>
        <th align="center">更新时间</th>
        <th align="center">操作人</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${ipManageForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.ip}"/>">
        <td align="center"><c:out value="${record.ip}"/></td>
        <td align="center"><c:out value="${record.inchannel}"/></td>
      <!--   <td align="center"><c:out value="${record.status}"/></td>
        --> 
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
            <a href="${pageContext.request.contextPath}/ipManagement/edit?sid=<c:out value="${record.ip}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息">修改</a>
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
        <span> 条，共 <c:out value="${ipManageForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${ipManageForm.pagination.itemCount}"/>" data-page-size="<c:out value="${ipManageForm.pageSize}"/>" data-page-current="<c:out value="${ipManageForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    </html>
