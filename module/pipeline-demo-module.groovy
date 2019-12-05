import hudson.model.*;

//�鵽�ļ�
def find_files(filetype) {
	def files = findFiles(glob:filetype)
	for (file in files) {
		println file.name
	}
}
//ͨ���ļ����ƶ�ȡJSON��ʽ����
def read_json_file(file_path) {
	def propMap = readJSON file : file_path
	propMap.each {
	    println ( it.key + " = " + it.value )
	}
}
//����Ϊjson��ʽ����
def read_json_file2(json_string) {
	def propMap = readJSON text : json_string
	propMap.each {
		println ( it.key + " = " + it.value )
	}
}

return this;
