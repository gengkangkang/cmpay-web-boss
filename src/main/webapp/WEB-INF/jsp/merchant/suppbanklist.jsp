    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>支持银行管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    
        <div class="bjui-searchBar" style="height:40px;margin-top:10px">
            <label style="font-size: 20px">${payChannelName} |</label>
            <label style="font-size: 20px">${payChannelId}</label>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/channelManagement/addChannelBankMap?payChannelId=${payChannelId}" class="btn btn-green btn-nm" data-toggle="dialog" data-width="400" data-height="400" data-id="dialog-normal" data-title="新增银行">新增银行</a>
    
        </div>

    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="180%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">pcBankCode</th>
        <th align="center">pcBankName</th>
        <th align="center">支付渠道编码</th>
        <th align="center">银行编码</th>
        <th align="center">单笔最大限额</th>
        <th align="center">单笔最小限额</th>
        <th align="center">单日限额</th>
        <th align="center">单日限次</th>
        <th align="center">单月限额</th>
        <th align="center">单月限次</th>
        <th align="center">状态</th>
        
        <th align="center">创建时间</th>
         <th align="center">创建人</th>        
        <th align="center">更新时间</th>
        <th align="center">更新人</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${suppBankForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.pcBankCode}"/></td>
         <td align="center"><c:out value="${record.pcBankName}"/></td>                                   
         <td align="center"><c:out value="${record.payChannelCode}"/></td>
         <td align="center"><c:out value="${record.payBankCode}"/></td>
         <td align="center"><c:out value="${record.singleMaxAmount}"/></td>
         <td align="center"><c:out value="${record.singleMinAmount}"/></td>
         <td align="center"><c:out value="${record.dayMaxAmount}"/></td>
         <td align="center"><c:out value="${record.dayMaxTimes}"/></td>
         <td align="center"><c:out value="${record.monthMaxAmount}"/></td>
         <td align="center"><c:out value="${record.monthMaxTimes}"/></td>
         
         
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
         
 
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>        
        <td align="center"><c:out value="${record.creator}"/></td>        
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>                
        <td align="center"><c:out value="${record.modifier}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/channelManagement/editSuppBank?sid=<c:out value="${record.id}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息">修改</a>
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
        <span> 条，共 <c:out value="${suppBankForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${suppBankForm.pagination.itemCount}"/>" data-page-size="<c:out value="${suppBankForm.pageSize}"/>" data-page-current="<c:out value="${suppBankForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    </html>
