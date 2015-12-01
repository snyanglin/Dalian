package com.founder.xjpt.com.founder.noreas.hotPoint.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.founder.xjpt.com.founder.noreas.hotPoint.service.SingleParamHotDotServer;

@SuppressWarnings("serial")
public class SingleParamHotDotServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unchecked")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//坐标数据 
			List<String> zbArr=(List<String>)request.getSession().getAttribute("alermAnalyse_hotPic_zbArr");
			double mins = Double.parseDouble(request.getParameter("MINS"));
			//点坐标范围
			String[] bbox = request.getParameter("BBOX").split(",");
			int width = Integer.parseInt(request.getParameter("WIDTH"));
			//透明度
			int alpha = Integer.parseInt(request.getParameter("ALPHA"));
			//点精度处理
			double[] enve = getEnve(bbox);
			double resolution = (enve[2] - enve[0]) / width;
			double radius = 15.0D * resolution;
			String enveStr = enve[0] + "," + enve[2] + "," + enve[1] + ","+ enve[3];
			//点坐标处理
			List list = new ArrayList();
			if(zbArr!=null){
				for(int i=0;i<zbArr.size();i++){
					String[] zb=zbArr.get(i).split(",");
					if(zb.length!=2||zb[0]==null||zb[1]==null||"".equals(zb[0])||"".equals(zb[1])||"null".equals(zb[0])||"null".equals(zb[1]))continue;
					double x = Double.parseDouble(zb[0]);
					double y = Double.parseDouble(zb[1]);
					if(x<enve[0]||x>enve[2]||y<enve[1]||y>enve[3])continue;
					list.add(new double[] { x, y });
				}
			}

			SingleParamHotDotServer spHotPotServer = new SingleParamHotDotServer();
			//颜色分级 绿 黄 红
			String color="00ff00:0,ffff00:1,ff0000:2";
			String url = spHotPotServer.getHotPotPic(getXY(list), enveStr, resolution, radius, getColorMap(color, getLevel(mins, resolution)), alpha);
			FileInputStream fis = new FileInputStream(url);
			int size = fis.available();
			byte[] data = new byte[size];
			fis.read(data);
			fis.close();
			response.setContentType("image/png");
			OutputStream os = response.getOutputStream();
			os.write(data);
			os.flush();
			os.close();
		} catch (NumberFormatException nfe){
			System.out.println("传递的坐标值有错(非数字)，请检查");
			System.out.println("error "+nfe.getMessage());
		} catch (Exception e) {
			System.out.println("error "+e.getMessage());
		}
	}

	private double[][] getXY(List<double[]> list) {
		double[][] xy = new double[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			xy[i][0] = ((double[]) list.get(i))[0];
			xy[i][1] = ((double[]) list.get(i))[1];
		}
		return xy;
	}

	private double[] getEnve(String[] box) {
		double[] enve = new double[box.length];
		for (int i = 0; i < enve.length; i++) {
			enve[i] = Double.parseDouble(box[i]);
		}
		return enve;
	}
	@SuppressWarnings("unchecked")
	private HashMap<String, Integer> getColorMap(String color, int level) {
		HashMap colorMap = new HashMap();
		String[] colors = color.split(",");
		for (int i = 0; i < colors.length; i++) {
			String[] colorInfo = colors[i].split(":");
			colorMap.put(colorInfo[0], Integer.valueOf(Integer.valueOf(colorInfo[1]).intValue()* level));
		}
		return colorMap;
	}

	private int getLevel(double mins, double nows) {
		int level = 1;
		if (Math.round(nows / mins) != 1L) {
			nows /= 2.0D;
			level++;
		}
		return level;
	}
}
