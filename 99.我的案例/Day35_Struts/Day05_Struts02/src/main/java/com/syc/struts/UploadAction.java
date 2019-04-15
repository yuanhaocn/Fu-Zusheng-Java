package com.syc.struts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private File file;
	private String fileFileName;// 注意:该属性的后缀必须是FileName;xxxFileName
	private String fileContentType;// 注意:该属性的后缀必须是ContentType.xxxContentType

	@SuppressWarnings("deprecation")
	public String upload() {

		// 文件要上传到的服务器里的路径
		String path = ServletActionContext.getRequest().getRealPath("/upload");

		if (fileFileName != null) {
			try {
				// 该文件就是存储在/upload目录下的文件
				File targetFile = new File(path, fileFileName);

				// 将源文件复制到目标文件中
				FileUtils.copyFile(file, targetFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return SUCCESS;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
