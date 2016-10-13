package com.cmpay.boss.service;

import java.util.Map;

import com.cmpay.boss.domain.UserBO;
import com.cmpay.boss.util.Pagination;

/**
 * Created by APPLE on 15/12/27.
 */
public interface UserService {
    UserBO getByName(String username);

    UserBO getById(String username);

    Map updatePwd(UserBO userBO);

    Map addNewUsr(UserBO userBO);

    Map setAcctEnable(String usrId) throws Exception;

    Map setAcctDisable(String usrId) throws Exception;

    Pagination<UserBO> getAllUsr(UserBO userBO);

    Pagination<UserBO> getTheUsr(UserBO userBO);

    Map cancelAcctAuthority(String id, String uid) throws Exception;

    Map addAcctAuthority(String id, String uid);

}
