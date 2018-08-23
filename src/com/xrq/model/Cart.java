package com.xrq.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	private String key="";
	private HashMap<String,String> hm = new HashMap<String,String>();
	
	public void addItem(String bookId,String num)
	{
	
		if(bookId!=null)  
		{
			
			hm.put(bookId, num);  //书籍ID和数量，数量默认为1
		}
	}
	
	public void delItem(String bookId)
	{
		if(bookId!=null)
		{
			hm.remove(bookId);
		}
	}
	
	public void delAll()
	{
			hm.clear();
	}
	
	public String displayItem()
	{
		key="";
		Set<String> keySet = hm.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext())
		{
			key+="'"+iter.next()+"'";
			if(iter.hasNext())
			{
				key+=",";
			}
		}
		System.out.println("keySet: "+key);
		return key;
	}
}
