package ru.blogspot.feomatr.lab.test;


import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class DemoGen {

    public static void main(String[] args) {;
        //FIXME https://www.baeldung.com/junit-tests-run-programmatically-from-java
        TestRunner runner = new TestRunner();

//        TestExecutionSummary summary = runner.getListener().getSummary();

//        summary.printTo(new PrintWriter(System.out));
    }


}
