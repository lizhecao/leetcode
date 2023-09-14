package com.zc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.stream.Stream;

/**
 * @author lizhecao 2021/4/29
 * @version 1.0
 */
public class SqlWhereJsonTest {
  private SqlWhereJson sqlWhereJson = new SqlWhereJson();
  private String json = "{ " +
      " \"a\": 1, " +
      " \"b\": { " +
      "  \"c\": 1.23 " +
      " }, " +
      " \"d\": \"hello\" " +
      "}";

  @Before
  public void before() {

  }

  @ParameterizedTest
  @MethodSource("isMatch")
  public void isMatch(String sql, Boolean result) {
    Assert.assertEquals(sqlWhereJson.isMatch(json, sql), result);
  }

  static Stream<Arguments> isMatch() {
    return Stream.of( // arguments:
        Arguments.arguments("a = \"something\"", false), //
        Arguments.arguments("a = 2 and d like \"he%\" or a = 1", true), //
        Arguments.arguments("a = 2 and d like \"he%\" or a = 1 and d like \"ha%\"", false),
        Arguments.arguments("a < 2 and d like \"he%\" or a = 1 and d like \"ha%\"", true),
        Arguments.arguments("a = 1 or d like \"ha%\" and a = 1 and d = \"hello\"", true));
  }
}