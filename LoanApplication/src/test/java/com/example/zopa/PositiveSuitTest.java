package com.example.zopa;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by m.karandish on 6/8/2019.
 * This class is designed for categorizing positive application Testing

 */
@RunWith(Categories.class)
@Categories.IncludeCategory(PositiveCategoryTest.class)
@Categories.ExcludeCategory(NegativeCategoryTest.class)
@Suite.SuiteClasses({LoanApplicationTests.class})

public class PositiveSuitTest {
}
