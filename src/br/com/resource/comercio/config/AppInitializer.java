package br.com.resource.comercio.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {//configura componentes externos, como hiber, jstl...
		return new Class[] {
			HibernateConfig.class
		};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {//configura mvc do spring
		return new Class[] {
			WebMvcConfig.class	
		};
	}

	@Override
	protected String[] getServletMappings() {//configura uri dos servlets
		return new String[] {
			"/"
		};
	}

}
