<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
      <title>代付订单管理</title>        
  </head>
  <body>
  <div class="bjui-pageHeader">
  <form id="pagerForm" name="payOrderForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/orderManagement/getPayOrderByPara" method="post">
      <input type="hidden" name="pageSize" value="${payOrderForm.pageSize}">
      <input type="hidden" name="pageCurrent" value="${payOrderForm.pageCurrent}">
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
  <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-nowrap="true" data-width="240%">
      <thead>
      <tr>
      <th align="center" style="width:230px">订单号</th>
      <th align="center" style="width:230px">接入渠道</th>
      <th align="center" style="width:180px">商户号</th>
      <th align="center" style="width:230px">用户Id</th>
      <th align="center" style="width:200px">渠道订单号</th>
      <th align="center" style="width:200px">回退地址</th>
       <th align="center" style="width:200px">银行编号</th>
      <th align="center" style="width:200px">卡号</th>
       <th align="center"style="width:200px">城市</th>

      <th align="center" style="width:200px">客户编号</th>
      <th align="center" style="width:200px">客户名字</th>
      <th align="center" style="width:200px">通知标志</th>        

      <th align="center" style="width:200px">通知次数</th>
      <th align="center" style="width:200px">通知链接</th>
      <th align="center" style="width:200px">订单描述</th>

      <th align="center" style="width:200px">支付状态</th>
 
      <th align="center" style="width:200px">支付渠道</th>   
      <th align="center" style="width:200px">省份</th>
      <th align="center" style="width:200px">三方订单编号</th>
      <th align="center" style="width:200px">交易金额</th>
      <th align="center" style="width:200px">响应编号</th>
      <th align="center" style="width:200px">相应信息</th>
      <th align="center" style="width:200px">thirdRespCode</th>
      <th align="center" style="width:200px">thirdRespMsg</th>
      <th align="center" style="width:200px">订单IP</th>
      <th align="center" style="width:200px">创建时间</th>
      <th align="center" style="width:200px">修改时间</th>
      <th align="center" style="width:200px">备注</th>

    
      </tr>
      </thead>
      <tbody>
  <c:forEach var="record" items="${payOrderForm.pagination.list}" varStatus="status">
  <tr data-id="<c:out value="${record.orderId}"/>">
      <td align="center"><c:out value="${record.orderId}"/></td>
      <td align="center"><c:out value="${record.orderId}"/></td>
       <td align="center"><c:out value="${record.merNo}"/></td>
       <td align="center"><c:out value="${record.userId}"/></td>
       <td align="center"><c:out value="${record.origOrderNo}"/></td>
       <td align="center"><c:out value="${record.backUrl}"/></td>
       <td align="center"><c:out value="${record.bankCode}"/></td>
       <td align="center"><c:out value="${record.cardNo}"/></td>
       <td align="center"><c:out value="${record.city}"/></td>
     
       <td align="center"><c:out value="${record.custId}"/></td>
       <td align="center"><c:out value="${record.custName}"/></td>
       <td align="center"><c:out value="${record.hasnotify}"/></td>      

       <td align="center"><c:out value="${record.notifyCount}"/></td>
       <td align="center"><c:out value="${record.notifyUrl}"/></td>
       <td align="center"><c:out value="${record.orderDesc}"/></td>

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
       
    
       <td align="center"><c:out value="${record.payChannel}"/></td>                 
       <td align="center"><c:out value="${record.prov}"/></td>  

       <td align="center"><c:out value="${record.thirdOrderNo}"/></td>
       <td align="center"><c:out value="${record.transAmt}"/></td>                 
       <td align="center"><c:out value="${record.respCode}"/></td>
       <td align="center"><c:out value="${record.respMsg}"/></td>  
       <td align="center"><c:out value="${record.thirdRespCode}"/></td>
       <td align="center"><c:out value="${record.thirdRespMsg}"/></td>
       <td align="center"><c:out value="${record.orderip}"/></td>
       <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>            
       <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
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
      <span> 条，共 <c:out value="${payOrderForm.pagination.itemCount}"/> 条</span>
  </div>
  <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${payOrderForm.pagination.itemCount}"/>" data-page-size="<c:out value="${payOrderForm.pageSize}"/>" data-page-current="<c:out value="${payOrderForm.pageCurrent}"/>">
  </div>
  </div>
  
  </body>
 <script type="text/javascript">
      function fresh(){
   	   $(this).navtab('refresh')
      }
</script>
  </html>
