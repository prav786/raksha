package rhok.medical.model;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.*;

import rhok.medical.model.server.DisasterManagementService;
import rhok.medical.model.shared.DisasterAlert;
import rhok.medical.model.shared.Supplier;

@SuppressWarnings("serial")
public class Rhokproject1Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String method=req.getParameter("method");
		DisasterManagementService disasterService = new DisasterManagementService();
		
		if(method.equalsIgnoreCase("getavailablestores")) {
			String location=req.getParameter("location");
			String radius=req.getParameter("radius");
			if(radius==null||radius.isEmpty()){
				radius="50";
			}
			
			List<Supplier> suppliers=disasterService.getAvailableStores(location, "50", "diabetic");
			resp.setContentType("application/json");
			resp.getWriter().println(suppliers);
		} else if(method.equalsIgnoreCase("getdisasteralert")) {
			String location=req.getParameter("location");
			String radius=req.getParameter("radius");
			if(radius==null||radius.isEmpty()){
				radius="50";
			}
			
			DisasterAlert disasterAlert=disasterService.getDisasterAlert(32,52, 50, 111);
			resp.setContentType("application/json");
			resp.getWriter().println(disasterAlert);
		}
		
	}
}
