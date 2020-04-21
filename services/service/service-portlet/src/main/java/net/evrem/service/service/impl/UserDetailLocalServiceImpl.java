package net.evrem.service.service.impl;

import net.evrem.dtos.form.UserForm;
import net.evrem.service.model.UserDetail;
import net.evrem.service.service.base.UserDetailLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the user detail local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link net.evrem.service.service.UserDetailLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 * 
 * @author Zdenek Vecek
 * @see net.evrem.service.service.base.UserDetailLocalServiceBaseImpl
 * @see net.evrem.service.service.UserDetailLocalServiceUtil
 */
public class UserDetailLocalServiceImpl extends UserDetailLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * net.evrem.service.service.UserDetailLocalServiceUtil} to access the user
	 * detail local service.
	 */

	private final Log log = LogFactoryUtil.getLog(getClass());

	public UserDetail createUserDetails(Long userId) throws SystemException {
		Long userDetailId = counterLocalService.increment(UserDetail.class.toString());
		System.out.println("User detail id from create userDetail: " + userDetailId);
		return super.createUserDetail(userDetailId);
	}

	public void saveUserDetail(UserForm userDetailForm) throws Exception {
		// UserDetail userDetail = null;
		// if (userDetailForm.getUserDetailId() != null) {
		// userDetail = getUserDetail(userDetailForm.getUserDetailId());
		// } else {
		// userDetail = createUserDetail(userDetailForm.getUserId());
		// }
		// userDetail.setTimeZoneId(userDetailForm.getTimeZoneId());
		//
		// if (userDetailForm.getUserDetailId() != null) {
		// updateUserDetail(userDetail);
		// } else {
		// addUserDetail(userDetail);
		// }
	}
}
