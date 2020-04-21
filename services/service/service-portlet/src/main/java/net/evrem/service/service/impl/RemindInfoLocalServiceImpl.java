package net.evrem.service.service.impl;

import net.evrem.dtos.form.RemindInfoForm;
import net.evrem.service.converter.RemindInfoFormToRemindInfoConverter;
import net.evrem.service.model.RemindInfo;
import net.evrem.service.service.RemindInfoLocalServiceUtil;
import net.evrem.service.service.base.RemindInfoLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the RemindInfo local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.RemindInfoLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Brian Wing Shun Chan
 * @see net.evrem.service.service.base.RemindInfoLocalServiceBaseImpl
 * @see net.evrem.service.service.RemindInfoLocalServiceUtil
 */
public class RemindInfoLocalServiceImpl extends RemindInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.RemindInfoLocalServiceUtil} to access the
	 * RemindInfo local service.
	 */
	public RemindInfo createRemindInfo() throws SystemException {
		Long remindInfoId = counterLocalService.increment(RemindInfo.class.toString());
		return super.createRemindInfo(remindInfoId);
	}

	public void saveRemindInfo(RemindInfoForm form, Long noteId) throws Exception {
		RemindInfo remindInfo = null;
		if (form != null && form.getRemindInfoId() != null) {
			remindInfo = RemindInfoLocalServiceUtil.getRemindInfo(form.getRemindInfoId());
		} else {
			remindInfo = createRemindInfo();
			remindInfo.setNoteId(noteId);
		}
		RemindInfoFormToRemindInfoConverter remindInfoConverter = new RemindInfoFormToRemindInfoConverter();
		remindInfoConverter.convertToRemindInfo(form, remindInfo);

		updateRemindInfo(remindInfo);

	}

	public RemindInfoForm getRemindInfoByNoteId(Long noteId) throws Exception {
		RemindInfo remindInfo = getRemindInfoPersistence().findByNoteId(noteId);
		RemindInfoForm form = null;
		if (remindInfo != null && !Long.valueOf(remindInfo.getRemindInfoId()).equals(0L)) {
			RemindInfoFormToRemindInfoConverter remindInfoConverter = new RemindInfoFormToRemindInfoConverter();
			form = remindInfoConverter.convertToForm(remindInfo, form);
		}
		return form;
	}

	public void deleteByNoteId(Long noteId) throws Exception {
		RemindInfo remindInfo = getRemindInfoPersistence().fetchByNoteId(noteId);
		if (remindInfo != null) {
			deleteRemindInfo(remindInfo);
		}
	}
}
