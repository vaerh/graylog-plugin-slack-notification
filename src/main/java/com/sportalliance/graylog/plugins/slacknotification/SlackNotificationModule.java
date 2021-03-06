package com.sportalliance.graylog.plugins.slacknotification;

import org.graylog2.plugin.PluginModule;

import com.sportalliance.graylog.plugins.slacknotification.config.SlackEventNotification;
import com.sportalliance.graylog.plugins.slacknotification.config.SlackEventNotificationConfig;

/**
 * Extend the PluginModule abstract class here to add you plugin to the system.
 */
public class SlackNotificationModule extends PluginModule {

	@Override
	protected void configure() {
		addNotificationType(SlackEventNotificationConfig.TYPE_NAME,
				SlackEventNotificationConfig.class,
				SlackEventNotification.class,
				SlackEventNotification.Factory.class);
	}
}
