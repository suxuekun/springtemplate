package com.techstudio.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.FormParam;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import org.apache.log4j.Logger;
import com.techstudio.common.AjaxListResponse;
import com.techstudio.common.PictureUploadHandler;
import com.techstudio.model.Groomer;
import com.techstudio.sectest.dao.GroomerDao;
import com.techstudio.util.ConnConfig;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value= "/groomer")
public class GroomerController {
	
	@Autowired
	private GroomerDao groomerDao;
	
	@Autowired
	private PictureUploadHandler pictureUploadHandler;
	
	private static final Logger logger = Logger.getLogger(GroomerController.class);
	
	private static final String FOLDER = "groomer/";
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}."+locale.toString());
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

    @RequestMapping(value = {"/admin"}, method = RequestMethod.GET)
    public String admin(Model model) {
        model.addAttribute("title", "Admin - Spring Security Hello World");
        model.addAttribute("message", "This is protected page!");
        return "admin";
    }
    @RequestMapping(value = {"/view"}, method = RequestMethod.GET)
    public String view(Model model)
    {
    	return FOLDER+"viewpage";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model)
    {
    	return FOLDER+"addpage";
    }
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(HttpServletRequest request){
    	Map<String, Object> m = request.getParameterMap();
    	ObjectMapper mapper = new ObjectMapper();
		String content = "";
		try {
			content = mapper.writeValueAsString(m);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(content);
    	return content;
    }
    
    @ResponseBody
    @RequestMapping(value = "/ajax_add_min")
    public String addonemin(@RequestParam("title") String title)
    {
    	logger.info(title);
    	Groomer entity = new Groomer();
    	entity.setTitle(title);
    	groomerDao.save(entity);
    	return entity.getId().toString();
    }
    
    @ResponseBody
    @RequestMapping(value = "/addone")
    public String addOne(@RequestParam("title") String title,
    		@RequestParam("quote") String quote,
    		@RequestParam("logo") String logo,
    		@RequestParam("author") String author,
    		@RequestParam("type") String type)
    {
    	logger.info("abc");
    	logger.info(author);
    	Groomer entity = new Groomer();
    	entity.setAuthor( author);
    	entity.setLogo(logo);
    	entity.setQuote(quote);
    	entity.setType(type);
    	entity.setTitle(title);
    	groomerDao.save(entity);
		ObjectMapper mapper = new ObjectMapper();
		String content = "";
		try {
			content = mapper.writeValueAsString(entity);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return content;
    }
    
	@ResponseBody
	@RequestMapping(value = "/ajax_list", headers = "Accept=application/json",produces="application/json;charset=utf-8")
	public AjaxListResponse ajax_list(Model model, String sEcho, int iDisplayStart, int iDisplayLength,HttpServletRequest req) {

		long recordNo = groomerDao.countAll();
		AjaxListResponse resp = new AjaxListResponse();
		resp.setsEcho(sEcho);
		resp.setiTotalRecords(recordNo);
		resp.setiTotalDisplayRecords(recordNo);

		logger.info(iDisplayStart);
		logger.info(iDisplayLength);
		logger.info(req.getParameterMap().toString());
		List<Groomer> list = groomerDao.listAll(iDisplayStart, iDisplayLength);
		List<Map<String, Object>> aaList = new LinkedList<Map<String, Object>>();
		for (Groomer r : list) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("0", r.getTitle());
			m.put("1", r.getType());
			m.put("2", r.getQuote());
			m.put("3", r.getAuthor());
			m.put("4", r.getLogo());
			m.put("DT_RowId", r.getId());
			aaList.add(m);
		}

		resp.setAaData(aaList);
		return resp;
	}
	
	@ResponseBody
	@RequestMapping(value = "/remove", method = RequestMethod.POST,headers = "Accept=text/plain",produces="text/plain;charset=utf-8")
	public String remove(HttpServletRequest req, 
			@RequestParam("id") String idString) {
		String[] splitId = null;
		splitId = idString.split(",");
		
		try{
			for (String id:splitId)
			{
				groomerDao.delete(Long.parseLong(id));
			}
			return "success";
		}
		catch(Exception e)
		{
			return "fail";
		}

	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model,@RequestParam("id") long pageid)
	{
		Groomer groomer = groomerDao.get(pageid);
		model.addAttribute("title",groomer.getTitle());
		model.addAttribute("type",groomer.getType());
		model.addAttribute("quote",groomer.getQuote());
		model.addAttribute("author",groomer.getAuthor());
		model.addAttribute("logo",ConnConfig.getUploadedImageUrl(groomer.getLogo()));
		model.addAttribute("pageId",groomer.getId());
		return FOLDER+"editpage";
	}
	
	@ResponseBody
	@RequestMapping(value = "/upload")
	public String upload(Model model,HttpServletRequest req,
			@RequestParam String title,
			@RequestParam String pageIdIn,
			@RequestParam String type,
			@RequestParam String author,
			@RequestParam String quote,
			@RequestParam(required=false) MultipartFile[] uploadIcon){
		
		try {

			Groomer groomer = groomerDao.get(Long.parseLong(pageIdIn));
			if (groomer == null) return "fail";

			String logo = "";
			if(!StringUtils.isBlank(uploadIcon[0].getOriginalFilename()))
				logo = pictureUploadHandler.getIMGUrlWithUpload(uploadIcon, req);
			logger.info(logo);
			groomer.setType(type);
			groomer.setLogo(logo);
			groomer.setQuote(quote);
			groomer.setTitle(title);
			groomer.setAuthor(author);
			
			groomerDao.update(groomer);
			
			
		}
		catch(Exception e)
		{
			return "fail";
		}
		
	return "success";
	}
}
