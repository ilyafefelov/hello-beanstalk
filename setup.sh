#! /bin/bash

echo "Installing system packages"
apt-get update
add-apt-repository ppa:fkrull/deadsnakes
apt-get install python2.7

echo "Installing pip"
easy_install3 pip

echo "Installing ElasticBeanstalk CLI tools"
pip install boto
pip install --upgrade --user awsebcli

mkdir ~/.aws
echo "[default]
      aws_access_key_id =
      aws_secret_access_key =
      region = eu-west-1" >> ~/.aws/config

echo "export PATH=~/.local/bin:$PATH" >> ~/.bash_profile
source ~/.bash_profile

echo "Bundling project for EBS"
git clone git@github.com:imjacobclark/hello-beanstalk.git
eb init
eb create
eb deploy
