package com.hcb.jmeter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.jmeter.reporters.ResultCollector;
import org.apache.jmeter.samplers.SampleEvent;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/** 
 * @author  linhong: 
 * @date 2016��5��10�� ����11:40:22 
 * @Description: GUI���߼����Ʒ���ģʽ:�߼��ؼ�ģ��
 * @version 1.0  
 */
public class HttpCodeReport extends ResultCollector{
	private Map<String,Integer> map = new HashMap<String,Integer>();
	private String[] column = new String[]{"״̬��","����","����"};
	
	
	/**
	 * ��̬����Table
	 * @param map
	 */
	public void updataTable(Map<String,Integer> map){
		List<String> list = new ArrayList<String>();
		if(map==null){
			return;
		}
		for(String set:map.keySet()){
			list.add(set);
		}
		JTable table = HttpCodePanel.table;
		int rows = list.size();
		DefaultTableModel model = new DefaultTableModel(column, rows);
		table.setModel(model);
		for(int i=0;i<rows;i++){
			String code = list.get(i);
			table.setValueAt(code,i, 0);
			table.setValueAt(map.get(code), i, 1);
			table.setValueAt(HttpCode.codeMap.get(code), i, 2);
			System.out.println(map);
		}
		table.updateUI();
	}
	
	
	/**
	 * ��̬����Chart
	 * @param map
	 */
	public void updateChart(Map<String,Integer> map){
		ChartPanel chartPanel = HttpCodePanel.chartPanel;
		if(chartPanel.getChart()!=null){
			chartPanel.removeAll();
		}
		DefaultPieDataset dpd=new DefaultPieDataset(); //����һ��Ĭ�ϵı�ͼ
		for(String set:map.keySet()){
			dpd.setValue(set, map.get(set));
		}
        JFreeChart chart = ChartFactory.createPieChart("״̬��ֲ�",dpd,true,true,false);
        chartPanel.setChart(chart);
        chartPanel.updateUI();
	}
	
	
	
	@Override
	public void sampleOccurred(SampleEvent arg0) {
		String code = arg0.getResult().getResponseCode();
		if(map.containsKey(code)){
			int count = map.get(code);
			map.put(code, count+1);
		}else{
			map.put(code, 1);
		}
		updataTable(map);
		updateChart(map);
	}

	@Override
	public void sampleStarted(SampleEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void sampleStopped(SampleEvent arg0) {
		// TODO �Զ����ɵķ������
		
	}
		
	
}
