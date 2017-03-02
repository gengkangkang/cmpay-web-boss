    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>     
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>商户支付渠道管理</title>        
    </head>
    <body>
    <div class="bjui-pageHeader">
    
        <div class="bjui-searchBar" style="height:40px;margin-top:10px">
            <label style="font-size: 20px">${merchantName} |</label>
            <label style="font-size: 20px">${merchantId}</label>    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/channelManagement/addChannel?merchantId=${merchantId}" class="btn btn-green btn-nm" data-toggle="dialog" data-width="400" data-height="400" data-id="dialog-normal" data-title="新增渠道" data-on-close="fresh">新增渠道</a>
    
        </div>

    </div>
    <div class="bjui-pageContent tableContent">
    <table  class="table table-bordered table-hover table-striped table-top" data-toggle="tablefixed" data-width="180%" data-nowrap="true">
        <thead>
        <tr>
        <th align="center">ID</th>
        <th align="center">渠道编码</th>
        <th align="center">渠道名称</th>
        <th align="center">是否强指</th>
        <th align="center">优先级</th>
        <th align="center">开启状态</th>
        <th align="center">出入金支持</th>
        <th align="center">卡类型支持</th>
        <th align="center">AUTH开启状态</th>
        <th align="center">入金方式</th>
        <th align="center">商户号</th>
        
        <th align="center">创建时间</th>
         <th align="center">创建人</th>        
        <th align="center">更新时间</th>
        <th align="center">更新人</th>
        <th align="center">备注</th>
        <th align="center">操作</th>
        </tr>
        </thead>
        <tbody>
    <c:forEach var="record" items="${payChannelForm.pagination.list}" varStatus="status">
    <tr data-id="<c:out value="${record.id}"/>">
        <td align="center"><c:out value="${record.id}"/></td>
<%--         <td align="center"><c:out value="${record.code}"/></td>
 --%>         
         <td align="center"><a href="${pageContext.request.contextPath}/channelManagement/queryBankByChannelId?payChannelId=${record.code}&payChannelName=${record.name}" data-toggle="navtab" data-id="suppbank_tab" data-title="银行信息"><c:out value="${record.code}"/></a></td>
        
         <td align="center"><c:out value="${record.name}"/></td>
         
       <c:choose>
         <c:when test="${record.flag=='0'}">
                   <td align="center" style="color:green">否</td>
         </c:when>
         <c:when test="${record.flag=='1'}">
                    <td align="center" style="color:red">是</td>            
        </c:when>
         <c:otherwise>
                 <td align="center"><c:out value="${record.flag}"/></td>
         </c:otherwise>
       </c:choose>
                          
         <td align="center"><c:out value="${record.priority}"/></td>
         
       <c:choose>
            <c:when test="${record.openStatus=='ON'}">
                   <td align="center" style="color:green">启用</td>
         </c:when>
         <c:when test="${record.openStatus=='OFF'}">
                    <td align="center" style="color:red">禁用</td>            
        </c:when>
         <c:otherwise>
                 <td align="center"><c:out value="${record.openStatus}"/></td>
         </c:otherwise>
       </c:choose>
         
         
        <%--  <td align="center"><c:out value="${record.inOutSupport}"/></td> --%>
       <c:choose>
            <c:when test="${record.inOutSupport=='in'}">
                   <td align="center">入金</td>
         </c:when>
         <c:when test="${record.inOutSupport=='out'}">
                    <td align="center">出金</td>            
        </c:when>
        <c:when test="${record.inOutSupport=='all'}">
                    <td align="center">全部</td>            
        </c:when>
         <c:otherwise>
                 <td align="center"><c:out value="${record.inOutSupport}"/></td>
         </c:otherwise>
       </c:choose>
         
        <%--  <td align="center"><c:out value="${record.cardTypeSupport}"/></td> --%>
       <c:choose>
            <c:when test="${record.cardTypeSupport=='Debit'}">
                   <td align="center">借记卡</td>
         </c:when>
         <c:when test="${record.cardTypeSupport=='Credit'}">
                    <td align="center">贷记卡</td>            
        </c:when>
         <c:when test="${record.cardTypeSupport=='Prepaid'}">
                    <td align="center">预付卡</td>            
        </c:when>
        <c:when test="${record.cardTypeSupport=='all'}">
                    <td align="center">全部</td>            
        </c:when>
         <c:otherwise>
                 <td align="center"><c:out value="${record.cardTypeSupport}"/></td>
         </c:otherwise>
       </c:choose>
         
         <td align="center"><c:out value="${record.cardAuthOpenStatus}"/></td>
         <td align="center"><c:out value="${record.inMethod}"/></td>
         <td align="center"><c:out value="${record.merchNo}"/></td>                
<%--         <td align="center"><c:out value="${record.createTime}"/></td>
 --%>  
        <td align="center"><fmt:formatDate value="${record.createTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>        
        <td align="center"><c:out value="${record.creator}"/></td>        
        <td align="center"><fmt:formatDate value="${record.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss" /> </td>                
        <td align="center"><c:out value="${record.modifier}"/></td>
        <td align="center"><c:out value="${record.remark}"/></td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/channelManagement/edit?sid=<c:out value="${record.id}"/>" class="btn btn-green" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-normal" data-title="资源信息"  data-on-close="fresh">修改</a>
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
        <span> 条，共 <c:out value="${payChannelForm.pagination.itemCount}"/> 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="<c:out value="${payChannelForm.pagination.itemCount}"/>" data-page-size="<c:out value="${payChannelForm.pageSize}"/>" data-page-current="<c:out value="${payChannelForm.pageCurrent}"/>">
    </div>
    </div>

    </div>
    
    </body>
    
   		 <script type="text/javascript">
	       function fresh(){
	    	   $(this).navtab('refresh')
	       }
	    </script>
    </html>
