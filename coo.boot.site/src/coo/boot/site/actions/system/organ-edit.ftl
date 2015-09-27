<div class="page">
    <div class="pageContent">
        <@dwz.form action="/system/organ-update">
			<@s.hidden path="organ.id" />
	        <div class="pageFormContent" layoutH="56">
	        	<#if organ.parent??>
		            <dl class="nowrap">
		                <dt>上级机构：</dt>
		                <dd><@s.select id="organ.parent.edit" path="organ.parent" items=parentOrgans  itemValue="id" itemLabel="selectText" class="combox" /></dd>
		            </dl>
					<div class="divider" />
				</#if>
	            <dl>
	                <dt>机构名称：</dt>
	                <dd><@s.input path="organ.name" maxlength="60" class="required" /></dd>
	            </dl>
	            <dl>
	                <dt>序号：</dt>
	                <dd><@s.input path="organ.ordinal" min="0" max="99999" class="required digits" /></dd>
	            </dl>
	        </div>
	        <@dwz.formBar showCancelBtn=false>
	        	<#if organ.parent??>
		        	<#if organ.enabled == EnabledStatus.ENABLED>
		        		<li><@dwz.a class="button" href="/system/organ-disable?organ=${organ.id}" target="ajaxTodo" title="您是否确定要停用该机构？"><span>停用</span></@dwz.a></li>
		        	<#else>
		        		<li><@dwz.a class="button" href="/system/organ-enable?organ=${organ.id}" target="ajaxTodo" title="您是否确定要启用该机构？"><span>启用</span></@dwz.a></li>
		        	</#if>
	        	</#if>
	        </@dwz.formBar>
        </@dwz.form>
    </div>
</div>