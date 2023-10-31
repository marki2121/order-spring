package com.learn.order.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.order.dto.request.UserDTO;
import com.learn.order.service.UserService;
import com.learn.order.service.UserServiceGet;
import com.learn.order.support.entity.UserSupp;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    private UserService userService;
    @MockBean 
    private UserServiceGet userServiceGet;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAllTest() throws Exception {
        ObjectMapper om = new ObjectMapper();

        when(userServiceGet.getAll()).thenReturn(UserSupp.getListUsers());

        mockMvc.perform(get("/user"))
        .andExpect(status().isOk())
        .andExpect(content().json(om.writeValueAsString(UserSupp.getListUsers())));
    }

    @Test
    public void deleteByIdSucc() throws Exception {
        when(userService.deleteById(anyLong())).thenReturn("Deleted.");

        mockMvc.perform(delete("/user/1"))
            .andExpect(status().isOk())
            .andExpect(content().string("Deleted."));
    }

    @Test
    public void updatebyId() throws Exception {
        ObjectMapper om = new ObjectMapper();

        when(userService.updatebyId(anyLong(), any(UserDTO.class))).thenReturn("Updated.");

        mockMvc.perform(put("/user/1")
            .contentType(MediaType.APPLICATION_JSON)
            .content(om.writeValueAsString(UserSupp.getUserDTO())))
            .andExpect(status().isOk())
            .andExpect(content().string("Updated."));
    }
}
