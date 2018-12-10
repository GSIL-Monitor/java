package com.uploadfile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 *	文件下载
 */
@Controller
public class FileDownloadController {

	@RequestMapping("download")
	public String downLoad(HttpServletResponse response){
		//1.获取要下载的文件的绝对路径
		//String realPath = this.getServletContext().getRealPath("/download/1.JPG");
		//2.获取要下载的文件名
		//String fileName = realPath.substring(realPath.lastIndexOf("\\")+1);

		String filename="2.gif";
		String filePath = "/Users/dx/ff" ;
		File file = new File(filePath + "/" + filename);
		//判断文件父目录是否存在
		if(file.exists()){
			//response.setContentType("application/force-download");
			//3.设置content-disposition响应头控制浏览器以下载的形式打开文件
			response.setHeader("Content-Disposition", "attachment;fileName=" + filename);

			//5.创建数据缓冲区
			byte[] buffer = new byte[1024];
			//文件输入流
			FileInputStream fis = null;
			BufferedInputStream bis = null;

			OutputStream os = null; //输出流
			try {
				//6.通过response对象获取OutputStream流
				os = response.getOutputStream();
				//4.获取要下载的文件输入流
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				//7.将FileInputStream流写入到buffer缓冲区
				int i = bis.read(buffer);
				while(i != -1){
					//8.使用OutputStream将缓冲区的数据输出到客户端浏览器
					os.write(buffer);
					i = bis.read(buffer);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("----------file download" + filename);
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
