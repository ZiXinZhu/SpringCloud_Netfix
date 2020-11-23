package com.zzx.consumer.server;

import com.zzx.consumer.dao.UserDao;
import com.zzx.consumer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private BoyService boyService;

//    @Transactional(rollbackFor = Exception.class)
    public int addUser(UserEntity userEntity){
        UserEntity boy = new UserEntity();
        boy.setAge(88);
        boy.setHigh(88);
        boy.setNumber(88);
        userDao.add(userEntity);
        try {
            boyService.addUser(boy);
        }catch (Exception e){
            System.out.println("zxzczxczcz");
        }
//        if(true){
//            throw new RuntimeException();
//        }
        return 1;
    }
}
