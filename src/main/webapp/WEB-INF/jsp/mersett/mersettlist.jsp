    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>商户结算管理</title>     
    </head>
    <body>
    <div class="bjui-pageHeader">
     <form id="pagerForm" name="settTotalForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/merSett/getSettOrderByPara" method="post">
        <input type="hidden" name="pageSize" value="${settTotalForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${settTotalForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>ID：</label>
            <input type="text" name="batchId" id="batchId" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>商户号：</label>
            <input type="text" name="merNo" id="merNo" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>创建时间：</label>
            <input type="text" name="startTime" id="startTime"  data-toggle="datepicker"  style="width:130px;">&nbsp;
            <label>-</label>
            <input type="text" name="endTime" id="endTime" data-toggle="datepicker" style="width:120px;">&nbsp;&nbsp;&nbsp;&nbsp; 
            
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp    
        </div>
    </form>
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="180%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">批次号</th>
        <th align="center">商户号</th>
        <th align="center">结算金额</th>
        <th align="center">结算日期</th>
        <th align="center">结算状态</th> 
        <th align="center">创建时间</th> 
         <th align="center">创建者</th> 
        <th align="center">修改时间</th> 
        <th align="center">修改者</th>
        <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${settTotalForm.pagination.list}" varStatus="status">
    <tr data-id="${record.batchId}"/>
        <td align="center"><a href="${pageContext.request.contextPath}/merSett/querySettDetailByBatchId?batchId=<c:out value="${record.batchId}" />" data-toggle="navtab" data-id="settdetail_tab" data-title="结算详情"><c:out value="${record.batchId}"/></a></td>
        <td align="center"><c:out value="${record.merNo}"/></td>
        <td align="center"><c:out value="${record.settAmt}"/></td>
        <td align="center"><fmt:formatDate value="${record.settDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.settStatus}"/></td>
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.createor}"/></td>
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.modifier}"/></td> 
        <td align="center"><c:out value="${record.remark}"/></td>
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
        <span> 条，共 <c:out value="${settTotalForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${settTotalForm.pagination.itemCount}"/>" data-page-size="<c:out value="${settTotalForm.pageSize}"/>" data-page-current="<c:out value="${settTotalForm.pageCurrent}"/>">
    </div>
    </div>
    </body>
    </html>