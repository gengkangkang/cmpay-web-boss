    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>交易订单管理</title>     
    </head>
    <body>
    <div class="bjui-pageHeader">
    <form id="pagerForm" name="orderRecordForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/orderManagement/getOrderRecordByPara " method="post">
        <input type="hidden" name="pageSize" value="${orderRecordForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${orderRecordForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>订单号：</label>
            <input type="text" name="orderId" id="orderId" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            
            <label class="row-label">支付状态</label>
    
            <select data-toggle="selectpicker"  id="payStatus" name="payStatus" data-width="120">
	            <option value="">全部</option>
	            <option value="SUCC">成功</option>
	            <option value="DEALING" >处理中</option>
	            <option value="CANCEL">取消</option>
	            <option value="FAIL">失败</option>
	            <option value="NEW">新建</option>
	            <option value="WAIT">未支付</option>
	            <option value="REFUNDING" >退款中</option>
	            <option value="REFUNDSUCC">已退款</option>
	            <option value="REFUNDFAIL">退款失败</option>        
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
        <th align="center">订单来源IP</th>
        <th align="center">创建时间</th>
        <th align="center">更改时间</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
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
                    <td align="center" style="color:red">代付</td> 
            </c:when>
            <c:when test="${record.transType=='PAYCUT'}">
                    <td align="center" style="color:red">代扣</td> 
            </c:when>
            <c:when test="${record.transType=='CONSUME'}">
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
        <td align="center"><c:out value="${record.respCode}"/></td>
        <td align="center"><c:out value="${record.respMsg}"/></td>
        <td align="center"><c:out value="${record.orderip}"/></td>
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center"><button type="button" class="btn btn-red" data-url="${pageContext.request.contextPath}/orderManagement/edit?sid=${record.id}" data-title="修改交易状态信息" data-toggle="dialog" data-width="600" data-height="300" data-on-close="fresh" >修改</button>  </td>
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
    
    <script type="text/javascript">
	    function fresh(){
	 	   $(this).navtab('refresh')
	    }
  </script> 
    </html>