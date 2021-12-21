package com.sambit.Service;

import com.sambit.Bean.LoginBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Login;
import com.sambit.Entity.Reg;
import com.sambit.Repository.LoginRepository;
import com.sambit.Repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegServiceImpl implements RegService{

    @Autowired
    RegRepository regRepository;
    @Autowired
    LoginRepository loginRepository;

    @Override
    public String saveRegLoginData(RegBean regBean) {
        String res = "";
        Reg reg = new Reg();
        reg.setUsername(regBean.getUsername());
        reg.setPassword(regBean.getPassword());
        reg.setName(regBean.getName());
        reg.setPhn(regBean.getPhn());
        reg.setEmail(regBean.getEmail());
        reg.setDept(regBean.getDept());
        reg.setDob(regBean.getDob());
        reg.setGender(regBean.getGender());
        Reg result = regRepository.save(reg);
        System.out.println("Data Added to Registration Table!!");

        Login login = new Login();
        login.setUsername(regBean.getUsername());
        login.setPassword(regBean.getPassword());
        Login result1 = loginRepository.save(login);
        System.out.println("Data Added to Login Table!!");
        res = "Success";
        return res;
    }
}
