package com.jay.app.web.rest;

import com.jay.app.ConnectedCitiesApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the ConnectedResource REST controller.
 *
 * @see ConnectedResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConnectedCitiesApp.class)
public class ConnectedResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ConnectedResource connectedResource = new ConnectedResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(connectedResource)
            .build();
    }

    /**
     * Test connected
     */
    @Test
    public void testConnected() throws Exception {
        restMockMvc.perform(get("/api/connected/connected"))
            .andExpect(status().isOk());
    }
}
