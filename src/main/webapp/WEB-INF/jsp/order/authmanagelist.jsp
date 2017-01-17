    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    

    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>认证订单管理</title>     
    </head>
    <body>
    <div class="bjui-pageHeader">
     <form id="pagerForm" name="authForm" data-toggle="ajaxsearch" action="${pageContext.request.contextPath}/orderManagement/getAuthListByPara" method="post">
        <input type="hidden" name="pageSize" value="${authForm.pageSize}">
        <input type="hidden" name="pageCurrent" value="${authForm.pageCurrent}">
        <div class="bjui-searchBar">
            <label>查找资源：</label>
            <label>卡号：</label>
            <input type="text" name="cardno" id="cardno" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
            <label>证件号：</label>
            <input type="text" name="idno" id="idno" style="width:200px;">&nbsp;&nbsp;&nbsp;&nbsp;
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
        <th align="center">ID</th>
        <th align="center">商户号</th>
        <th align="center">userID</th>
        <th align="center">接入渠道</th>
        <th align="center">认证渠道</th>
        <th align="center">卡号</th> 
        <th align="center">卡类型</th> 
         <th align="center">证件号</th> 
        <th align="center">证件类型</th> 
        <th align="center">姓名</th>
        <th align="center">银行绑定手机号</th>
        <th align="center">银行代码</th>
        <th align="center">终端类型</th>
        <th align="center">状态</th>
        <th align="center">创建时间</th>
        <th align="center">备注</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${authForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
        <td align="center"><c:out value="${record.merchantid}"/></td>
        <td align="center"><c:out value="${record.userid}"/></td>
        <td align="center"><c:out value="${record.inchannel}"/></td>
        <td align="center"><c:out value="${record.authchannel}"/></td>
        <td align="center"><c:out value="${record.cardno}"/></td>
        <td align="center"><c:out value="${record.cardtype}"/></td>
        <td align="center"><c:out value="${record.idno}"/></td> 
         <td align="center"><c:out value="${record.idtype}"/></td> 
         <td align="center"><c:out value="${record.name}"/></td>
         <td align="center"><c:out value="${record.bankmobile}"/></td>
        <td align="center"><c:out value="${record.bankcode}"/></td>
        <td align="center"><c:out value="${record.terminaltype}"/></td>
        <%-- <td align="center"><c:out value="${record.status}"/></td> --%>
        <c:choose>
            <c:when test="${record.status=='SUCC'}">
                    <td align="center" style="color:green">成功</td>            
            </c:when>
            <c:when test="${record.status=='DEALING'}">
                   <td align="center" style="color:red">处理中</td>
            </c:when>
            <c:when test="${record.status=='FAIL'}">
                   <td align="center" style="color:red">失败</td>
            </c:when>
            <c:when test="${record.status=='CANCEL'}">
                   <td align="center" style="color:red">取消</td>
            </c:when>        
            <c:when test="${record.status=='NEW'}">
                    <td align="center" style="color:green">新建</td>            
            </c:when>
            <c:when test="${record.status=='WAIT'}">
                   <td align="center" style="color:red">未支付</td>
            </c:when>
            <c:when test="${record.status=='REFUNDING'}">
                   <td align="center" style="color:red">退款中</td>
            </c:when>
            <c:when test="${record.status=='REFUNDSUCC'}">
                   <td align="center" style="color:green">已退款</td>
            </c:when>
             <c:when test="${record.status=='REFUNDFAIL'}">
                   <td align="center" style="color:red">退款失败</td>
            </c:when>                 
            <c:otherwise>
                 <td align="center"><c:out value="${record.status}"/></td>
            </c:otherwise>
         </c:choose>                        
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
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
        <span> 条，共 <c:out value="${authForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${authForm.pagination.itemCount}"/>" data-page-size="<c:out value="${authForm.pageSize}"/>" data-page-current="<c:out value="${authFormForm.pageCurrent}"/>">
    </div>
    </div>

 
    
    </body>
    </html>