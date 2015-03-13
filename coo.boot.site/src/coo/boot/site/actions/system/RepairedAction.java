package coo.boot.site.actions.system;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import coo.core.hibernate.cache.EntityCacheManager;
import coo.core.hibernate.search.FullTextIndexer;
import coo.core.message.MessageSource;
import coo.core.security.annotations.Auth;
import coo.core.security.permission.AdminPermission;
import coo.mvc.util.NavTabResultUtils;

/**
 * 系统维护。
 */
@Controller
@RequestMapping("/system")
@Auth(AdminPermission.CODE)
public class RepairedAction {
	@Resource
	private FullTextIndexer fullTextIndexer;
	@Resource
	private EntityCacheManager entityCacheManager;
	@Resource
	private MessageSource messageSource;

	/**
	 * 查看全文索引实体类列表页面。
	 * 
	 * @param model
	 *            数据模型
	 */
	@RequestMapping("indexed-entity-list")
	public void listIndexedEntity(Model model) {
		model.addAttribute("indexedEntityClasses",
				fullTextIndexer.getIndexedEntityClasses());
	}

	/**
	 * 重建实体类全文索引。
	 * 
	 * @param indexedEntityClasses
	 *            实体类列表
	 * @return 返回操作成功信息。
	 */
	@RequestMapping("indexed-entity-build")
	public ModelAndView buildIndexedEntity(Class<?>[] indexedEntityClasses) {
		fullTextIndexer.startAndWait(indexedEntityClasses);
		return NavTabResultUtils.reload(messageSource
				.get("indexed.entity.build.success"));
	}

	/**
	 * 查看缓存实体类列表页面。
	 * 
	 * @param model
	 *            数据模型
	 */
	@RequestMapping("cached-entity-list")
	public void listCachedEntity(Model model) {
		model.addAttribute("cachedEntityClasses",
				entityCacheManager.getCachedEntityClasses());
	}
	
	/**
	 * 清理实体类缓存。
	 * 
	 * @param cachedEntityClasses
	 *            实体类列表
	 * @return 返回操作成功信息。
	 */
	@RequestMapping("cached-entity-evict")
	public ModelAndView evictIndexedEntity(Class<?>[] cachedEntityClasses) {
		entityCacheManager.evictEntityRegion(cachedEntityClasses);
		return NavTabResultUtils.reload(messageSource
				.get("cached.entity.evict.success"));
	}
}
