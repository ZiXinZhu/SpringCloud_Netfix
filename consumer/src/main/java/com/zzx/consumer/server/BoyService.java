package com.zzx.consumer.server;

import com.zzx.consumer.dao.UserDao;
import com.zzx.consumer.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoyService {

    @Autowired
    private UserDao userDao;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int addUser(UserEntity userEntity){

        int result = userDao.add(userEntity);

        if(true){
            throw new RuntimeException();
        }
        return result;
    }
}
