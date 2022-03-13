package com.example.demoeasypoi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demoeasypoi.domain.dto.UserDTO;
import com.example.demoeasypoi.domain.po.User;
import com.example.demoeasypoi.domain.vo.UserVO;
import org.springframework.web.multipart.MultipartFile;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service
* @createDate 2022-03-13 12:36:58
*/
public interface UserService extends IService<User> {

    UserVO add(UserDTO userDTO);

    void exportUserList();

    boolean importUserList(MultipartFile file);
}
