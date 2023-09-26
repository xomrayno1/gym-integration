package com.app.dto;

import java.io.Serializable;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MailMessageDTO implements Serializable{
	private static final long serialVersionUID = 8782286853721644641L;
	
	private String to;
	private String toName;
	private String subject;
	private String content;
	private Map<String, Object> params;
	public MailMessageDTO(String to,  String subject, Map<String, Object> params) {
		this.to = to;
		this.subject = subject;
		this.params = params;
	}

}
