<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<c:choose>
	<!-- 
		ZdryZdrkxxb zdryZdrk;//重点人口 子表02
		ZdryJgdxxxb zdryJgdxxxb;//监管对象01
		ZdryZszhjsbrxxb zdryZszhjsbrxxb;//肇事肇祸精神病人
		ZdryFzcsfryxxb zdryFzcsfryxxb;//非正常上访
		ZdryShbzdryxxb zdryShbzdryxxb;//涉环保
		ZdrySqsbzdryxxb zdrySqsbzdryxxb;//涉枪涉暴
		ZdrySqjzryxxb zdrySqjzryxxb;//社区矫正
		ZdrySgafzdryxxb zdrySgafzdryxxb;//涉公安访
		ZdryNrsxdxxxb zdryNrsxdxxxb;//纳入视线对象
		ZdryJgdxqxjdjb zdryJgdxqxjdjb;//监管对象请销假
	 -->
   <c:if test="${systemXzqh=='210000'}"> 
		<!-- 辽宁 -->
		<!-- 	01	社区矫正人员
				02	重点人口
				03	肇事肇祸精神病人
				04	非正常上访重点人员
				05	涉公安访重点人员
				06	其他关注对象
				07	涉环保重点人员
				08	涉枪涉爆重点人员 -->
		<c:choose>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='01'}"> 
 				<input type="hidden" id="zdrySqjzryxxb.id" name="zdrySqjzryxxb.id" value="${zdryZb.zdryZdryzb.id}" />  
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='02'}"> 
 				<input type="hidden" id="zdryZdrk.id" name="zdryZdrk.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='03'}"> 
 				<input type="hidden" id="zdryZszhjsbrxxb.id" name="zdryZszhjsbrxxb.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='04'}"> 
 				<input type="hidden" id="zdryFzcsfryxxb.id" name="zdryFzcsfryxxb.id" value="${zdryZb.zdryZdryzb.id}" />     
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='05'}"> 
 				<input type="hidden" id="zdrySgafzdryxxb.id" name="zdrySgafzdryxxb.id" value="${zdryZb.zdryZdryzb.id}" />   
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='06'}"> 
		   		<!-- TODO: -->
 				<%-- <input type="hidden" id="zdryFzcsfryxxb.id" name="zdryFzcsfryxxb.id" value="${zdryZb.zdryZdryzb.id}" />  --%>   
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='07'}"> 
 				<input type="hidden" id="zdryShbzdryxxb.id" name="zdryShbzdryxxb.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='08'}"> 
			<!-- 辽宁 -->
 				<input type="hidden" id="zdrySqsbzdryxxb.id" name="zdrySqsbzdryxxb.id" value="${zdryZb.zdryZdryzb.id}" />      
		   </c:when>
		   <c:otherwise>
			<!-- 其他 -->
		   </c:otherwise>
		</c:choose>
    
   </c:if>
   
   <c:if test="${systemXzqh=='210200'}"> 
	<!-- 大连 -->
		<c:choose>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='01'}"> 
 				<input type="hidden" id="zdryJgdxxxb.id" name="zdryJgdxxxb.id" value="${zdryZb.zdryZdryzb.id}" />  
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='02'}"> 
 				<input type="hidden" id="zdryZdrk.id" name="zdryZdrk.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='03'}"> 
 				<input type="hidden" id="zdryZdrk.id" name="zdryZdrk.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='04'}"> 
 				<input type="hidden" id="zdryZszhjsbrxxb.id" name="zdryZszhjsbrxxb.id" value="${zdryZb.zdryZdryzb.id}" />     
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='05'}"> 
 				<input type="hidden" id="zdryZszhjsbrxxb.id" name="zdryZszhjsbrxxb.id" value="${zdryZb.zdryZdryzb.id}" />   
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='06'}"> 
 				<input type="hidden" id="zdryFzcsfryxxb.id" name="zdryFzcsfryxxb.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='07'}"> 
 				<input type="hidden" id="zdryNrsxdxxxb.id" name="zdryNrsxdxxxb.id" value="${zdryZb.zdryZdryzb.id}" />    
		   </c:when>
		   <%-- <c:when test="${zdryZb.zdryZdryzb.zdrygllxdm=='08'}"> 
 				<input type="hidden" id="zdryZdryzbVO.id" name="zdryZdryzbVO.id" value="${zdryZb.zdryZdryzb.id}" />      
		   </c:when> --%>
		   <c:otherwise>
			<!-- 其他 -->
			<input type="hidden" name="nextsplx" id="nextsplx0" value="0"   />
		   </c:otherwise>
		</c:choose>
 
	<!-- 其他 -->
   </c:otherwise>
</c:if>
