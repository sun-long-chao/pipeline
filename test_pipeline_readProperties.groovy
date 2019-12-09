import hudson.model.*;

println "【Jenkins JOB_NAME: 】"+env.JOB_NAME;
println "【Jenkins 构建次数】"+env.BUILD_NUMBER;

pipeline{
	agent any 
    stages{
    	stage("init"){
    		steps{
    			script{
    			    model_test = env.WORKSPACE + "/module/pipeline-demo-module.groovy";
    			}
			}
		}
		stage("read properties"){
		    steps{
		       script{
		       		properties_file = env.WORKSPACE+ "/testData/test.properties";
		       		model_test.read_properties(properties_file);
		       		println("========================");
		       }
 
		    }

		}
    }
}
