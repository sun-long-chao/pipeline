import hudson.model.*;

println "¡¾Jenkins JOB_NAME: ¡¿"+env.JOB_NAME;
println "¡¾Jenkins ¹¹½¨Â·¾¶¡¿"+env.BUILD_NUMBER;

pipeline{
	agent any 
    stages{
    	stage("init"){
    		steps{
    			script{
    			    model_test = env.WORKSPACE + "/pipeline/module/pipeline-demo-module.groovy";
    			}
			}
		}
		stage("read properties"){
		    steps{
		       script{
		       		properties_file = env.WORKSPACE+ "/pipeline/tesetDate/test.properties";
		       		model_test.read_properties(properties_file);
		       		println("========================");
		       }
 
		    }

		}

    
    }

}
