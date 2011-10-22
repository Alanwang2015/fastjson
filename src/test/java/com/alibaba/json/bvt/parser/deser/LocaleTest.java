package com.alibaba.json.test.bvt.parser.deser;

import java.util.Locale;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.DefaultExtJSONParser;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.LocaleDeserializer;

public class LocaleTest extends TestCase {

    public void test_0() throws Exception {
        String input = JSON.toJSONString(Locale.US);
        Assert.assertEquals(Locale.US, JSON.parseObject(input, Locale.class));
    }

    public void test_1() throws Exception {
        Locale l1 = new Locale("l1");
        String input = JSON.toJSONString(l1);
        Assert.assertEquals(l1, JSON.parseObject(input, Locale.class));
    }

    public void test_2() throws Exception {
        Locale l1 = new Locale("l1", "l2", "l3");
        String input = JSON.toJSONString(l1);
        Assert.assertEquals(l1, JSON.parseObject(input, Locale.class));
    }

    public void test_null() throws Exception {
        String input = "null";
        DefaultExtJSONParser parser = new DefaultExtJSONParser(input, ParserConfig.getGlobalInstance(), JSON.DEFAULT_PARSER_FEATURE);

        LocaleDeserializer deser = new LocaleDeserializer();

        Assert.assertNull(deser.deserialze(parser, null, null));
    }
}
