package com.huowolf;

import com.huowolf.dto.EmployeeTable;
import com.huowolf.dto.UserTable;
import com.huowolf.mapper.EmployeeMapper;
import com.huowolf.mapper.UserMapper;
import com.huowolf.model.Employee;
import com.huowolf.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by huowolf on 2018/10/13.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestFindAllEmploee(){
        List<EmployeeTable> allEmploee = employeeMapper.findAllEmploee();
        System.out.println(allEmploee.get(0));
        assert allEmploee.size()==1;
    }

    @Test
    public void testEmployeeCount(){
        Integer count=employeeMapper.selectCount(new Employee());
        System.out.println(count);
    }


    /**
     * 初始化一些用户数据
     */
    @Test
    public void testAddUser(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 4; j++) {
                User user = new User();
                user.setName("test-"+i+"-"+j);
                user.setNumber("1518xx"+i+j);
                user.setAreaId(i);
                user.setDepartmentId(j);
                userMapper.insertSelective(user);
            }
        }
    }

    @Test
    public void testFindAllUserTable(){
        List<UserTable> allUserTable = userMapper.findAllUserTable();
        System.out.println(allUserTable.size());
        System.out.println(allUserTable.get(0));

    }
}
