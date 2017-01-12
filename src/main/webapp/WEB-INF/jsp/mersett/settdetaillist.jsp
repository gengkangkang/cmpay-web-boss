    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>商户结算详情</title>        
    </head>
    <body>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="180%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">订单号</th>
        <th align="center">接入渠道</th>
        <th align="center">商户号</th>
        <th align="center">用户ID</th>
        <th align="center">交易金额</th>
        <th align="center">交易类型</th>
        <th align="center">交易日期</th>
        <th align="center">支付渠道</th>
        <th align="center">支付状态</th>
        <th align="center">结算状态</th>
        <th align="center">结算批次号</th> 
        <th align="center">创建时间</th> 
        <th align="center">更新时间</th>
        <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${settDetailForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.orderId}"/>">
        <td align="center"><c:out value="${record.orderId}"/></td>     
        <td align="center"><c:out value="${record.inchannel}"/></td>
        <td align="center"><c:out value="${record.merNo}"/></td>     
        <td align="center"><c:out value="${record.userId}"/></td>
        <td align="center"><c:out value="${record.transAmt}"/></td>     
        <c:choose>
            <c:when test="${record.transType=='01'}">
                  <td align="center" style="color:green">充值</td>
            </c:when>
            <c:when test="${record.transType=='02'}">
                    <td align="center" style="color:red">提现</td>            
            </c:when>
            <c:when test="${record.transType=='03'}">
                  <td align="center" style="color:green">消费</td>
            </c:when>
             <c:when test="${record.transType=='04'}">
                    <td align="center" style="color:red">撤单</td>            
             </c:when>
             <c:otherwise>
                 <td align="center"><c:out value="${record.transType}"/></td>
             </c:otherwise>
       </c:choose>
        <td align="center"><fmt:formatDate value="${record.transDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> 
        <td align="center"><c:out value="${record.payChannel}"/></td>       
        <td align="center"><c:out value="${record.payStatus}"/></td> 
         <c:choose>
            <c:when test="${record.settStatus=='0'}">
                   <td align="center" style="color:red">未汇总</td>
            </c:when>
            <c:when test="${record.settStatus=='1'}">
                    <td align="center" style="color:green">已汇总</td>            
             </c:when>
             <c:otherwise>
                 <td align="center"><c:out value="${record.settStatus}"/></td>
             </c:otherwise>
       </c:choose>     
        <td align="center"><c:out value="${record.batchId}"/></td>     
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>        
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>                
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
        <span> 条，共 <c:out value="${settDetailForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${settDetailForm.pagination.itemCount}"/>" data-page-size="<c:out value="${settDetailForm.pageSize}"/>" data-page-current="<c:out value="${settDetailForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    </html>
