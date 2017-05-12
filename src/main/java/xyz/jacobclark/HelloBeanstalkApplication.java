package xyz.jacobclark;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import xyz.jacobclark.resources.HelloBeanstalkResource;

public class HelloBeanstalkApplication extends Application<HelloBeanstalkConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloBeanstalkApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-beanstalk";
    }

    @Override
    public void initialize(Bootstrap<HelloBeanstalkConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloBeanstalkConfiguration configuration,
                    Environment environment) {
        environment.jersey().register(new HelloBeanstalkResource());
    }

}