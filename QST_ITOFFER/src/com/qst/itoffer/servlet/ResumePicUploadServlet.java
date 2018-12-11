package com.qst.itoffer.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.qst.itoffer.bean.Applicant;
import com.qst.itoffer.dao.ResumeDAO;

/**
 * ����ͷ��ͼƬ�ϴ�
 * 
 * @author QST����ʵѵ
 *
 */
@WebServlet("/ResumePicUploadServlet")
@MultipartConfig
public class ResumePicUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ResumePicUploadServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Part part = request.getPart("headShot");
		System.out.println(part);
		String fileName = part.getSubmittedFileName();
		System.out.println("========" + fileName);
		String newFileName = System.currentTimeMillis() + fileName.substring(fileName.lastIndexOf("."));
		String filepath = getServletContext().getRealPath("/applicant/images");
		System.out.println("储存路径：" + filepath);
		File f = new File(filepath);
		if (!f.exists())
			f.mkdirs();
		part.write(filepath + "/" + newFileName);
		int resumeID = (Integer) request.getSession().getAttribute("SESSION_RESUMEID");
		ResumeDAO dao = new ResumeDAO();
		dao.updateHeadShot(resumeID, newFileName);
		response.sendRedirect("ResumeBasicinfoServlet?type=select");
	}

}
