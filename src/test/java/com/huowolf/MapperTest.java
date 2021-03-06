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

import java.util.ArrayList;
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
        //System.out.println(allEmploee.get(0));
    }

    @Test
    public void testEmployeeCount(){
        Integer count=employeeMapper.selectCount(new Employee());
        System.out.println(count);
    }


    @Test
    public void testFindAllUserTable(){
        List<UserTable> allUserTable = userMapper.findAllUserTable();
        System.out.println(allUserTable.size());
        System.out.println(allUserTable.get(0));
    }


    @Test
    public void testFindUserById(){
        User user = userMapper.selectByPrimaryKey(25);
        System.out.println(user);
    }

    @Test
    public void testFindUserTableByAreaIdAndDepartmentId(){
        List<UserTable> userTableList = userMapper.findUserTableByAreaIdAndDepartmentId(2, 2);
        System.out.println(userTableList.size());
        System.out.println(userTableList.get(0));
    }

    @Test
    public void testsearchUserTable(){
        List<UserTable> userTableList = userMapper.searchUserTable("name", "test-2");
        System.out.println(userTableList.size());
        System.out.println(userTableList.get(0));
    }

    @Test
    public void testSearchUserTableWithAreaIdAndDepartmentId(){
        List<UserTable> userTableList = userMapper.searchUserTableWithAreaIdAndDepartmentId("name","test",4,1);
        System.out.println(userTableList.size());
        System.out.println(userTableList.get(0));
    }

    @Test
    public void testFindUserTableById(){
        UserTable userTable = userMapper.findUserTableById(30);
        System.out.println(userTable);
    }

    @Test
    public void testInsertList(){
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("test"+i);
            user.setNumber("1518xx70"+i);
            userList.add(user);
        }
        userMapper.insertList(userList);
    }


    /**
     * 初始化一些用户测试数据
     */
    @Test
    public void testAddUser(){
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 4; j++) {
                for (int k = 0; k < 15; k++) {
                    User user = new User();
                    user.setName("test"+i+j+k);
                    user.setNumber("1518xx"+i+j+k);

                    int random=(int)(Math.random()*10);
                    if(random >= 5){
                        user.setSex("男");
                    }else{
                        user.setSex("女");
                    }

                    user.setIdNumber("4405051967080910"+j+k);
                    user.setAddress("广东省汕头市");
                    user.setTelphone("153213206"+i+j);
                    user.setAreaId(i);
                    user.setDepartmentId(j);
                    userMapper.insertSelective(user);
                }

            }
        }
    }
}
