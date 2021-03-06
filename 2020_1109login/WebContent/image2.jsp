<%@ page language="java" contentType="image/JPEG; charset=UTF-8"
    pageEncoding="gbk"%>
<%@ page import="java.awt.*, java.awt.image.*, java.util.*, javax.imageio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
		Color getRandColor(int fc,int bc) {		// 给定范围获取随机颜色
		Random random = new Random() ;
		if( fc > 255 ){
			fc = 255 ;
		}
		if( bc > 255 ){
			bc = 255 ;
		}
		
		int r = fc + random.nextInt(bc - fc) ;
		int g = fc + random.nextInt(bc - fc) ;
		int b = fc + random.nextInt(bc - fc) ;
		
		return new Color(r, g, b) ;
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
	// 设置页面不缓存
	response.setHeader("Pragma", "No-cache") ;
	response.setHeader("Cache-Control", "no-cache") ;	
	response.setDateHeader("Expires", 0) ;
	
	// 在内存中创建图像
	int width = 60 ;
	int height = 20 ;
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB) ;
	
	// 获取图形上下文
	Graphics g = image.getGraphics() ;
	
	// 生成随机类
	Random random = new Random() ;
	
	// 设定背景色
	g.setColor(getRandColor(200, 250)) ;
	g.fillRect(0, 0, width, height) ;
	
	// 设置字体
	g.setFont(new Font("Times New Roman", Font.PLAIN, 18)) ;
	
	// 画边框
	/* g.setColor(Color.red) ;
	g.drawRect(0, 0, width-1, height-1) ; */
	
	// 随机产生 155 条干扰线， 使图像中的验证码不易被其他程序探测到
	g.setColor(getRandColor(160, 200)) ;
	for(int i = 0; i < 100; i ++){
		int x = random.nextInt(width) ;
		int y = random.nextInt(height) ;
		int x1 = random.nextInt(40) ;
		int y1 = random.nextInt(40) ;
		
		g.drawLine(x, y, x+x1, y+y1) ;
	}
	
	// 取随机产生的验证码: 4位数
	String sRand = "" ;
	int StringX = (width-6)/4 ;
	int StringY = height-4 ;
	for(int i = 0; i < 4; i ++) {
		String rand = String.valueOf(random.nextInt(10)) ;
		sRand += rand ;
		
		// 将验证码显示到图片中
		g.setColor(new Color(10+random.nextInt(110), 20+random.nextInt(110), 20+random.nextInt(110))) ;
		g.drawString(rand, StringX*i + 6, StringY) ;
	}
	
	// 将验证码放到 SESSION 中
	session.setAttribute("system_yzm", sRand) ;
	
	//System.out.println("system_yzm: "+sRand) ;
	
	// 图像生效
	g.dispose() ;
	
	// 输出图像到页面
	ImageIO.write(image, "JPEG", response.getOutputStream()) ;
	out.clear() ;
	out = pageContext.pushBody() ;
%>
	
</body>
</html>