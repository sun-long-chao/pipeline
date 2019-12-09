import hudson.model.*;
import groovy.json.*;
import groovy.json.JsonOutput;
import groovy.json.JsonSlurper;

//�鵽�ļ�
def find_files(filetype) {
	def files = findFiles(glob:filetype)
	for (file in files) {
		println file.name
	}
}
//��ȡJSON��ʽ���� ͨ���ļ�����
def read_json_file(file_path) {
	def propMap = readJSON file : file_path
	propMap.each {
	    println ( it.key + " = " + it.value )
	}
}
//��ȡJSON��ʽ����  ����Ϊjson��ʽ����
def read_json_file2(json_string) {
	def propMap = readJSON text : json_string
	propMap.each {
		println ( it.key + " = " + it.value )
	}
}

//��json����д���ļ�
def write_json_to_file(input_json, tofile_path) {
	def input1 = ''
	if(input_json.toString().endsWith(".json")) {
		input1 = readJSON file : input_json
	}else {
        //def jsonSlurper = new JsonSlurper()
        //��ȡ������obj����
        //def object = jsonSlurper.parseText(input_json)
        input1 = readJSON text : input_json
		println input1
	}
	writeJSON file: tofile_path, json: input1
}

//������ȡproperties�ļ�����
def read_properties(properties_file) {
	 def props = readProperties interpolate: true, file: properties_file
	 props.each {
		println ( it.key + " = " + it.value )
	 }
}

return this;
