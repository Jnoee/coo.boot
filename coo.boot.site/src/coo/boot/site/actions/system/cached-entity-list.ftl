<div class="page">
    <div class="pageContent">
    	<div class="panelBar">
            <ul class="toolBar">
                <li>
                    <@dwz.a href="/system/cached-entity-evict" target="selectedTodo" rel="cachedEntityClasses" title="您确定要清理这些实体缓存吗？">
						<span class="a34">清理实体缓存</span>
					</@dwz.a>
                </li>
            </ul>
        </div>
        <table class="table" width="100%" layoutH="75">
            <thead>
                <tr>
                    <th width="80" align="center">
                        <@s.checkbox class="checkboxCtrl" group="cachedEntityClasses" value="true" />
                    </th>
                    <th>实体类名</th>
                </tr>
            </thead>
            <tbody>
                <#list cachedEntityClasses as cachedEntityClass>
	                <tr>
	                    <td>
	                        <@s.checkbox name="cachedEntityClasses" value=cachedEntityClass.name />
	                    </td>
	                    <td>${cachedEntityClass.name}</td>
	                </tr>
                </#list>
            </tbody>
        </table>
		<div class="panelBar"></div>
    </div>
</div>