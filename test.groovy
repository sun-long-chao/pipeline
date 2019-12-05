import jenkins.model.*
 
println env.JOB_NAME
println env.BUILD_NUMBER
println env.WORKSPACE
 
pipeline{
	
	agent any
	stages{
		stage("init") {
			steps{
				script{
					println "��ӭ����Anthony��Pipeline�̡̳�"
					model_test = load env.WORKSPACE + "/Pipeline-learn-anthony/pipeline/test.groovy"
					println env.WORKSPACE ;
				}
			}
		}
		stage("Test Method") {
			steps{
				script{
					log_files = model_test.find_files('**/*.log')
				}
			}
		}
	}
}