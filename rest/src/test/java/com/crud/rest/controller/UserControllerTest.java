package com.crud.rest.controller;

import com.crud.rest.entity.User;
import com.crud.rest.repositroy.UserRepository;
import com.crud.rest.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.HeaderAssertions;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;
/*
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;  // API कॉल करने के लिए

    @MockBean
    private UserRepository userRepository;  // Mocked डेटा के लिए

    @MockBean
    private UserService userService;  // Mocked यूजर सर्विस के लिए

    @Autowired
    private ObjectMapper objectMapper;  // Java ऑब्जेक्ट को JSON में कन्वर्ट करने के लिए

    // टेस्ट केस: नया यूजर सफलतापूर्वक रजिस्टर होना चाहिए
    @Test
    void testCreateUser_Success() throws Exception {
        // यूजर डेटा सेट करना
        User user = new User();
        user.setUsername("john_doe");
        user.setPassword("password123");

        // जब findByusername() को कॉल किया जाए, तो null रिटर्न करे (यूजर मौजूद नहीं है)
        when(userRepository.findByusername("john_doe")).thenReturn(null);

        // जब saveUser() को कॉल किया जाए, तो सेव हुआ यूजर रिटर्न करे
        User savedUser = new User();
        savedUser.setUsername("john_doe");
        savedUser.setPassword(new BCryptPasswordEncoder().encode("password123"));
        when(userService.saveUser(any(User.class))).thenReturn(savedUser);

        // API कॉल करें और रिस्पॉन्स वैलिडेट करें
        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)  // JSON डेटा भेजें
                .content(objectMapper.writeValueAsString(user)))  // यूजर को JSON में बदलें
                .andExpect(status().isCreated())  // स्टेटस 201 हो
                .andExpect(jsonPath("$.username").value("john_doe"));  // रेस्पॉन्स में सही यूजरनाम हो
    }

    private HeaderAssertions post(String s) {
    }

    private StatusAssertions status() {
    }

    // टेस्ट केस: अगर यूजर पहले से मौजूद है तो एरर मैसेज आना चाहिए
    @Test
    void testCreateUser_UsernameAlreadyExists() throws Exception {
        // पहले से मौजूद यूजर का डेटा सेट करें
        User existingUser = new User();
        existingUser.setUsername("john_doe");
        existingUser.setPassword("password123");

        // जब findByusername() को कॉल किया जाए, तो यूजर रिटर्न करे (यूजर पहले से मौजूद है)
        when(userRepository.findByusername("john_doe")).thenReturn(existingUser);

        // API कॉल करें और रेस्पॉन्स वैलिडेट करें
        mockMvc.perform(post("/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(existingUser)))
                .andExpect(status().isOk())  // स्टेटस 200 होना चाहिए
                .andExpect(content().string("Username already exists"));  // सही मैसेज आए
    }
}

*/