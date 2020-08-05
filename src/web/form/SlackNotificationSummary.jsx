import React from 'react';
import PropTypes from 'prop-types';

import CommonNotificationSummary from './CommonNotificationSummary';

class SlackNotificationSummary extends React.Component {
  static propTypes = {
    type: PropTypes.string.isRequired,
    notification: PropTypes.object,
    definitionNotification: PropTypes.object.isRequired,
  };

  static defaultProps = {
    notification: {},
  };

  render() {
    const { notification } = this.props;
    return (
      <CommonNotificationSummary {...this.props}>
        <React.Fragment>
          <tr>
            <td>Color for "Low" priority message</td>
            <td>{notification.config.color_low}</td>
          </tr>
          <tr>
            <td>Color for "Normal" priority message</td>
            <td>{notification.config.color_normal}</td>
          </tr>
          <tr>
            <td>Color for "High" priority message</td>
            <td>{notification.config.color_high}</td>
          </tr>
          <tr>
            <td>Server URL</td>
            <td>{notification.config.server_url}</td>
          </tr>
          <tr>
            <td>Webhook URL</td>
            <td>{notification.config.bot_token}</td>
          </tr>
          <tr>
            <td>Channel</td>
            <td>{notification.config.channel}</td>
          </tr>
          <tr>
            <td>Custom Message</td>
            <td>{notification.config.custom_message}</td>
          </tr>
          <tr>
            <td>Backlog Item Message</td>
            <td>{notification.config.backlog_item_message}</td>
          </tr>
          <tr>
            <td>User Name</td>
            <td>{notification.config.user_name}</td>
          </tr>
          <tr>
            <td>Notify Channel</td>
            <td>{notification.config.notify_channel}</td>
          </tr>
          <tr>
            <td>Link Names</td>
            <td>{notification.config.link_names}</td>
          </tr>
          <tr>
            <td>Icon URL</td>
            <td>{notification.config.icon_url}</td>
          </tr>
          <tr>
            <td>Icon Emoji</td>
            <td>{notification.config.icon_emoji}</td>
          </tr>
          <tr>
            <td>Graylog URL</td>
            <td>{notification.config.graylog_url}</td>
          </tr>
          <tr>
            <td>Proxy</td>
            <td>{notification.config.proxy}</td>
          </tr>
        </React.Fragment>
      </CommonNotificationSummary>
    );
  }
}

export default SlackNotificationSummary;
