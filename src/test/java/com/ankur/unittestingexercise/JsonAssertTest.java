package com.ankur.unittestingexercise;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String str = "{\"id\":1,\"name\":\"ball\"}";

    @Test
    public void jasonAssertTestStrictFalse() throws JSONException {
        JSONAssert.assertEquals("{\"id\":1}", str, false);
    }

    @Test
    public void jasonAssertTestStrictTrue() throws JSONException {
        JSONAssert.assertEquals("{\"id\":1,\"name\":\"ball\"}", str, true);
    }

    @Test
    public void jasonAssertTestWithoutEscape() throws JSONException {
        JSONAssert.assertEquals("{id:1,name:ball}", str, true);
        //this will only work when name: value doesnt have any spaces
    }
}
