package net.evrem.service.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import net.evrem.service.service.ClpSerializer;
import net.evrem.service.service.GridItemLocalServiceUtil;
import net.evrem.service.service.NoteLocalServiceUtil;
import net.evrem.service.service.RemindInfoLocalServiceUtil;
import net.evrem.service.service.TodoNoteLocalServiceUtil;
import net.evrem.service.service.UserDetailLocalServiceUtil;
import net.evrem.service.service.UserEvremLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            GridItemLocalServiceUtil.clearService();

            NoteLocalServiceUtil.clearService();

            RemindInfoLocalServiceUtil.clearService();

            TodoNoteLocalServiceUtil.clearService();

            UserDetailLocalServiceUtil.clearService();

            UserEvremLocalServiceUtil.clearService();
        }
    }
}
