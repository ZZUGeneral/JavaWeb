/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.12
 * Generated at: 2018-11-30 00:09:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.applicant;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.qst.itoffer.dao.ResumeDAO;
import com.qst.itoffer.bean.ResumeBasicinfo;
import com.qst.itoffer.bean.Applicant;

public final class resume_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("jar:file:/F:/JavaWeb/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/QST_ITOFFER/WEB-INF/lib/taglibs-standard-impl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1384339662000L));
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.1.jar", Long.valueOf(1541214165735L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.qst.itoffer.bean.ResumeBasicinfo");
    _jspx_imports_classes.add("com.qst.itoffer.dao.ResumeDAO");
    _jspx_imports_classes.add("com.qst.itoffer.bean.Applicant");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"/error.jsp", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write(" \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>我的简历 - 锐聘网</title>\r\n");
      out.write("<base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("<link href=\"css/base.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<link href=\"css/resume.css\" type=\"text/css\" rel=\"stylesheet\" />\r\n");
      out.write("<meta\r\n");
      out.write("\tcontent=\"大学生求职,大学生就业,大学生招聘,IT人才,IT人才招聘,大学生名企招聘,,大学生找工作,IT名企招聘，IT行业招聘，IT企业快速入职\"\r\n");
      out.write("\tname=\"keywords\">\r\n");
      out.write("<meta\r\n");
      out.write("\tcontent=\"锐聘专注于为企业提供高效的人力资源解决方案，同时面向IT类技术人才推出快速一站式免费就业服务。秉承QST青软实训人才服务理念，为数千家企业量身定做个性化、全程化的人才培养体系，同时帮助中高级人才铺设成功之路，为人才和企业架设起沟通之桥。\"\r\n");
      out.write("\tname=\"description\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../top.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 从request对象中获取一个JavaBean对象 -->\r\n");
      out.write("\t");
      com.qst.itoffer.bean.ResumeBasicinfo basicinfo = null;
      basicinfo = (com.qst.itoffer.bean.ResumeBasicinfo) _jspx_page_context.getAttribute("basicinfo", javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      if (basicinfo == null){
        basicinfo = new com.qst.itoffer.bean.ResumeBasicinfo();
        _jspx_page_context.setAttribute("basicinfo", basicinfo, javax.servlet.jsp.PageContext.REQUEST_SCOPE);
      }
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- 我的简历页面开始 -->\r\n");
      out.write("\t<div class=\"resume_con\">\r\n");
      out.write("\t\t<!--tab设置-->\r\n");
      out.write("\t\t<div class=\"user_operate\">\r\n");
      out.write("\t\t\t<ul style=\"float: left\">\r\n");
      out.write("\t\t\t  <li> <a href=\"ResumeBasicinfoServlet?type=select\">我的简历</a></li>\r\n");
      out.write("              <li class=\"tn-tabs-selected\"> <a href=\"JobApplyServlet?type=myapply\">我的申请</a></li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<!--主体部分-->\r\n");
      out.write("\t\t<div class=\"resume_main\">\r\n");
      out.write("\t\t\t<!--左边-->\r\n");
      out.write("\t\t\t<div class=\"resume_left\">\r\n");
      out.write("\t\t\t\t<div class=\"resume_title\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float: left\">基本信息</div>\r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t\t");
      if (_jspx_meth_c_005fif_005f1(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"all_resume\">\r\n");
      out.write("\t\t\t\t\t<div class=\"table_style\">\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">姓名：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.realName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">性别：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.gender }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">出生日期：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.birthday }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">当前所在地：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.currentLoc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">户口所在地：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.residentLoc }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">手机：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.telephone }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">邮件：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.email }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">求职意向：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.jobIntension }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t\t<table width=\"300\" border=\"0\" cellpadding=\"3\" cellspacing=\"1\"\r\n");
      out.write("\t\t\t\t\t\t\tbgcolor=\"#EEEEEE\">\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"110\" align=\"right\" bgcolor=\"#F8F8F8\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tstyle=\"color: gray;\">工作经验：</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td bgcolor=\"#F8F8F8\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${basicinfo.jobExperience }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"he\"></div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div style=\"float: right\" class=\"uploade\">\r\n");
      out.write("\t\t\t\t\t\t");
 if("".equals(basicinfo.getHeadShot()) || null==basicinfo.getHeadShot()){ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<img src=\"applicant/images/anonymous.png\">\r\n");
      out.write("\t\t\t\t\t\t");
 }else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<img src=\"applicant/images/");
      out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((com.qst.itoffer.bean.ResumeBasicinfo)_jspx_page_context.findAttribute("basicinfo")).getHeadShot())));
      out.write("\" width=\"140\" height=\"140\">\r\n");
      out.write("\t\t\t\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<p>&nbsp;</p>\r\n");
      out.write("\t\t\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"applicant/resumeBasicInfoPicUpload.jsp\" class=\"uploade_btn\">更换照片</a>\r\n");
      out.write("\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"clear\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"resume_title\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float: left\">教育经历</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn\">添加</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"it-table-grid\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"tn-border-gray tn-border-bottom it-table-grid-header\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-name\">毕业院校</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-date\">就读时间</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-degree\">学历</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-fieldofstudy\">专业</p>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"resume_title\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float: left\">项目经验</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn\">添加</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"it-table-grid\">\r\n");
      out.write("\t\t\t\t\t<ul>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"tn-border-gray tn-border-bottom it-table-grid-header\">\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-name\">项目名称</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-date\">参与时间</p>\r\n");
      out.write("\t\t\t\t\t\t\t<p class=\"tn-degree\">担任职位</p>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"resume_title\">\r\n");
      out.write("\t\t\t\t\t<div style=\"float: left\">简历附件</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"btn\">添加</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"it-table-grid\">\r\n");
      out.write("\t\t\t\t\t<div class=\"it-table-grid\">暂无附件！</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<!-- 右侧公共部分：简历完善度 -->\r\n");
      out.write("\t\t\t<iframe src=\"applicant/resume_right.jsp\" width=\"297\" height=\"440\"\r\n");
      out.write("\t\t\t\tscrolling=\"no\" frameborder=\"0\"></iframe>\r\n");
      out.write("\t\t\t<div style=\"clear: both\"></div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<!-- 我的简历页面结束 -->\r\n");
      out.write("\t<!-- 网站公共尾部 -->\r\n");
      out.write("\t<iframe src=\"foot.html\" width=\"100%\" height=\"150\" scrolling=\"no\"\r\n");
      out.write("\t\tframeborder=\"0\"></iframe>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f0_reused = false;
    try {
      _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f0.setParent(null);
      // /applicant/resume.jsp(47,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty sessionScope.SESSION_RESUMEID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
      if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \r\n");
          out.write("\t\t\t\t\t<div class=\"btn\">\r\n");
          out.write("\t\t\t\t\t\t<a href=\"applicant/resumeBasicInfoAdd.jsp\">添加</a>\r\n");
          out.write("\t\t\t\t\t</div>");
          int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      _jspx_th_c_005fif_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f0_reused);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    boolean _jspx_th_c_005fif_005f1_reused = false;
    try {
      _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
      _jspx_th_c_005fif_005f1.setParent(null);
      // /applicant/resume.jsp(51,5) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty sessionScope.SESSION_RESUMEID }", boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null)).booleanValue());
      int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
      if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write(" \r\n");
          out.write("\t\t\t\t\t<div class=\"btn\">\r\n");
          out.write("\t\t\t\t\t\t<a href=\"ResumeBasicinfoServlet?type=updateSelect\">修改</a>\r\n");
          out.write("\t\t\t\t\t</div>");
          int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      _jspx_th_c_005fif_005f1_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fif_005f1, _jsp_getInstanceManager(), _jspx_th_c_005fif_005f1_reused);
    }
    return false;
  }
}