package com.mw.eleven11.UI.notifications;


import com.mw.eleven11.beanInput.NotificationDeleteInput;
import com.mw.eleven11.beanInput.NotificationInput;
import com.mw.eleven11.beanInput.NotificationMarkReadInput;

/**
 * Created by hp on 06-07-2017.
 */

public interface INotificationsPresenter {
    void actionNotificationsList(NotificationInput notificationInput);

    void notificationRead(NotificationMarkReadInput markReadInput);

    void clear_badges(String loginSessionKey);

    void deleteNotification(NotificationDeleteInput mDeleteInput);

}
