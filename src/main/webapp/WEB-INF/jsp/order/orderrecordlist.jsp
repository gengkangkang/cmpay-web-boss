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
        <title>订单管理</title>     
          <style type="text/css">         
            input{width:120px;}     
          </style>   
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="orderRecordForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/ orderManagement/getOrderRecordByPara " method="post">
        <input type="hidden" name="pageSize" value="${orderRecordForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${orderRecordForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>订单号：</label>
             <input type="text" name="orderId" id="orderId" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <!-- <label>支付状态：</label>
            <input type="text" name="payStatus" id="payStatus" style="width:120px;">&nbsp;&nbsp;&nbsp;&nbsp; -->
             <label class="row-label">支付状态</label>
    
        <select data-toggle="selectpicker"  id="payStatus" name="payStatus" data-width="120">
            <option value="">全部</option>
            <option value="SUCC">成功</option>
            <option value="DEALING" >处理中</option>
            <option value="CANCEL">取消</option>
            <option value="FAIL">失败</option>
        </select> &nbsp;&nbsp;&nbsp;&nbsp;
    
             <label>创建时间：</label>
            <input type="text" name="startTime" id="startTime"  data-toggle="datepicker"  style="width:130px;">&nbsp;
            <label>-</label>
            <input type="text" name="endTime" id="endTime" data-toggle="datepicker" style="width:120px;">&nbsp;&nbsp;&nbsp;&nbsp; 
            
            <button type="submit" class="btn-default" data-icon="search" >查询</button>&nbsp    
        </div>
    </form>
    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="210%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">订单号</th>
        <th align="center">接入渠道</th>
        <th align="center">商户号</th>
        <th align="center">userID</th>
        <th align="center">业务渠道订单号</th>
        <th align="center">交易金额</th>
        <th align="center">交易类型</th>
        <th align="center">支付渠道</th>
        <th align="center">支付状态</th>
        <th align="center">响应码</th>
        <th align="center">响应信息</th>
<!--         <th align="center">订单有效期</th>
        <th align="center">订单到期时间</th>
 -->        <th align="center">订单来源IP</th>
        <th align="center">创建时间</th>
        <th align="center">更改时间</th>
        <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${orderRecordForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.orderId}"/></td>
        <td align="center"><c:out value="${record.inchannel}"/></td>
        <td align="center"><c:out value="${record.merNo}"/></td>
        <td align="center"><c:out value="${record.userId}"/></td>
        <td align="center"><c:out value="${record.origOrderNo}"/></td>
        <td align="center"><c:out value="${record.transAmt}"/></td>
       <%--  <td align="center"><c:out value="${record.transType}"/></td> --%>
        <c:choose>
            <c:when test="${record.transType=='RECHARGE'}">
                    <td align="center" style="color:green">充值</td>            
            </c:when>
            <c:when test="${record.transType=='WITHDRAW'}">
                    <td align="center" style="color:red">撤回</td> 
            </c:when>
            <c:when test="${record.transType=='	CONSUME'}">
                    <td align="center" style="color:green">消费</td> 
            </c:when>
            <c:when test="${record.transType=='CANCEL'}">
                    <td align="center" style="color:red">取消</td> 
            </c:when>            
            <c:otherwise>
                 <td align="center"><c:out value="${record.transType}"/></td>
         </c:otherwise>
       </c:choose>                 
       
        <td align="center"><c:out value="${record.payChannel}"/></td>
       <%--  <td align="center"><c:out value="${record.payStatus}"/></td> --%>
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
            <c:otherwise>
                 <td align="center"><c:out value="${record.payStatus}"/></td>
         </c:otherwise>
       </c:choose>                 
        <td align="center"><c:out value="${record.respCode}"/></td>
        <td align="center"><c:out value="${record.respMsg}"/></td>
<%--         <td align="center"><c:out value="${record.period}"/></td>
        <td align="center"><c:out value="${record.expireTime}"/></td> --%>
        <td align="center"><c:out value="${record.orderip}"/></td>
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
        <span> 条，共 <c:out value="${orderRecordForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${orderRecordForm.pagination.itemCount}"/>" data-page-size="<c:out value="${orderRecordForm.pageSize}"/>" data-page-current="<c:out value="${orderRecordForm.pageCurrent}"/>">
    </div>
    </div>

 
    
    </body>
    </html>