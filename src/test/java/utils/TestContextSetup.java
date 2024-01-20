package utils;

import page_objects.PageObjectManager;
import step_definitions.BaseStep;

import java.io.IOException;

public class TestContextSetup {
    public String productNameLandingPage;
    public BaseStep baseStep;
    public PageObjectManager pageObjectManager;
    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        baseStep = new BaseStep();
        pageObjectManager = new PageObjectManager(baseStep.webDriverManager());
        genericUtils = new GenericUtils(baseStep.webDriverManager());

    }
}
