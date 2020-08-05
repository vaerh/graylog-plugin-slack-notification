package com.sportalliance.graylog.plugins.slacknotification.config;

import javax.validation.constraints.NotBlank;

import org.graylog.events.contentpack.entities.EventNotificationConfigEntity;
import org.graylog.events.event.EventDto;
import org.graylog.events.notifications.EventNotificationConfig;
import org.graylog.events.notifications.EventNotificationExecutionJob;
import org.graylog.scheduler.JobTriggerData;
import org.graylog2.contentpacks.EntityDescriptorIds;
import org.graylog2.contentpacks.model.entities.references.ValueReference;
import org.graylog2.plugin.rest.ValidationResult;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

@AutoValue
@JsonTypeName(SlackEventNotificationConfig.TYPE_NAME)
@JsonDeserialize(builder = SlackEventNotificationConfig.Builder.class)
public abstract class SlackEventNotificationConfig implements EventNotificationConfig {
	public static final String TYPE_NAME = "slack-notification-v2";

	static final String FIELD_COLOR_LOW = "color_low";
	static final String FIELD_COLOR_NORMAL = "color_normal";
	static final String FIELD_COLOR_HIGH = "color_high";
	static final String FIELD_SERVER_URL = "server_url";
	static final String FIELD_BOT_TOKEN = "bot_token";
	static final String FIELD_CHANNEL = "channel";
	static final String FIELD_CUSTOM_MESSAGE = "custom_message";
	static final String FIELD_BACKLOG_ITEM_MESSAGE = "backlog_item_message";
	static final String FIELD_USER_NAME = "user_name";
	static final String FIELD_NOTIFY_CHANNEL = "notify_channel";
	static final String FIELD_LINK_NAMES = "link_names";
	static final String FIELD_ICON_URL = "icon_url";
	static final String FIELD_ICON_EMOJI = "icon_emoji";
	static final String FIELD_GRAYLOG_URL = "graylog_url";
	static final String FIELD_PROXY = "proxy";

	@JsonProperty(FIELD_COLOR_LOW)
	@NotBlank
	public abstract String colorLow();

	@JsonProperty(FIELD_COLOR_NORMAL)
	@NotBlank
	public abstract String colorNormal();

	@JsonProperty(FIELD_COLOR_HIGH)
	@NotBlank
	public abstract String colorHigh();

	@JsonProperty(FIELD_SERVER_URL)
	@NotBlank
	public abstract String serverUrl();

	@JsonProperty(FIELD_BOT_TOKEN)
	@NotBlank
	public abstract String botToken();

	@JsonProperty(FIELD_CHANNEL)
	@NotBlank
	public abstract String channel();

	@JsonProperty(FIELD_CUSTOM_MESSAGE)
	public abstract String customMessage();

	@JsonProperty(FIELD_BACKLOG_ITEM_MESSAGE)
	public abstract String backlogItemMessage();

	@JsonProperty(FIELD_USER_NAME)
	public abstract String userName();

	@JsonProperty(FIELD_NOTIFY_CHANNEL)
	public abstract boolean notifyChannel();

	@JsonProperty(FIELD_LINK_NAMES)
	public abstract boolean linkNames();

	@JsonProperty(FIELD_ICON_URL)
	public abstract String iconUrl();

	@JsonProperty(FIELD_ICON_EMOJI)
	public abstract String iconEmoji();

	@JsonProperty(FIELD_GRAYLOG_URL)
	public abstract String graylogUrl();

	@JsonProperty(FIELD_PROXY)
	public abstract String proxy();

	@Override
	@JsonIgnore
	public JobTriggerData toJobTriggerData(EventDto dto) {
		return EventNotificationExecutionJob.Data.builder().eventDto(dto).build();
	}

	public static SlackEventNotificationConfig.Builder builder() {
		return SlackEventNotificationConfig.Builder.create();
	}

	@Override
	@JsonIgnore
	public ValidationResult validate() {
		return new ValidationResult();
	}

	@AutoValue.Builder
	public static abstract class Builder implements EventNotificationConfig.Builder<SlackEventNotificationConfig.Builder> {
		@JsonCreator
		public static SlackEventNotificationConfig.Builder create() {
			return new AutoValue_SlackEventNotificationConfig.Builder()
					.type(TYPE_NAME);
		}

		@JsonProperty(FIELD_COLOR_LOW)
		public abstract SlackEventNotificationConfig.Builder colorLow(String colorLow);

		@JsonProperty(FIELD_COLOR_NORMAL)
		public abstract SlackEventNotificationConfig.Builder colorNormal(String colorNormal);

		@JsonProperty(FIELD_COLOR_HIGH)
		public abstract SlackEventNotificationConfig.Builder colorHigh(String colorHigh);

		@JsonProperty(FIELD_SERVER_URL)
		public abstract SlackEventNotificationConfig.Builder serverUrl(String serverUrl);

		@JsonProperty(FIELD_BOT_TOKEN)
		public abstract SlackEventNotificationConfig.Builder botToken(String botToken);

		@JsonProperty(FIELD_CHANNEL)
		public abstract SlackEventNotificationConfig.Builder channel(String channel);

		@JsonProperty(FIELD_CUSTOM_MESSAGE)
		public abstract SlackEventNotificationConfig.Builder customMessage(String customMessage);

		@JsonProperty(FIELD_BACKLOG_ITEM_MESSAGE)
		public abstract SlackEventNotificationConfig.Builder backlogItemMessage(String backlogItemMessage);

		@JsonProperty(FIELD_USER_NAME)
		public abstract SlackEventNotificationConfig.Builder userName(String userName);

		@JsonProperty(FIELD_NOTIFY_CHANNEL)
		public abstract SlackEventNotificationConfig.Builder notifyChannel(boolean notifyChannel);

		@JsonProperty(FIELD_LINK_NAMES)
		public abstract SlackEventNotificationConfig.Builder linkNames(boolean linkNames);

		@JsonProperty(FIELD_ICON_URL)
		public abstract SlackEventNotificationConfig.Builder iconUrl(String iconUrl);

		@JsonProperty(FIELD_ICON_EMOJI)
		public abstract SlackEventNotificationConfig.Builder iconEmoji(String iconEmoji);

		@JsonProperty(FIELD_GRAYLOG_URL)
		public abstract SlackEventNotificationConfig.Builder graylogUrl(String graylogUrl);

		@JsonProperty(FIELD_PROXY)
		public abstract SlackEventNotificationConfig.Builder proxy(String proxy);

		public abstract SlackEventNotificationConfig build();
	}

	@Override
	public EventNotificationConfigEntity toContentPackEntity(EntityDescriptorIds entityDescriptorIds) {
		return SlackEventNotificationConfigEntity.builder()
				.colorLow(ValueReference.of(colorLow()))
				.colorNormal(ValueReference.of(colorNormal()))
				.colorHigh(ValueReference.of(colorHigh()))
				.serverUrl(ValueReference.of(serverUrl()))
				.botToken(ValueReference.of(botToken()))
				.channel(ValueReference.of(channel()))
				.customMessage(ValueReference.of(customMessage()))
				.backlogItemMessage(ValueReference.of(backlogItemMessage()))
				.userName(ValueReference.of(userName()))
				.notifyChannel(ValueReference.of(notifyChannel()))
				.linkNames(ValueReference.of(linkNames()))
				.iconUrl(ValueReference.of(iconUrl()))
				.iconEmoji(ValueReference.of(iconEmoji()))
				.graylogUrl(ValueReference.of(graylogUrl()))
				.proxy(ValueReference.of(proxy()))
				.build();
	}
}
