package com.sambit.Service;

import com.sambit.Bean.LoginBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Reg;

import java.util.List;

public interface RegService {
    String saveRegLoginData(RegBean regBean);
    LoginBean checkLoginData(LoginBean loginBean);
    //RegBean getAllDataOfUser(LoginBean loginBean);
    List<Reg> getAllDataofUser(LoginBean loginBean);
    List<Reg> getDataOfUser(int slno);
}
