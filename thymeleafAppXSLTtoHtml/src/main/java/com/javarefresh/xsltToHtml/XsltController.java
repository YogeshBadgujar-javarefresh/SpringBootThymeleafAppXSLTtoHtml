package com.javarefresh.xsltToHtml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
 * Main Controller class where request for
 * home page http://localhost:8080/javaRefresh/home
 * 
 * 
 * @author Yogesh Badgujar
 * email me in case any problem - badgujar.yogesh@gmail.com
 *
 */
@Controller
@RequestMapping("/javaRefresh")
public class XsltController {
	
	Logger logger = LoggerFactory.getLogger(XsltController.class);

	@GetMapping("/home")
	public String xsltToHtmlDefaultUI(Model model) {
		model.addAttribute("holder", new Holder());
		System.out.println("Inside the home");
		return "home";
	}

	@PostMapping("/xsltToHtml")
	public ModelAndView greetingSubmit(@ModelAttribute Holder holder) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			InputStream xsltIS = new ByteArrayInputStream(holder.getXsltValue().getBytes(StandardCharsets.UTF_8));
			InputStream xmlIS = new ByteArrayInputStream(holder.getXmlValue().getBytes(StandardCharsets.UTF_8));

			Source xslt = new StreamSource(xsltIS);
			Source xml = new StreamSource(xmlIS);

			StringWriter sw = new StringWriter();
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer trasform = tFactory.newTransformer(xslt);
			trasform.transform(xml, new StreamResult(sw));

			//System.out.println("Finally ==================>" + sw);
			//System.out.println("css ==================>" + holder.getCssValue());
			// Set the value in Holder
			boolean cssNotApplied = false;
			if(! holder.getCssValue().trim().isEmpty()) {
				String cssValue = "<html><head>" + holder.getCssValue() + "</head>";
				String finalHtmlValue = sw.toString().replace("<html>", cssValue);
				holder.setHtmlResult(finalHtmlValue);
			} else {
				holder.setHtmlResult(sw.toString());
				cssNotApplied = true;
			}
			
			if(cssNotApplied) {
				holder.setSpecialNote("Seems to be css not correctly provied or applied...");
			}
			
			modelAndView.setViewName("result");
			modelAndView.addObject("holder", holder);
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		
		return modelAndView;
	}
}
