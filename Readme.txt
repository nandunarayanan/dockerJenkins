8th Nov 2020 2
Testing in 130 server
git testing
testing for git trigger
The folder contains all the files which are required to perform a complete Test automation using Jenkins.
The test automation process includes the checkout, build, deployment, execution, publishing of results and etc.


UnitTest File has the Test Runner & Test Environment files 
	Test Environment will have the BOT & API files
	Test Runner will have the google test related files
	For Recording2
	
	
	Replacing ip address "192.168.43.242" with "192.168.43.144"
	"192.168.43.71" with "192.168.43.144"
Testing for the polling in the jenkins


pipeline {
    agent none
    stages {
        stage('Checkout') {
            agent any
            steps {                
                checkout([$class: 'GitSCM', 
				branches: [[name: "origin/master"]], 
				userRemoteConfigs: [[
                url: 'https://github.com/pipelineascodecourse/pipeline-agent-dockerfile.git']],
				extensions: [[$class: 'RelativeTargetDirectory', relativeTargetDir: 'checkout-directory']]
				])
            }
        }
        stage('dockerfile'){            
            agent {
                dockerfile {
                    customWorkspace '/var/lib/jenkins/workspace/pipeline-agent-dockerfile-customWorkspace/checkout-directory'
                } 
            }            
            steps{
                sh 'cat /etc/lsb-release'
            }
        }
    }
}

// Test
