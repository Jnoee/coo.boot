package coo.boot.core.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import coo.core.security.entity.UserSettingsEntity;

/**
 * 用户设置。
 */
@Entity
@Table(name = "Syst_UserSettings")
public class UserSettings extends UserSettingsEntity<Actor> {

}
