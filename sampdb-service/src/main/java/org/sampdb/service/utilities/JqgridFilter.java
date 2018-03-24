package org.sampdb.service.utilities;

import java.util.ArrayList;

public final class JqgridFilter {
	private String source;
	private String groupOp;
	private ArrayList<Rule> rules;
	
	public JqgridFilter() {
		super();
	}
	
	public JqgridFilter(String source) {
		super();
		this.source = source;
	}
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getGroupOp() {
		return groupOp;
	}

	public void setGroupOp(String groupOp) {
		this.groupOp = groupOp;
	}

	public ArrayList<Rule> getRules() {
		return rules;
	}

	public void setRules(ArrayList<Rule> rules) {
		this.rules = rules;
	}
	
}
