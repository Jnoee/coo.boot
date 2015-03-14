package coo.boot.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import coo.core.security.entity.UserSettingsEntity;

/**
 * 用户设置。
 */
@Entity
@Table(name = "Syst_UserSettings")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class UserSettings extends UserSettingsEntity<Actor> {

}
