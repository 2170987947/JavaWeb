<%@ page language="java" contentType="image/JPEG; charset=UTF-8"
    pageEncoding="gbk"%>
<%@ page import="java.awt.*, java.awt.image.*, java.util.*, javax.imageio.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%!
		Color getRandColor(int fc,int bc) {		// ������Χ��ȡ�����ɫ
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
	// ����ҳ�治����
	response.setHeader("Pragma", "No-cache") ;
	response.setHeader("Cache-Control", "no-cache") ;	
	response.setDateHeader("Expires", 0) ;
	
	// ���ڴ��д���ͼ��
	int width = 60 ;
	int height = 20 ;
	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB) ;
	
	// ��ȡͼ��������
	Graphics g = image.getGraphics() ;
	
	// ���������
	Random random = new Random() ;
	
	// �趨����ɫ
	g.setColor(getRandColor(200, 250)) ;
	g.fillRect(0, 0, width, height) ;
	
	// ��������
	g.setFont(new Font("Times New Roman", Font.PLAIN, 18)) ;
	
	// ���߿�
	/* g.setColor(Color.red) ;
	g.drawRect(0, 0, width-1, height-1) ; */
	
	// ������� 155 �������ߣ� ʹͼ���е���֤�벻�ױ���������̽�⵽
	g.setColor(getRandColor(160, 200)) ;
	for(int i = 0; i < 100; i ++){
		int x = random.nextInt(width) ;
		int y = random.nextInt(height) ;
		int x1 = random.nextInt(40) ;
		int y1 = random.nextInt(40) ;
		
		g.drawLine(x, y, x+x1, y+y1) ;
	}
	
	// ȡ�����������֤��: 4λ��
	String sRand = "" ;
	int StringX = (width-6)/4 ;
	int StringY = height-4 ;
	for(int i = 0; i < 4; i ++) {
		String rand = String.valueOf(random.nextInt(10)) ;
		sRand += rand ;
		
		// ����֤����ʾ��ͼƬ��
		g.setColor(new Color(10+random.nextInt(110), 20+random.nextInt(110), 20+random.nextInt(110))) ;
		g.drawString(rand, StringX*i + 6, StringY) ;
	}
	
	// ����֤��ŵ� SESSION ��
	session.setAttribute("system_yzm", sRand) ;
	
	//System.out.println("system_yzm: "+sRand) ;
	
	// ͼ����Ч
	g.dispose() ;
	
	// ���ͼ��ҳ��
	ImageIO.write(image, "JPEG", response.getOutputStream()) ;
	out.clear() ;
	out = pageContext.pushBody() ;
%>
	
</body>
</html>