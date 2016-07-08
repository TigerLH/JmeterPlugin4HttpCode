package com.hcb.jmeter;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;

/** 
 * @author  linhong:
 * @date 2016年5月13日 上午10:05:51
 * @Description: TODO
 * @version 1.0
 */
public class HttpCodePanel extends JPanel {
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTable table;
	private String[] column = new String[]{"状态码","数量","描述"};
	private JScrollPane scrollPane;
	public static  ChartPanel chartPanel;
	private JPanel panel;
	public HttpCodePanel() {
		Map<String,String> codeMap = HttpCode.codeMap;
		List<String> list = new ArrayList<String>();
		for(String set:codeMap.keySet()){
			list.add(set);
		}
		Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(902, 612);
		DefaultTableModel model = new DefaultTableModel(column, codeMap.size());
		JLabel lblNewLabel = new JLabel("HttpCode Reporter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		
		
	
		scrollPane = new JScrollPane();
		table = new JTable();
		scrollPane.setViewportView(table);
		scrollPane.setBorder(BorderFactory.createTitledBorder("状态码"));
		table.setModel(model);
		for(int i=0;i<HttpCode.codeMap.size();i++){
			String code = list.get(i);
			table.setValueAt(code,i, 0);
			table.setValueAt("", i, 1);
			table.setValueAt(HttpCode.codeMap.get(code), i, 2);
		}
		table.setBackground(getBackground());
		
		
		StandardChartTheme standardChartTheme=new StandardChartTheme("CN");  
	    //设置标题字体  
	    standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
	    //设置图例的字体  
	    standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
	    //设置轴向的字体  
	    standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));  
	    ChartFactory.setChartTheme(standardChartTheme);
        JFreeChart chart = ChartFactory.createPieChart("状态码分布",null,true,true,false);
        chartPanel = new ChartPanel(chart);
        chartPanel.setBackground(getBackground());
        chartPanel.setVisible(true);
        chartPanel.setBorder(BorderFactory.createTitledBorder("图形结果"));
		add(chartPanel);
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createTitledBorder("基本信息"));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE))
						.addComponent(lblNewLabel)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 892, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
						.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
					.addContainerGap())
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{30, 835, 0};
		gbl_panel.rowHeights = new int[]{21, 24, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel label = new JLabel("\u540D\u79F0:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		
		JLabel label_1 = new JLabel("\u6CE8\u91CA:");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.anchor = GridBagConstraints.NORTH;
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panel.add(textField_1, gbc_textField_1);
		setLayout(groupLayout);
	}
}
