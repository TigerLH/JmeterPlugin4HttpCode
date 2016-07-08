package com.hcb.jmeter;

import javax.swing.JTable;

import org.apache.jmeter.testelement.TestElement;
import org.apache.jmeter.visualizers.gui.AbstractListenerGui;

/** 
 * @author  linhong: 
 * @date 2016��5��10�� ����11:41:42 
 * @Description: GUI���߼����Ʒ���ģʽ:GUIģ��
 * @version 1.0  
 */
public class HttpCodeReportGUI extends AbstractListenerGui{
	public static JTable table = null;
    public HttpCodeReportGUI(){
        init();
    }

    @Override
    public void configure(TestElement element) {
         super.configure(element);
    }

    private void init() {
    	HttpCodePanel httpCodePanel = new HttpCodePanel();
    	add(httpCodePanel);
    }

    @Override
    public TestElement createTestElement() {
        TestElement report = new HttpCodeReport();
        modifyTestElement(report);
        return report;
    }

    @Override
    public String getLabelResource() {
        // TODO Auto-generated method stub
        return this.getClass().getSimpleName();
    }

    @Override
    public void modifyTestElement(TestElement report) {
        super.configureTestElement(report);
    }

    @Override   
    public String getStaticLabel() {//������ʾ����
        // TODO Auto-generated method stub
        return "HttpCode Reporter";
    }



    @Override
    public void clearGui() {
        super.clearGui();
    }

}