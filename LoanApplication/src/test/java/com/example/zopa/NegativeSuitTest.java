package com.example.zopa;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by m.karandish on 6/8/2019.
 */
@RunWith(Categories.class)
@Categories.IncludeCategory(NegativeCategoryTest.class)
@Categories.ExcludeCategory(PositiveCategoryTest.class)
@Suite.SuiteClasses({LoanApplicationTests.class})

public class NegativeSuitTest {
}
