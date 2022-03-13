package com.example.demoeasypoi.service.impl;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demoeasypoi.domain.dto.UserDTO;
import com.example.demoeasypoi.domain.po.User;
import com.example.demoeasypoi.domain.vo.UserVO;
import com.example.demoeasypoi.mapper.UserMapper;
import com.example.demoeasypoi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-03-13 12:36:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private HttpServletRequest request;
    @Resource
    private HttpServletResponse response;

    @Override
    public UserVO add(UserDTO userDTO) {
        User user = BeanUtil.toBean(userDTO, User.class);
        this.save(user);
        return BeanUtil.toBean(user, UserVO.class);
    }

    @Override
    public void exportUserList() {
        List<User> userList = this.list();
        List<UserVO> userVOList = userList.stream().map(user -> BeanUtil.toBean(user, UserVO.class)).collect(Collectors.toList());
        ExportParams params = new ExportParams("用户列表", "用户列表", ExcelType.XSSF);
        Map<String, Object> map = MapUtil.newHashMap();
        map.put(NormalExcelConstants.DATA_LIST, userVOList);
        map.put(NormalExcelConstants.CLASS, UserVO.class);
        map.put(NormalExcelConstants.PARAMS, params);
        map.put(NormalExcelConstants.FILE_NAME, "userList");
        PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
    public boolean importUserList(MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        try {
            List<UserVO> userVOList = ExcelImportUtil.importExcel(
                    file.getInputStream(),
                    UserVO.class, params);
            return saveBatch(userVOList.stream().map(userVO -> BeanUtil.toBean(userVO, User.class)).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}




