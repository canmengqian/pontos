package com.pontons.mockito.mockmvc;

import com.pontons.mockito.Application;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author zhengzz
 * @version 1.0.0
 * @className MockMvcTest
 * @description TODO
 * @date 2021/8/31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class MockMvcTest {
    private MockMvc mockMvc;

    @Resource
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    public void testGet() throws Exception {
       /* MvcResult authResult;
        authResult = mockMvc.perform(get("/api/workitem/equipmenttypes")//使用get方式来调用接口。
                .contentType(MediaType.APPLICATION_XHTML_XML)//请求参数的类型
                .param("sessionid", "ZlbpLxXw")//请求的参数（可多个）
        ).andExpect(status().isOk())
                .andReturn();
        //获取数据
        JSONObject jsonObject = new JSONObject()(authResult.getResponse().getContentAsString());
        JSONArray jsonArrayData = null;
        try {
            jsonArrayData = (JSONArray) jsonObject.get("data");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        //获取第一个Array中的值,判断查询到的结果。
        JSONObject jsonObject_data = null;
        if (jsonArrayData.length() > 0) {
            jsonObject_data = (JSONObject) jsonArrayData.get(0);
        }
        //加断言，判断属性值的问题。
        Assert.assertNotNull(jsonObject.get("error_code"));
        Assert.assertEquals(jsonObject.get("error_code"), 0);
        Assert.assertNotNull(jsonObject.get("error_msg"));
        Assert.assertEquals(jsonObject.get("error_msg"), "操作成功");
        Assert.assertNotNull(jsonObject.get("data"));
        Assert.assertNotNull(jsonObject_data);
        Assert.assertEquals(jsonObject_data.get("equipmentty"), 1);
        Assert.assertEquals(jsonObject_data.get("equipmenttypename"), "xxxxx");*/
    }
}
