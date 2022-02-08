package com.sambit.Service;

import com.sambit.Bean.ImageBean;
import com.sambit.Bean.LoginBean;
import com.sambit.Bean.PersonalDataBean;
import com.sambit.Bean.RegBean;
import com.sambit.Entity.Image;
import com.sambit.Entity.Login;
import com.sambit.Entity.PersonalData;
import com.sambit.Entity.Reg;
import com.sambit.Repository.LoginRepository;
import com.sambit.Repository.PersonalDataRepository;
import com.sambit.Repository.RegRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegServiceImpl implements RegService{

    @Autowired
    RegRepository regRepository;
    @Autowired
    LoginRepository loginRepository;
    @Autowired
    PersonalDataRepository personalDataRepository;

    @Override
    public String saveRegLoginData(RegBean regBean) {
        String res = "";
        try {
            Reg reg = new Reg();
            reg.setUsername(regBean.getUsername());
            reg.setPassword(regBean.getPassword());
            reg.setName(regBean.getName());
            reg.setPhn(regBean.getPhn());
            reg.setEmail(regBean.getEmail());
            reg.setDept(regBean.getDept());
            reg.setDob(regBean.getDob());
            reg.setGender(regBean.getGender());
            Reg result = regRepository.save(reg);//It will save all data to an object of Reg ENTITY and print toString method
            System.out.println(result);
            System.out.println("Data Added to Registration Table!!");

            Login login = new Login();
            login.setUsername(regBean.getUsername());
            login.setPassword(regBean.getPassword());
            Login result1 = loginRepository.save(login);
            System.out.println("Data Added to Login Table!!");
            res = "Success";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Data Doesn't Added to Database.");
        }
        return res;
    }

    @Override
    public LoginBean checkLoginData(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        Login lb = loginRepository.findByUsernameAndPassword(username, password);
        LoginBean lb1 = new LoginBean();
        lb1.setUid(lb.getUid());
        lb1.setUsername(lb.getUsername());
        lb1.setPassword(lb.getPassword());
//        LoginBean lb = loginRepository.findByUsernameAndPassword(loginBean);
        return lb1;
    }

//    @Override
//    public RegBean getAllDataOfUser(LoginBean loginBean) {
//        String username = loginBean.getUsername();
//        String password = loginBean.getPassword();
//        Reg reg = regRepository.findAllByUsernameAndPassword(username, password);
//        RegBean rb = new RegBean();
//        rb.setSlno(reg.getSlno());
//        rb.setUsername(reg.getUsername());
//        rb.setPassword(reg.getPassword());
//        rb.setName(reg.getName());
//        rb.setEmail(reg.getEmail());
//        rb.setDept(reg.getDept());
//        rb.setGender(reg.getGender());
//        rb.setDob(reg.getDob());
//        return rb;
//    }

    @Override
    public List<Reg> getAllDataofUser(LoginBean loginBean) {
        String username = loginBean.getUsername();
        String password = loginBean.getPassword();
        List list = regRepository.findAllByUsernameAndPassword(username, password);
        return list;
    }

    @Override
    public List<Reg> getDataOfUser(int slno) {
        return regRepository.findAllBySlno(slno);
    }

    @Override
    public List<Reg> getDataOfUserByPhn(String phn) {
        return  regRepository.findAllByPhn(phn);
    }

    @Override
    public List<Reg> getDataofUserByUamePassandName(String uname, String password, String name) {
        return regRepository.findAllByUsernameAndPasswordAndName(uname, password, name);
    }

    @Override
    public String savePersonalDetails(PersonalDataBean personalDataBean) {
        String result = "";
        try {
            PersonalData personalData = new PersonalData();
            personalData.setName(personalDataBean.getName());
            personalData.setPanId(personalDataBean.getPanId());
            personalData.setAdharNo(personalDataBean.getAdharNo());
            personalDataRepository.save(personalData);
            System.out.println("Data Added to Database!!");
            result = "Success";
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Data doesn't Added to Database!!");
            result = "Fail";
        }
        return result;
    }

    @Override
    public List<PersonalData> getAllPersonalDetails() {
        return personalDataRepository.findAll();
    }

    @Override
    public String saveImageData(ImageBean imageBean) {
        Image image1 = new Image();
        image1.setImageName(imageBean.getImageName());
        return "Image";
    }
}
