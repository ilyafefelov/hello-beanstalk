# Hello Beanstalk

A Java 8 Dropwizard and ElasticBeanstalk seed.

### Overview

* Basic Dropwizard application with maven and a single resource at `/hello-beanstalk`
* Application is to be started via `mvn exec:java`
* `pom.xml` includes properties on how `exec:java` should start the application.
* ElasticBeanstalk will inspect the `Procfile` for instructions on how to start the process via `exec:java`.
* Dropwizard will be running on port 5000 once deployed.
* No additional plugins required, code is built on the ElasticBeanstalk instance.

### Getting up and running

You'll need the AWS ElasticBeanstalk CLI, you can get it via `pip`.

`awsebcli` depends on `python2.7` and `boto`, so you'll need to grab those too.

```
$ apt-get update
$ add-apt-repository ppa:fkrull/deadsnakes
$ apt-get install python2.7
$ easy_install3 pip
$ pip install boto
$ install --upgrade --user awsebcli
```

You'll then need to configure a IAM user with an ElasticBeanstalk policy within AWS.

Once created, you'll need to create the AWS config file for `awsebcli` supplying both aws_access_key_id and aws_secret_access_key of the new IAM user. 

```
$ mkdir ~/.aws
$ echo "[default]
      aws_access_key_id =
      aws_secret_access_key =
      region = us-west-1" >> ~/.aws/config
```

You'll need to ensure `awsebcli` is in your path.

```
$ echo "export PATH=~/.local/bin:$PATH" >> ~/.bash_profile
$ source ~/.bash_profile
```

Finally you will need to clone this repo, create the ElasticBeanstalk resource and deploy our code.

```
git clone git@github.com:imjacobclark/hello-beanstalk.git
$ eb init
$ eb create
$ eb deploy
```

Magic!
