package com.cust.qmsys.servlet.question;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class UpImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request, response); // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String filename = "";
        String imagename = request.getParameter("image");
        String message = "";
        String savePath = this.getServletContext().getRealPath("/picture");
        String tempPath = this.getServletContext().getRealPath("/temp");
        File tmpFile = new File(tempPath);


        if (tmpFile.exists()) {
            tmpFile.mkdir();
        }
        try {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(1024 * 100);
            factory.setRepository(tmpFile);
            ServletFileUpload uplode = new ServletFileUpload(factory);
            uplode.setProgressListener(new ProgressListener() {
                @Override
                public void update(long l, long l1, int i) {
                    System.out.println("�ļ���СΪ��" + l1 + "��ǰ�Ѵ���" + l);
                }
            });
            uplode.setHeaderEncoding("UTF-8");
            uplode.setFileSizeMax(1024 * 1024);
            List<FileItem> list = uplode.parseRequest(new ServletRequestContext(request));
            for (FileItem item : list) {
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    System.out.println(name);
                    String value = item.getString("utf-8");
                    System.out.println(name + "�ļ��ϴ���ͨ��" + value);
                } else {
                    filename = item.getName();
                    System.out.println(filename + "�ļ�����");
                    if (filename == null || filename.equals("")) {
                        continue;
                    }
//                    filename = filename.substring(filename.lastIndexOf("\\" + 1));
                    String filextname = filename.substring(filename.lastIndexOf(".") + 1);
                    System.out.println("�ļ���չ����" + filextname);
                    InputStream in = item.getInputStream();
                    String savename = filename;

                    FileOutputStream out = new FileOutputStream(savePath + "\\" + savename);
                    byte buffer[] = new byte[1024];
                    int len = 0;
                    while ((len = in.read(buffer)) > 0) {
                        out.write(buffer, 0, len);
                    }
                    in.close();
                    out.close();
                    message = "�ļ��ϴ��ɹ�";
                }
            }

        } catch (FileUploadBase.FileSizeLimitExceededException e) {
            e.printStackTrace();
            message = "�����ļ��������ֵ������";
            response.setCharacterEncoding("utf-8");
            response.getWriter().print("<script>parent.callback('" + message + "')</script>");
            response.getWriter().flush();
            response.getWriter().close();


        } catch (FileUploadBase.SizeLimitExceededException e) {
            e.printStackTrace();
            message = "�ϴ��ļ����ܵĴ�С�������Ƶ����ֵ����";
            response.setCharacterEncoding("utf-8");

            response.getWriter().print("<script>parent.callback('" + message + "')</script>");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();
            message = "�ϴ�ʧ��";
            response.getWriter().print("<script>parent.callback('" + message + "')</script>");
            response.getWriter().flush();
            response.getWriter().close();
        }

        response.setCharacterEncoding("utf-8");
        try {
            response.getWriter().print("<script>parent.callback('" + message + "')</script>");
            response.getWriter().flush();
            response.getWriter().close();
        } catch (Exception e) {
            e.printStackTrace();// TODO: handle exception
        }

    }
}


