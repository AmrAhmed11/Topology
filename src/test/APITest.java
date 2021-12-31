package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import topology.API;
import topology.Component;

import java.io.IOException;
import java.util.ArrayList;

class APITest {
    @Test
     void shouldReadJSON() {
        API TestAPI = new API();
        Assertions.assertTrue(TestAPI.readJSON("test.json"));
        Assertions.assertFalse(TestAPI.readJSON("FalseTest.json"));
        Assertions.assertEquals(1,TestAPI.queryTopologies().size());
        Assertions.assertTrue(TestAPI.readJSON("test.json"));
        Assertions.assertTrue(TestAPI.readJSON("test.json"));
        Assertions.assertEquals(3,TestAPI.queryTopologies().size());
    }

    @Test
    void shouldDeleteTopology() {
        API TestAPI = new API();
        TestAPI.readJSON("test.json");
        Assertions.assertEquals(1,TestAPI.queryTopologies().size());
        TestAPI.deleteTopology("test");
        Assertions.assertTrue(TestAPI.queryTopologies().isEmpty());
    }

    @Test
    void shouldWriteJSON() {
        API TestAPI = new API();
        TestAPI.readJSON("test.json");
        try {
            TestAPI.writeJSON("test","writeTest.json");
            TestAPI.deleteTopology("test");
            Assertions.assertTrue(TestAPI.readJSON("writeTest.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void shouldFindTopology() {
        API TestAPI = new API();
        Assertions.assertNull(TestAPI.findTopology("test"));
        TestAPI.readJSON("test.json");
        Assertions.assertEquals("test",TestAPI.findTopology("test").getId());
    }

    @Test
    void shouldQueryDevices() {
        API TestAPI = new API();
        TestAPI.readJSON("test.json");
        ArrayList<Component> Test = TestAPI.queryDevices("test");
        Assertions.assertEquals(2,Test.size());
    }

    @Test
    void shouldQueryTopologies() {
        API TestAPI = new API();
        Assertions.assertTrue(TestAPI.queryTopologies().isEmpty());
        TestAPI.readJSON("test.json");
        Assertions.assertEquals(1,TestAPI.queryTopologies().size());
    }
    @Test
    void shouldDeviceConnected(){
        API TestAPI = new API();
        Assertions.assertNull(TestAPI.deviceConnected("test","vdd"));
        TestAPI.readJSON("test.json");
        Assertions.assertEquals(1,TestAPI.deviceConnected("test","vdd").size());
    }
}