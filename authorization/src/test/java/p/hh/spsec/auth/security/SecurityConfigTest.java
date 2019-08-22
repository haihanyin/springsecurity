package p.hh.spsec.auth.security;


import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SecurityConfigTest.ContextConfig.class)
@WebAppConfiguration
public class SecurityConfigTest {

    @Configuration
    @ComponentScan(basePackages = "p.hh.spsec.auth")
    public static class ContextConfig { }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setup() {
         mvc = MockMvcBuilders.webAppContextSetup(wac).apply(springSecurity()).build();
    }

    @Test
    public void gotoAdminShouldBeRedirected() throws Exception {
        mvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(redirectedUrlPattern("**/login"));
    }

    @Test
    public void gotoPublicShouldBeOk() throws Exception {
        mvc.perform(get("/public"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, I am Anonymous"));

    }

    @Test
    @WithMockUser(username = "admin", password = "admin1", roles = {"ADMIN"})
    public void adminGotoAdminPageShouldBeOk() throws Exception {
        mvc.perform(get("/admin"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, I am Admin"))
                .andExpect(authenticated().withRoles("ADMIN"));
    }

    @Test
    public void loginTest() throws Exception {
        mvc.perform(formLogin("/login").user("user").password("user1"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(authenticated().withRoles("USER"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin1", roles = {"ADMIN"})
    public void logoutTest() throws Exception {
        mvc.perform(get("/admin"))
                .andExpect(status().isOk())
                .andExpect(authenticated());

        mvc.perform(logout("/mylogout"))
                .andDo(print())
                .andExpect(status().is(302))
                .andExpect(redirectedUrl("/iamout"))
                .andExpect(unauthenticated());
    }
}