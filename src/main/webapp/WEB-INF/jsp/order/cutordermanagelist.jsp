    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>代扣订单管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="cutOrderForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/orderManagement/getCutOrderByPara" method="post">
        <input type="hidden" name="pageSize" value="${cutOrderForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${cutOrderForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>订单号：</label>
            <input type="text" name="orderId" id="orderId">&nbsp;
            <label>卡号：</label>
            <input type="text" name="cardNo" id="cardNo">&nbsp;
             <label>交易日期：</label>
            <input type="text" name="startTime" id="startTime" value="" data-toggle="datepicker" >&nbsp;
            <label>-</label>
            <input type="text" name="endTime" id="endTime" data-toggle="datepicker">&nbsp; 
            
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
    
        </div>
    </form>
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-nowrap="true" data-width="150%">
        <thead>
        <tr>
        <th align="center" style="width:230px">订单号</th>
        <th align="center" style="width:100px">接入渠道</th>
        <th align="center" style="width:150px">商户号</th>
        <th align="center" style="width:200px">用户Id</th>
        <th align="center" style="width:200px">渠道订单号</th>
        <th align="center" style="width:100px">交易金额</th>
        <th align="center" style="width:100px">支付渠道</th>
        <th align="center" style="width:100px">支付状态</th>
        <th align="center" style="width:100px">姓名</th>
        <th align="center" style="width:180px">卡号</th>
        <th align="center" style="width:120px">入账标志</th>        
        <th align="center" style="width:100px">入账状态</th>
        <th align="center" style="width:100px">响应码</th>
        <th align="center" style="width:100px">响应信息</th>
        <th align="center" style="width:100px">渠道响应码</th>
        <th align="center" style="width:100px">渠道相应信息</th>
        <th align="center" style="width:150px">创建时间</th>
        <th align="center" style="width:100px">初审人</th>
        <th align="center" style="width:100px">初审时间</th>
        <th align="center" style="width:100px">复审人</th>
        <th align="center" style="width:100px">复审时间</th>
        <th align="center" style="width:100px">备注</th>
        <th align="center" style="width:100px">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${cutOrderForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.orderId}"/></td>
        <td align="center">${record.inchannel}</td>
         <td align="center"><c:out value="${record.merNo}"/></td>
         <td align="center"><c:out value="${record.userId}"/></td>
         <td align="center"><c:out value="${record.origOrderNo}"/></td>
         <td align="center"><c:out value="${record.transAmt}"/></td>
         <td align="center"><c:out value="${record.payChannel}"/></td>
         <c:choose>
            <c:when test="${record.payStatus=='SUCC'}">
                    <td align="center" style="color:green">成功</td>            
            </c:when>
            <c:when test="${record.payStatus=='DEALING'}">
                   <td align="center" style="color:red">处理中</td>
            </c:when>
            <c:when test="${record.payStatus=='FAIL'}">
                   <td align="center" style="color:red">失败</td>
            </c:when>
            <c:when test="${record.payStatus=='CANCEL'}">
                   <td align="center" style="color:red">取消</td>
            </c:when>        
            <c:when test="${record.payStatus=='NEW'}">
                    <td align="center" style="color:green">新建</td>            
            </c:when>
            <c:when test="${record.payStatus=='WAIT'}">
                   <td align="center" style="color:red">未支付</td>
            </c:when>
            <c:when test="${record.payStatus=='REFUNDING'}">
                   <td align="center" style="color:red">退款中</td>
            </c:when>
            <c:when test="${record.payStatus=='REFUNDSUCC'}">
                   <td align="center" style="color:green">已退款</td>
            </c:when>
             <c:when test="${record.payStatus=='REFUNDFAIL'}">
                   <td align="center" style="color:red">退款失败</td>
            </c:when>                 
            <c:otherwise>
                 <td align="center"><c:out value="${record.payStatus}"/></td>
            </c:otherwise>
         </c:choose>                                
         <td align="center"><c:out value="${record.custName}"/></td>
         <td align="center"><c:out value="${record.cardNo}"/></td>        
        <%--  <td align="center"><c:out value="${record.isAcct}"/></td> --%>
         <c:choose>
            <c:when test="${record.isAcct=='0'}">
                   <td align="center" style="color:red">NO</td>
            </c:when>
            <c:when test="${record.isAcct=='1'}">
                    <td align="center" style="color:green">YES</td>            
            </c:when>
            <c:otherwise>
                 <td align="center"><c:out value="${record.isAcct}"/></td>
         </c:otherwise>
       </c:choose> 
       <%--   <td align="center"><c:out value="${record.inAcct}"/></td> --%>
       <c:choose>
            <c:when test="${record.inAcct=='0'}">
                   <td align="center" style="color:red">未入账</td>
            </c:when>
            <c:when test="${record.inAcct=='1'}">
                    <td align="center" style="color:green">已入账</td>            
            </c:when>
            <c:when test="${record.inAcct=='2'}">
                   <td align="center" style="color:red">处理中</td>
            </c:when>
            <c:when test="${record.inAcct=='3'}">
                   <td align="center" style="color:red">入账失败</td>
            </c:when>
            <c:when test="${record.inAcct=='4'}">
                   <td align="center" style="color:red">申请补账</td>
            </c:when>            
            <c:otherwise>
                 <td align="center"><c:out value="${record.inAcct}"/></td>
         </c:otherwise>
       </c:choose>
         <td align="center"><c:out value="${record.respCode}"/></td>
         <td align="center"><c:out value="${record.respMsg}"/></td>
         <td align="center"><c:out value="${record.thirdRespCode}"/></td>
         <td align="center"><c:out value="${record.thirdRespMsg}"/></td>
         <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>       
         <td align="center"><c:out value="${record.preAuditor}"/></td>
         <td align="center"><fmt:formatDate value="${record.preAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>                
         <td align="center"><c:out value="${record.recheckAuditor}"/></td>
         <td align="center"><fmt:formatDate value="${record.recheckAuditTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>                         
         <td align="center"><c:out value="${record.remark}"/></td>
                  
        
        <td align="center">
           <%--  <a href="${pageContext.request.contextPath}/orderManagement/edit?sid=<c:out value="${record.id}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息">补账</a> --%>
        <button type="button" class="btn btn-red" data-url="${pageContext.request.contextPath}/orderManagement/preAudit?id=${record.id}&isAcct=${record.isAcct}&inAcct=${record.inAcct}" data-toggle="doajax" data-confirm-msg="确定要给该用户重新入账吗？" >补账</button>        </td>
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
        <span> 条，共 <c:out value="${cutOrderForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${cutOrderForm.pagination.itemCount}"/>" data-page-size="<c:out value="${cutOrderForm.pageSize}"/>" data-page-current="<c:out value="${cutOrderForm.pageCurrent}"/>">
    </div>
    </div>
    
    </body>
    </html>
