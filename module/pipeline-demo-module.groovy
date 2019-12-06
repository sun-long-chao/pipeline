import hudson.model.*;
import groovy.json.*;
import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;

//查到文件
def find_files(filetype) {
	def files = findFiles(glob:filetype)
	for (file in files) {
		println file.name
	}
}
//读取JSON格式数据 通过文件名称
def read_json_file(file_path) {
	def propMap = readJSON file : file_path
	propMap.each {
	    println ( it.key + " = " + it.value )
	}
}
//读取JSON格式数据  参数为json格式数据
def read_json_file2(json_string) {
	def propMap = readJSON text : json_string
	propMap.each {
		println ( it.key + " = " + it.value )
	}
}

//将json数据写入文件
def write_json_to_file(input_json, tofile_path) {
	def input1 = ''
	if(input_json.toString().endsWith(".json")) {
		input1 = readJSON file : input_json
	}else {
	
        def jsonSlurper = new JsonSlurper()
        println "===(￣▽￣) (￣▽￣)  (￣▽￣)   ==333"
        //获取到的是Map对象
        def map = jsonSlurper.parseText(input_json)
 		println "===(￣▽￣) (￣▽￣)  (￣▽￣)   ==444"
		input1 = map
	}
	writeJSON file: tofile_path, json: input1
}

return this;
