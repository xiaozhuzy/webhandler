package com.huasheng.webhandler.provider.impl;

import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.huasheng.webhandler.config.ActionConfig;
import com.huasheng.webhandler.config.Configuration;
import com.huasheng.webhandler.config.PackageConfig;
import com.huasheng.webhandler.config.ResultConfig;
import com.huasheng.webhandler.core.Action;
import com.huasheng.webhandler.core.ContainerBuilder;
import com.huasheng.webhandler.core.Scope;
import com.huasheng.webhandler.exception.ConfigurationException;
import com.huasheng.webhandler.provider.ConfigurationProvider;
import com.huasheng.webhandler.util.ClassLoaderUtil;
import com.huasheng.webhandler.util.StringUtil;


public class XmlConfigurationProvider implements ConfigurationProvider {
	
	private Document document;

	private String configFileName;
	
    protected Map<String, PackageConfig> packageConfigMaps = new LinkedHashMap<String, PackageConfig>();

	// private ObjectFactory objectFactory;

	private Configuration configuration;

	public XmlConfigurationProvider(String configFileName) {
		this.configFileName = configFileName;
	}

	@Override
	public void init(Configuration configuration) {
		this.configuration = configuration;
		loadDocuments(configFileName);

	}

	@Override
	public void register(ContainerBuilder builder) {

//		webhandler-default.xml
		// 获取根节点 webhandler
		Element root = this.document.getRootElement(); 

		// 获取根节点下的子节点bean
		List<Element> nodes = root.elements("bean");
		
		for (Iterator<Element> ie = root.elementIterator(); ie.hasNext();) {
           
            Element element = (Element) ie.next();
            
			if("bean".equals(element.getName())){
            	
            	String name = element.attributeValue("name");
            	String type = element.attributeValue("type");
            	String clazz = element.attributeValue("class");
            	String scopeStr = element.attributeValue("scope");
            	
            	Scope scope = Scope.SINGLETON;
            	
            	if("prototype".equals(scopeStr)){
            		scope = scope.PROTOTYPE;
            	} else if("thread".equals(scopeStr)){
            		scope = Scope.THREAD;
            	} 
            	
            	Class cimpl = ClassLoaderUtil.loadClass(clazz, getClass());
            	
            	builder.factory(cimpl, name, scope);
            	
            } else if("package".equals(element.getName())){
            	
                PackageConfig packageConfig = addPackage(element);
                
                packageConfigMaps.put(packageConfig.getName(),packageConfig);
            }
		}

	}
	
	private PackageConfig addPackage(Element element){
		
		PackageConfig packageConfig = new PackageConfig();
		
		String packageName = element.attributeValue("name");
		String packageNamespace = element.attributeValue("namespace");
		
		packageConfig.setName(packageName);
		packageConfig.setNamespace(packageNamespace);
		packageConfig.setActionConfigMap(addAction(element));
		
		configuration.addPackageConfig(packageName, packageConfig);
		
		return packageConfig;
	}

	
	private Map<String,ActionConfig> addAction(Element element){

		List<Element> actionNodes = element.elements("action");
		
		Map<String,ActionConfig> actionConfigMaps = new LinkedHashMap<String,ActionConfig>();
		
		for (Element actionNode : actionNodes) {
			String actionName = actionNode.attributeValue("name");
			String actionClassName = actionNode.attributeValue("class");
			String actionMethod = actionNode.attributeValue("method");
			
			if(StringUtil.isEmpty(actionMethod)) {
				actionMethod = Action.EXECUTE;
			}
			
			ActionConfig actionConfig = new ActionConfig();
			actionConfig.setName(actionName);
			actionConfig.setClassName(actionClassName);
			actionConfig.setMethod(actionMethod);
			actionConfig.setResults(addResult(actionNode));
			actionConfigMaps.put(actionName, actionConfig);
		}
		
		return actionConfigMaps;
		
	}
	
	private Map<String, ResultConfig> addResult(Element actionNode){
		Map<String, ResultConfig> results = new LinkedHashMap<String, ResultConfig>();
		
		List<Element> resultNodeList = actionNode.elements("result");
		for (Element element : resultNodeList) {
			
			ResultConfig resultConfig = new ResultConfig();
			
			String name = element.attributeValue("name");
			
			if(StringUtil.isEmpty(name)){
				name = Action.SUCCESS;
			}
			resultConfig.setName(name);
			resultConfig.setLocation(element.getText());
			
			results.put(name,resultConfig);
			
		}
		return results;
	}

	@Override
	public void loadPackages() throws ConfigurationException {
		// TODO Auto-generated method stub

	}

	private void loadDocuments(String configFileName) {
		try {
			InputStream is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(configFileName);
			SAXReader saxReader = new SAXReader();
			document = saxReader.read(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Map<String,PackageConfig> getPackageConfigMaps(){
		return this.packageConfigMaps;
	}

}
